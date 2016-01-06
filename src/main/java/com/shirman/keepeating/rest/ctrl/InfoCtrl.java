package com.shirman.keepeating.rest.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.shirman.keepeating.common.util.RestResult;
import com.shirman.keepeating.rest.entity.Article;
import com.shirman.keepeating.rest.service.ArticleService;

@Controller
@RequestMapping(value="/info")
public class InfoCtrl {
	@Resource
	private ArticleService articleService;
	
	@RequestMapping(value="/infoMain")
	public ModelAndView index() {
		PageInfo<Article> queryArticle = articleService.queryArticle(null, null);
		List<Article> articles = queryArticle.getList();
		ModelAndView modelAndView = new ModelAndView("info/infoMain");
		modelAndView.addObject("articles", articles);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="getArticles")
	public RestResult getArticle(Integer pageNum, Integer pageSize){
		RestResult restResult = new RestResult();
		PageInfo<Article> queryArticle = articleService.queryArticle(pageNum, pageSize);
		restResult.setData(queryArticle);
		return restResult;
	}
}
