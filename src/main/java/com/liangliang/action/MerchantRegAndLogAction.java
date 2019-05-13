/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author: 
 * @version: 2.0
 * @date:  2019年5月13日 上午12:01:10
*/
package com.liangliang.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liangliang.entity.MsMerchant;
import com.liangliang.entity.MsUser;
import com.liangliang.entity.OnLine;
import com.liangliang.service.MsMerchantService;

/**
 * @description: 功能描述 (商户注册控制器)
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author:
 * @version: 2.0
 * @date:  2019年5月13日 上午12:01:10
 */

@Controller
@RequestMapping("merchantRegAndLogAction")
public class MerchantRegAndLogAction {

	@Autowired
	MsMerchantService msMerchantService;

	@RequestMapping(value = "toRegiter")
	public String toRegiter(MsUser msUser) {
		return "/merchant/register";
	}

	@RequestMapping(value = "regiter", method = RequestMethod.POST)
	public String regiter(HttpServletRequest request, MsMerchant msMerchant) {
		int insert = msMerchantService.insert(msMerchant);
		System.out.println(insert + "" + msMerchant);
		HttpSession session = request.getSession();
		session.setAttribute("msUser", msMerchant);

		OnLine onLine = new OnLine();
		onLine.setStatus("2");
		onLine.setMsMerchant(msMerchant);
		session.setAttribute("onLine", onLine);
		return "redirect:/";
	}

	@RequestMapping(value = "toLogin")
	public String toLogin(MsUser msUser) {
		return "merchant/login";
	}

	/**
	 * 
	 * @description: 功能描述： (登陆方法)
	 * @author: liangliang
	 * @version: 2.0
	 * @date:  2019年5月13日 上午8:44:40
	 * @param msUser
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, MsMerchant msMerchant) {
		String merchantAccount = msMerchant.getMerchantAccount();
		String merchantPassword = msMerchant.getMerchantPassword();
		MsMerchant selectByMerchantAccount = msMerchantService.selectByMerchantAccount(merchantAccount);
		if (selectByMerchantAccount == null) {
			System.out.println("没有这个账号");
		} else if (!selectByMerchantAccount.getMerchantPassword().equals(merchantPassword)) {
			System.out.println("密码不对");
		} else {

			HttpSession session = request.getSession();
			OnLine onLine = new OnLine();
			onLine.setStatus("2");
			onLine.setMsMerchant(selectByMerchantAccount);
			session.setAttribute("onLine", onLine);
			return "redirect:/";

		}

		return "redirect:/";

	}

	@RequestMapping(value = "signOut")
	public String signOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("onLine");
		// session.removeAttribute("msMerchant");
		return "redirect:/";
	}

}
