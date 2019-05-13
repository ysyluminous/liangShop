/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author: 
 * @version: 2.0
 * @date:  2019年5月12日 下午8:04:49
*/
package com.liangliang.service.pay;

import org.springframework.stereotype.Service;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author:
 * @version: 2.0
 * @date:  2019年5月12日 下午8:04:49
 */
@Service
public class AliPay implements OrderPay {

	/**
	 * (非 Javadoc) Title: payOrder Description:
	 * 
	 * @param tradeId
	 * @param payAmount
	 * @return
	 * @see com.liangliang.service.pay.OrderPay#payOrder(java.lang.String,
	 *      java.lang.Integer)
	 */
	public int payOrder(String tradeId, Integer payAmount) {
		// TODO Auto-generated method stub
		System.out.println("阿里支付成功");
		return 1;
	}

	/**
	 * (非 Javadoc) Title: refundOrder Description:
	 * 
	 * @param tradeId
	 * @param payAmount
	 * @return
	 * @see com.liangliang.service.pay.OrderPay#refundOrder(java.lang.String,
	 *      java.lang.Integer)
	 */
	public int refundOrder(String tradeId, Integer payAmount) {
		// TODO Auto-generated method stub
		return 1;
	}

}
