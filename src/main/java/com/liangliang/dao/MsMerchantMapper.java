package com.liangliang.dao;

import java.util.List;

import com.liangliang.entity.MsMerchant;
import com.liangliang.vo.MsMerchantVo;

public interface MsMerchantMapper {
	int deleteByPrimaryKey(int id);

	int insert(MsMerchant record);

	int insertSelective(MsMerchant record);

	MsMerchant selectByPrimaryKey(int id);

	int updateByPrimaryKeySelective(MsMerchant record);

	int updateByPrimaryKey(MsMerchant record);

	List<MsMerchant> queryMsmerchantByVo(MsMerchantVo msMerchantVo);

	MsMerchant selectByMerchantAccount(String merchantAccount);
}