/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author: 
 * @version: 2.0
 * @date:  2019年5月12日 上午10:25:52
*/
package com.liangliang.action;

import com.liangliang.entity.MsOrder;
import com.liangliang.entity.MsProductInfo;
import com.liangliang.entity.OnLine;
import com.liangliang.entity.cart.Cart;
import com.liangliang.service.MsOrderService;
import com.liangliang.service.MsProductInfoService;
import com.liangliang.service.pay.AliPay;
import com.liangliang.service.pay.WxPay;
import com.liangliang.service.pay.YlPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author:
 * @version: 2.0
 * @date:  2019年5月12日 上午10:25:52
 */
@Controller
@RequestMapping("orderAction")
public class OrderAction {

	@Autowired
	MsOrderService msOrderService;

	@Autowired
	MsProductInfoService msProductInfoService;

	@Autowired
	AliPay aliPay;

	@Autowired
	WxPay wxPay;

	@Autowired
	YlPay ylPay;

	/**
	 *
	 * @description: 功能描述： (跳转到支付页面)
	 * @author: liangliang
	 * @version: 2.0
	 * @date:  2019年5月12日 下午8:13:05
	 * @param request
	 *            1，代表支付宝 2,代表微信，3,代表银联
	 * @param tradeId
	 * @param payAmount
	 * @return
	 */
	@RequestMapping(value = "cartToOrder")
	public String cartToOrder(HttpServletRequest request, Integer id,  Integer payAmount) {
        HttpSession session = request.getSession();
        OnLine onLine = (OnLine) session.getAttribute("onLine");
        if (onLine == null) {
            return "redirect:/";
        }
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Integer total = (int)cart.getTotal();
        Integer userId = onLine.getMsUser().getId();


        //在购物车页面有点击提交订单 ，
        MsOrder msOrder =  new MsOrder();
        msOrder.setUserId(userId);
        msOrder.setPayAmount(total);

        //设置订单号
        String tradeId = UUID.randomUUID().toString();
        msOrder.setTradeId(tradeId);


        //设置状态
        msOrder.setPayStatus(1);

        //设置时间
        Date now = new Date();
        msOrder.setCreateTime(now);
        msOrderService.insert(msOrder);
        request.getSession().removeAttribute("cart");
        //提交成功订单  清空 购物车
		return "redirect:/orderAction/queryOrderByUserId";

	}







	/**
	 *
	 * @description: 功能描述： (跳转到支付页面)
	 * @author: liangliang
	 * @version: 2.0
	 * @date:  2019年5月12日 下午8:13:05
	 * @param request
	 *            1，代表支付宝 2,代表微信，3,代表银联
	 * @param tradeId
	 * @param payAmount
	 * @return
	 */
	@RequestMapping(value = "toPayWithOrder")
	public String toPayWithOrder(HttpServletRequest request, Integer id, String tradeId, Integer payAmount) {
		request.setAttribute("id", id);
		request.setAttribute("tradeId", tradeId);
		request.setAttribute("payAmount", payAmount);
		return "order/payReal";

	}

