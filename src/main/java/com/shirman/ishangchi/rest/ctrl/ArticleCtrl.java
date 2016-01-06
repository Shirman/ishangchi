package com.shirman.ishangchi.rest.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shirman.ishangchi.rest.service.ArticleService;

@Controller
@RequestMapping(value="/article")
public class ArticleCtrl {
	
	@Resource
	private ArticleService articleService;
	
	@RequestMapping(value="/articleMain")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("article/article");
		return modelAndView;
	}
}
