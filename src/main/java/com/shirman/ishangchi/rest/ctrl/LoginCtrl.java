package com.shirman.ishangchi.rest.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shirman.ishangchi.common.util.RestResult;
import com.shirman.ishangchi.rest.entity.User;
import com.shirman.ishangchi.rest.service.LoginService;

@Controller
public class LoginCtrl extends BaseCtrl{
	
	@Resource
	private LoginService loginService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView();
		User currentUser = getCurrentUser();
		mv.setViewName("home/login");
		mv.addObject(currentUser);
		return mv;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public RestResult login(String username,String password){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		RestResult result = loginService.login(user);
		return result;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView logout(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/login");
		loginService.logout();
		return mv;
	}
	
}