	/**
	 * 
	 * @description: 功能描述： (用户退款)
	 * @author: liangliang
	 * @version: 2.0
	 * @date:  2019年5月12日 下午2:29:38
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "applyRefund")
	public String applyRefund(HttpServletRequest request, Integer orderId, Integer payType) {

		HttpSession session = request.getSession();
		OnLine onLine = (OnLine) session.getAttribute("onLine");
		if (onLine == null) {
			return "redirect:/";
		}
		msOrderService.updateOrderStatusById(4, orderId, payType);
		return "redirect:queryOrderByUserId";

	}

	/**
	 * 
	 * @description: 功能描述： (商户审核退款)
	 * @author: liangliang
	 * @version: 2.0
	 * @date:  2019年5月12日 下午2:29:38
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "auditRefund")
	public String auditRefund(HttpServletRequest request, String tradeId, Integer payAmount, Integer orderId,
			Integer payType, Integer payStatus) {

		HttpSession session = request.getSession();
		OnLine onLine = (OnLine) session.getAttribute("onLine");
		if (onLine == null) {
			return "redirect:/";
		}

		if (payStatus == 3) {
			int payStatusTemp = 2;
			// 支付宝
			if (payType == 1) {
				payStatusTemp = aliPay.refundOrder(tradeId, payAmount);
				// 微信
			} else if (payType == 2) {
				payStatusTemp = wxPay.refundOrder(tradeId, payAmount);
				// 银联
			} else if (payType == 3) {
				payStatusTemp = ylPay.refundOrder(tradeId, payAmount);
			}

			// 如果退款成功
			if (payStatusTemp == 1) {
				msOrderService.updateOrderStatusById(payStatus, orderId, payType);
			}

		} else if (payStatus == 5) {
			msOrderService.updateOrderStatusById(payStatus, orderId, payType);
		}

		return "order/orderListByMer";

	}

	/**
	 * 
	 * @description: 功能描述： (通过用户id查询订单)
	 * @author: liangliang
	 * @version: 2.0
	 * @date:  2019年5月12日 下午2:29:38
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "orderListByMerId")
	public String orderListByMerId(HttpServletRequest request) {

		HttpSession session = request.getSession();
		OnLine onLine = (OnLine) session.getAttribute("onLine");
		if (onLine == null) {
			return "redirect:/";
		}
		Integer merchantId = onLine.getMsMerchant().getId();

		List<MsOrder> orderList = msOrderService.queryOrderListByMerId(merchantId);
		request.setAttribute("orderList", orderList);
		return "order/orderListByMer";

	}

	/**
	 * 
	 * @description: 功能描述： ()
	 * @author: liangliang
	 * @version: 2.0
	 * @date:  2019年5月12日 下午8:13:05
	 * @param request
	 * @param payType
	 *            1，代表支付宝 2,代表微信，3,代表银联
	 * @param tradeId
	 * @param payAmount
	 * @return
	 */
	@RequestMapping(value = "orderPay", method = RequestMethod.POST)
	public String orderPay(HttpServletRequest request, Integer payType, Integer id, String tradeId, Integer payAmount) {

		Integer payStatus = 2;
		// 支付宝
		if (payStatus == 1) {
			payStatus = aliPay.payOrder(tradeId, payAmount);
			// 微信
		} else if (payStatus == 2) {
			payStatus = wxPay.payOrder(tradeId, payAmount);
			// 银联
		} else if (payStatus == 3) {
			payStatus = ylPay.payOrder(tradeId, payAmount);
		}

		// 如果支付成功
		if (payStatus == 1) {
			msOrderService.updateOrderStatusById(2, id, payType);

		}
		return "redirect:queryOrderByUserId";

	}

	/**
	 * 
	 * @description: 功能描述： (通过用户id查询订单)
	 * @author: liangliang
	 * @version: 2.0
	 * @date:  2019年5月12日 下午2:29:38
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "queryOrderByUserId")
	public String queryOrderByUserId(HttpServletRequest request) {

		HttpSession session = request.getSession();
		OnLine onLine = (OnLine) session.getAttribute("onLine");
		if (onLine == null) {
			return "redirect:/userRegAndLogAction/toLogin";
		}

		Integer userId = onLine.getMsUser().getId();
		List<MsOrder> orderList = msOrderService.queryOrderByUserId(userId);
		request.setAttribute("orderList", orderList);
		return "order/orderList";

	}

	@RequestMapping(value = "payOrder", method = RequestMethod.POST)
	public String payOrder(HttpServletRequest request, MsOrder msOrder) {
		Date now = new Date();
		msOrder.setCreateTime(now);
		int payStatus = 1;
		msOrder.setPayStatus(payStatus);
		String tradeId = UUID.randomUUID().toString();
		msOrder.setTradeId(tradeId);

		msOrderService.insert(msOrder);
		return "redirect:/";

	}

	@RequestMapping("toPayOrder")
	public String toPayOrder(HttpServletRequest request, MsOrder msOrder, int id, int num) {
		HttpSession session = request.getSession();
		OnLine onLine = (OnLine) session.getAttribute("onLine");
		if (onLine == null) {
			return "redirect:/userRegAndLogAction/toLogin";
		}

		MsProductInfo msProductInfo = msProductInfoService.queryProductById(id);
		request.setAttribute("msProductInfo", msProductInfo);
		request.setAttribute("num", num);

		int payamount = num * msProductInfo.getMiaoshaPrice();
		request.setAttribute("payAmount", payamount);
		request.setAttribute("msUserId", onLine.getMsUser().getId());

		int payAmount = msProductInfo.getMiaoshaPrice() * num;

		return "order/payOrder";

	}
}
