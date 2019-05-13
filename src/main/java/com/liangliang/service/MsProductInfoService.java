/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author: 
 * @version: 2.0
 * @date:  2019年5月13日 上午8:48:45
*/
package com.liangliang.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liangliang.dao.MsProductInfoMapper;
import com.liangliang.entity.MsProductInfo;
import com.liangliang.vo.ConstomProduct;
import com.liangliang.vo.MsProductVo;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author:
 * @version: 2.0
 * @date:  2019年5月13日 上午8:48:45
 */
@Service
public class MsProductInfoService {
	@Autowired
	MsProductInfoMapper msProductInfoMapper;

	/**
	 * 
	 * @description: 功能描述： (申请亮亮商城商品)
	 * @author: liangliang
	 * @version: 2.0
	 * @date:  2019年5月13日 上午9:26:12
	 * @param msProductInfo
	 */
	public void applyMsProduct(MsProductInfo msProductInfo) {
		String startTimeString = msProductInfo.getStartTimeString();
		String endTimeString = msProductInfo.getEndTimeString();
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date startTime = simpleDateFormat.parse(startTimeString);
			msProductInfo.setStartTime(startTime);
			Date endTime = simpleDateFormat.parse(endTimeString);
			msProductInfo.setEndTime(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msProductInfo.setApplayDate(new Date());
		msProductInfo.setAidotStatus(1);
		msProductInfoMapper.applyMsProduct(msProductInfo);
	}

	/**
	 * 
	 * @description: 功能描述： (亮亮商城商品列表)
	 * @author: liangliang
	 * @version: 2.0
	 * @date:  2019年5月13日 上午9:26:12
	 * @param msProductInfo
	 */
	public List<MsProductInfo> listMsProduct(MsProductVo msProductVo) {
		return msProductInfoMapper.listMsProduct(msProductVo);
	}

	public MsProductInfo queryProductById(int id) {
		return msProductInfoMapper.selectByPrimaryKey(id);
	}

	public void deleteProductById(int id) {
		msProductInfoMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 
	 * @description: 功能描述： (根据id更新状态)
	 * @author: liangliang
	 * @version: 2.0
	 * @date:  2019年5月13日 下午1:16:53
	 * @param id
	 * @param state
	 */
	public void updateProductState(int id, int state) {
		MsProductVo msProductVo = new MsProductVo();
		ConstomProduct constomProduct = new ConstomProduct();
		constomProduct.setId(id);
		constomProduct.setAidotStatus(state);
		msProductVo.setConstomProduct(constomProduct);
		msProductInfoMapper.updateProductState(msProductVo);
	}

	public void updateMsProductInfo(MsProductInfo msproductinfo) {
		String starttime = msproductinfo.getStartTimeString();//
		String endtime = msproductinfo.getEndTimeString();
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (starttime != null) {
				Date starttimedate = dateformat.parse(starttime);
				msproductinfo.setStartTime(starttimedate);
			}
			if (endtime != null) {
				Date endtimedate = dateformat.parse(endtime);
				msproductinfo.setEndTime(endtimedate);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msProductInfoMapper.updateByPrimaryKey(msproductinfo);
	}

}
