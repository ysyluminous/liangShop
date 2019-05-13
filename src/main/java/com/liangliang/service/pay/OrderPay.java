/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author: 
 * @version: 2.0
 * @date:  2019年5月12日 下午8:02:44
*/
package com.liangliang.service.pay;

/**
 * @description: 功能描述 (通用支付接口)
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author:
 * @version: 2.0
 * @date:  2019年5月12日 下午8:02:44
 */
public interface OrderPay {

	/**
	 * 
	 * @description: 功能描述： (订单支付)
	 * @author: liangliang
	 * @version: 2.0
	 * @date:  2019年5月12日 下午8:06:53
	 * @param tradeId
	 * @param payAmount
	 * @return 1,代表支付成功，2代表支付失败
	 */
	public int payOrder(String tradeId, Integer payAmount);

	/**
	 * 
	 * @description: 功能描述： (退款)
	 * @author: liangliang
	 * @version: 2.0
	 * @date:  2019年5月12日 下午8:06:53
	 * @param tradeId
	 * @param payAmount
	 * @return 1,代表支付成功，2代表支付失败
	 */
	public int refundOrder(String tradeId, Integer payAmount);

}
