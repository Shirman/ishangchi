package com.shirman.ishangchi.rest.ctrl;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;

import com.shirman.ishangchi.rest.entity.User;
import com.shirman.ishangchi.rest.service.UserService;

public class BaseCtrl {
	@Resource
	private UserService userService;
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2016年1月13日 下午2:14:29 
	 * @return
	 * @update 2016年1月13日 下午2:14:29 
	 * <pre>
	 *   获取当前登录人信息
	 * <pre>
	 */
	protected User getCurrentUser(){
		  User user = (User)SecurityUtils.getSubject().getPrincipal();
		  User userDb = userService.getUserById(user);
		  return userDb;
	}
	
}
