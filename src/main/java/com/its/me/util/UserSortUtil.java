/**
 * 
 */
package com.its.me.util;

/**
 * @author Hwang Hee Jeong(hjhwang_ymtech_kr)
 *
 */
import java.util.Comparator;

import com.its.me.model.LoginUser;


public class UserSortUtil implements Comparator<LoginUser> {
	 
	/**
	 * 오름차순(ASC)
	 */
	@Override
	public int compare(LoginUser arg0, LoginUser arg1) {
		// TODO Auto-generated method stub
		return arg0.getUserId().compareTo(arg1.getUserId());
	}

}