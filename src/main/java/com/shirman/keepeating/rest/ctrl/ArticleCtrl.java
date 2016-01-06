package com.shirman.keepeating.rest.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.shirman.keepeating.rest.entity.Article;
import com.shirman.keepeating.rest.service.ArticleService;

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
