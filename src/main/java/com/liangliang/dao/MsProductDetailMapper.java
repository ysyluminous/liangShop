package com.liangliang.dao;

import com.liangliang.entity.MsProductDetail;

public interface MsProductDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MsProductDetail record);

    int insertSelective(MsProductDetail record);

    MsProductDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MsProductDetail record);

    int updateByPrimaryKey(MsProductDetail record);
}