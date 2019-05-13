/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author: 
 * @version: 2.0
 * @date:  2019年5月13日 下午12:17:15
*/
package com.liangliang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liangliang.dao.PersonDao;
import com.liangliang.entity.Person;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author:
 * @version: 2.0
 * @date:  2019年5月13日 下午12:17:15
 */
@Service
public class PersonService {
	@Autowired
	PersonDao personDao;

	public Person querypersonbyid(int id) {
		return personDao.querypersonbyid(id);

	}

	public void inserperson(Person person) {
		personDao.inserperson(person);

	}

}
