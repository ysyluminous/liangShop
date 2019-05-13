/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author: 
 * @version: 2.0
 * @date:  2019年5月13日 下午12:30:10
*/
package com.liangliang.action;

import com.liangliang.entity.Person;
import com.liangliang.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author:
 * @version: 2.0
 * @date:  2019年5月12日 下午12:30:10
 */
@Controller
public class PersonAction {
	@Autowired
	PersonService personService;

	@Test
	public void testPerson() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		PersonAction personAction = (PersonAction) applicationContext.getBean("personAction");
		// Person querypersonbyid =
		// personAction.personService.querypersonbyid(4);

		Person person = new Person();
		person.setName("亮亮");
		person.setBirthday("12-12");
		person.setAge(12);
		personAction.personService.inserperson(person);
		// System.out.println(querypersonbyid);

	}

}
