package com.shirman.ishangchi.rest.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.shirman.ishangchi.common.util.RestResult;
import com.shirman.ishangchi.rest.entity.Article;
import com.shirman.ishangchi.rest.entity.Contant;
import com.shirman.ishangchi.rest.service.ArticleService;

@Controller
@RequestMapping(value="/info")
public class InfoCtrl extends BaseCtrl{
	@Resource
	private ArticleService articleService;
	
	@RequestMapping(value="/infoMain")
	public ModelAndView index(Integer pageNum, Integer pageSize) {
		PageInfo<Article> queryArticle = articleService.queryArticle(pageNum, pageSize,Contant.QIUSHIBAIKE);
		List<Article> articles = queryArticle.getList();
		ModelAndView modelAndView = new ModelAndView("info/infoMain");
		modelAndView.addObject("articles", articles);
		setCurrentUser(modelAndView);
		return modelAndView;
	}
	
	@RequestMapping(value="/wechatBottom")
	@ResponseBody
	public RestResult wecharBottom(Integer pageNum, Integer pageSize) {
		RestResult restResult = new RestResult();
		PageInfo<Article> queryArticle = articleService.queryArticle(pageNum, pageSize,Contant.WECHAT_BOTTOM);
		restResult.setData(queryArticle);
		return restResult;
	}
	
	@ResponseBody
	@RequestMapping(value="getArticles")
	public RestResult getArticle(Integer pageNum, Integer pageSize){
		RestResult restResult = new RestResult();
		PageInfo<Article> queryArticle = articleService.queryArticle(pageNum, pageSize,Contant.QIUSHIBAIKE);
		restResult.setData(queryArticle);
		return restResult;
	}
}
