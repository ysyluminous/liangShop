/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author: 
 * @version: 2.0
 * @date:  2019年5月13日 下午1:26:22
*/
package com.liangliang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liangliang.dao.MsUserMapper;
import com.liangliang.entity.MsUser;
import com.liangliang.vo.MsUserVo;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author:
 * @version: 2.0
 * @date:  2019年5月13日 下午1:26:22
 */
@Service
public class MsUserService {
	@Autowired
	MsUserMapper msUserMapper;

	public int deleteByPrimaryKey(Integer id) {
		return msUserMapper.deleteByPrimaryKey(id);

	}

	public int insert(MsUser record) {
		return msUserMapper.insert(record);

	}

	public int insertSelective(MsUser record) {
		return msUserMapper.insertSelective(record);

	}

	public MsUser selectByPrimaryKey(Integer id) {
		return msUserMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(MsUser record) {
		return msUserMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(MsUser record) {
		return msUserMapper.updateByPrimaryKey(record);
	}

	public List<MsUser> queryMsUserByVo(MsUserVo msUserVo) {
		return msUserMapper.queryMsUserByVo(msUserVo);

	}

	public MsUser selectByUserAccount(String userAccount) {
		return msUserMapper.selectByUserAccount(userAccount);

	}

}
