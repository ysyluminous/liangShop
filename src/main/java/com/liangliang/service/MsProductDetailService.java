/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author: 
 * @version: 2.0
 * @date:  2019年5月13日 上午8:48:45
*/
package com.liangliang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liangliang.dao.MsProductDetailMapper;
import com.liangliang.entity.MsProductDetail;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author:
 * @version: 2.0
 * @date:  2019年5月13日 上午8:48:45
 */
@Service
public class MsProductDetailService {
	@Autowired
	MsProductDetailMapper msProductDetailMapper;

	public int deleteByPrimaryKey(Integer id) {
		return msProductDetailMapper.deleteByPrimaryKey(id);

	}

	public int insert(MsProductDetail record) {
		return msProductDetailMapper.insert(record);
	}

	public MsProductDetail selectByPrimaryKey(Integer id) {
		return msProductDetailMapper.selectByPrimaryKey(id);

	}

	public int updateByPrimaryKey(MsProductDetail record) {
		return msProductDetailMapper.updateByPrimaryKey(record);
	}

}
