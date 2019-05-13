/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author: 
 * @version: 2.0
 * @date:  2019年5月12日 上午8:59:45
*/
package com.liangliang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liangliang.dao.MsOrderMapper;
import com.liangliang.entity.MsOrder;
import com.liangliang.vo.order.ConstomOrder;
import com.liangliang.vo.order.MsOrderVo;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author:
 * @version: 2.0
 * @date:  2019年5月12日 上午8:59:45
 */
@Service
public class MsOrderService {
	@Autowired
	MsOrderMapper msOrderMapper;

	public int insert(MsOrder record) {
		return msOrderMapper.insert(record);

	}

	public List<MsOrder> queryOrderByUserId(Integer userId) {
		return msOrderMapper.queryOrderByUserId(userId);

	}

	public void updateOrderStatusById(Integer payStatus, Integer id, Integer payType) {
		MsOrderVo msOrderVo = new MsOrderVo();
		ConstomOrder constomOrder = new ConstomOrder();
		constomOrder.setPayStatus(payStatus);
		constomOrder.setId(id);
		constomOrder.setPayType(payType);
		msOrderVo.setConstomOrder(constomOrder);
		msOrderMapper.updateOrderStatusById(msOrderVo);

	}

	public List<MsOrder> queryOrderListByMerId(Integer merchantId) {
		return msOrderMapper.queryOrderListByMerId(merchantId);

	}

}
