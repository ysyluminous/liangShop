/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author: 
 * @version: 2.0
 * @date:  2019年5月13日 上午9:01:49
*/
package com.liangliang.vo;

import com.liangliang.entity.MsProductInfo;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author:
 * @version: 2.0
 * @date:  2019年5月13日 上午9:01:49
 */
public class ConstomProduct extends MsProductInfo {
	private int startmiaoshaprice;// 亮亮商城价格查询范围开始
	private int endmiaoshaprice;// 亮亮商城价格查询范围结束

	private int startoriginalprice;// 商品原价查询范围开始
	private int endoriginalprice;// 商品原价查询范围结束

	private String startapplydate;// 申请时间查询范围开始时间
	private String endapplydate;// 申请时间查询范围结束时间

	private String startauditdate;// 审核时间查询范围开始时间
	private String endauditdate;// 审核时间查询范围结束时间

	private String startstarttime;// 亮亮商城开始时间查询范围开始时间
	private String endstarttime;// 亮亮商城开始时间查询范围结束时间

	private String startendtime;// 亮亮商城结束时间查询范围开始时间

	private String endendtime;// 亮亮商城结束时间查询范围结束时间

	private int startproductcount;// 亮亮商城商品数开始范围
	private int endproductcount;// 亮亮商城商品数结束范围

	private int startstockcount;// 库存开始范围
	private int endstockcount;// 库存结束范围

	public int getStartmiaoshaprice() {
		return startmiaoshaprice;
	}

	public void setStartmiaoshaprice(int startmiaoshaprice) {
		this.startmiaoshaprice = startmiaoshaprice;
	}

	public int getEndmiaoshaprice() {
		return endmiaoshaprice;
	}

	public void setEndmiaoshaprice(int endmiaoshaprice) {
		this.endmiaoshaprice = endmiaoshaprice;
	}

	public int getStartoriginalprice() {
		return startoriginalprice;
	}

	public void setStartoriginalprice(int startoriginalprice) {
		this.startoriginalprice = startoriginalprice;
	}

	public int getEndoriginalprice() {
		return endoriginalprice;
	}

	public void setEndoriginalprice(int endoriginalprice) {
		this.endoriginalprice = endoriginalprice;
	}

	public String getStartapplydate() {
		return startapplydate;
	}

	public void setStartapplydate(String startapplydate) {
		this.startapplydate = startapplydate;
	}

	public String getEndapplydate() {
		return endapplydate;
	}

	public void setEndapplydate(String endapplydate) {
		this.endapplydate = endapplydate;
	}

	public String getStartauditdate() {
		return startauditdate;
	}

	public void setStartauditdate(String startauditdate) {
		this.startauditdate = startauditdate;
	}

	public String getEndauditdate() {
		return endauditdate;
	}

	public void setEndauditdate(String endauditdate) {
		this.endauditdate = endauditdate;
	}

	public String getStartstarttime() {
		return startstarttime;
	}

	public void setStartstarttime(String startstarttime) {
		this.startstarttime = startstarttime;
	}

	public String getEndstarttime() {
		return endstarttime;
	}

	public void setEndstarttime(String endstarttime) {
		this.endstarttime = endstarttime;
	}

	public String getStartendtime() {
		return startendtime;
	}

	public void setStartendtime(String startendtime) {
		this.startendtime = startendtime;
	}

	public String getEndendtime() {
		return endendtime;
	}

	public void setEndendtime(String endendtime) {
		this.endendtime = endendtime;
	}

	public int getStartproductcount() {
		return startproductcount;
	}

	public void setStartproductcount(int startproductcount) {
		this.startproductcount = startproductcount;
	}

	public int getEndproductcount() {
		return endproductcount;
	}

	public void setEndproductcount(int endproductcount) {
		this.endproductcount = endproductcount;
	}

	public int getStartstockcount() {
		return startstockcount;
	}

	public void setStartstockcount(int startstockcount) {
		this.startstockcount = startstockcount;
	}

	public int getEndstockcount() {
		return endstockcount;
	}

	public void setEndstockcount(int endstockcount) {
		this.endstockcount = endstockcount;
	}

}
