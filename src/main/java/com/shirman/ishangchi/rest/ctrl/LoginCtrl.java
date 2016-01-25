package com.shirman.ishangchi.rest.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.shirman.ishangchi.common.util.RestResult;
import com.shirman.ishangchi.rest.entity.Article;
import com.shirman.ishangchi.rest.entity.Contant;
import com.shirman.ishangchi.rest.entity.User;
import com.shirman.ishangchi.rest.service.ArticleService;
import com.shirman.ishangchi.rest.service.LoginService;
import com.shirman.ishangchi.rest.service.UserService;

@Controller
public class LoginCtrl extends BaseCtrl{
	
	@Resource
	private LoginService loginService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private ArticleService articleService;
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView("home/login");
		User currentUser = getCurrentUser(); 
		if(currentUser!=null){
			mv.addObject("currentUser",currentUser);
			mv.setViewName("home/index");
		}
		return mv;
	}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("home/index");
		setCurrentUser(mv);
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
		ModelAndView mv = new ModelAndView("home/index");
		loginService.logout();
		return mv;
	}
	
}
