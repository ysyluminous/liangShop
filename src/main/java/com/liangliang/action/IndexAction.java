/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author: 
 * @version: 2.0
 * @date:  2019年5月13日 下午6:49:05
*/
package com.liangliang.action;

import com.liangliang.entity.MsProductDetail;
import com.liangliang.entity.MsProductInfo;
import com.liangliang.service.MsOrderService;
import com.liangliang.service.MsProductDetailService;
import com.liangliang.service.MsProductInfoService;
import com.liangliang.vo.ConstomProduct;
import com.liangliang.vo.MsProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author:
 * @version: 2.0
 * @date:  2019年5月13日 下午6:49:05
 */
@Controller
public class IndexAction {

	@Autowired
	private MsProductInfoService msProductInfoService;

	@Autowired
	private MsProductDetailService msProductDetailService;

	@Autowired
	private MsOrderService msOrderService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		// HttpSession session = request.getSession();
		// OnLine onLine = (OnLine) session.getAttribute("onLine");
		// if (onLine != null) {
		// MsMerchant msMerchant = onLine.getMsMerchant();
		// if (msMerchant != null) {
		//
		// }
		// MsUser msUser = onLine.getMsUser();
		// if (msUser != null) {
		//
		// }
		// }

		MsProductVo msProductVo = new MsProductVo();
		ConstomProduct constomProduct = new ConstomProduct();
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowstring = dateFormat.format(now);
		constomProduct.setStartendtime(nowstring);
		constomProduct.setAidotStatus(2);
		msProductVo.setConstomProduct(constomProduct);
		// private Date startstarttime;//亮亮商城开始时间查询范围开始时间
		// private Date endstarttime;//亮亮商城开始时间查询范围结束时间
		msProductVo.setConstomProduct(constomProduct);
		List<MsProductInfo> listMsProduct = msProductInfoService.listMsProduct(msProductVo);
		request.setAttribute("listMsProduct", listMsProduct);
		return "index";
	}

	@RequestMapping(value = "/black", method = RequestMethod.GET)
	public String black() {
		return "black";
	}

	@RequestMapping(value = "/viewProductDetail", method = RequestMethod.GET)
	public String viewProductDetail(HttpServletRequest request, int id) {
		MsProductInfo queryProductById = msProductInfoService.queryProductById(id);
		MsProductDetail selectProductDetailByPrimaryKey = msProductDetailService.selectByPrimaryKey(id);
		request.setAttribute("msproduct", queryProductById);
		request.setAttribute("msproductDetail", selectProductDetailByPrimaryKey);
		return "/order/sellDetail";
	}

}
