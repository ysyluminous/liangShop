package com.liangliang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liangliang.entity.MsOrder;
import com.liangliang.entity.MsOrderExample;
import com.liangliang.vo.order.MsOrderVo;

public interface MsOrderMapper {

	public void updateOrderStatusById(MsOrderVo msOrderVo);

	long countByExample(MsOrderExample example);

	int deleteByExample(MsOrderExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(MsOrder record);

	List<MsOrder> queryOrderByUserId(Integer userId);

	int insertSelective(MsOrder record);

	List<MsOrder> selectByExample(MsOrderExample example);

	MsOrder selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") MsOrder record, @Param("example") MsOrderExample example);

	int updateByExample(@Param("record") MsOrder record, @Param("example") MsOrderExample example);

	int updateByPrimaryKeySelective(MsOrder record);

	int updateByPrimaryKey(MsOrder record);

	/**
	 * @description: 功能描述： (根据商家id查询订单)
	 * @author: liangliang
	 * @version: 2.0
	 * @date:  2019年5月12日 下午3:19:02
	 * @param merchantId
	 * @return
	 */
	public List<MsOrder> queryOrderListByMerId(Integer merchantId);
}