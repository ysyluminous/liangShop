/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author: 
 * @version: 2.0
 * @date:  2019年5月13日 下午6:49:05
*/
package com.liangliang.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author:
 * @version: 2.0
 * @date:  2019年5月13日 下午6:49:05
 */
@Controller
@RequestMapping("adminPageAction")
public class AdminPageAction {

	@RequestMapping(value = "/toHome", method = RequestMethod.GET)
	public String index() {
		return "adminHome/adminIndex";
	}

}
