package com.shirman.ishangchi.rest.ctrl;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.ModelAndView;

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
		  String  username = (String)SecurityUtils.getSubject().getPrincipal();
		  User user = new User(username);
		  User userDb = userService.getUserByName(user);
		  return userDb;
	}
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2016年1月21日 上午10:34:29 
	 * @param mv
	 * @update 2016年1月21日 上午10:34:29 
	 * <pre>
	 *   设置当前登录人
	 * <pre>
	 */
	protected void setCurrentUser(ModelAndView mv){
		User currentUser = getCurrentUser();
		if(currentUser!=null){
			mv.addObject("currentUser", currentUser);
		}
	}
	
}
