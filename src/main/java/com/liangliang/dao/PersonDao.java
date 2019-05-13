/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author: 
 * @version: 2.0
 * @date:  2019年5月13日 下午12:16:39
*/
package com.liangliang.dao;

import com.liangliang.entity.Person;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 亮亮商城
 * @author:
 * @version: 2.0
 * @date:  2019年5月13日 下午12:16:39
 */
public interface PersonDao {

	public Person querypersonbyid(int id);

	public void inserperson(Person person);

}
