package com.shirman.ishangchi.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shirman.ishangchi.rest.dao.ArticleDao;
import com.shirman.ishangchi.rest.entity.Article;

@Service("articleService")
public class ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);
	
	public Article getArticle(String title){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("title",title);
		Article article = new Article();
		try{
			article = articleDao.getArticleByTitle(params);
		}catch(Exception e){
			LOGGER.error("ArticleService>>> Article getArticle(String title)>>>根据标题获取文章异常>>>", e);
		}
		
		return article;
	}
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2016年1月25日 下午7:33:18 
	 * @param type
	 * @return
	 * @update 2016年1月25日 下午7:33:18 
	 * <pre>
	 *   根据文章类型获取文章
	 * <pre>
	 */
	public List<Article> getArticles(Integer type){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("type",type);
		List<Article> list = new ArrayList<Article>();
		try{
			list = articleDao.queryArticleByType(type);
		}catch(Exception e){
			LOGGER.error("ArticleService>>> Article getArticle(String title)>>>根据文章类型获取文章异常>>>", e);
		}
		
		return list;
	}
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月29日 下午5:33:48 
	 * @param sortBy
	 * @param sortColumn
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @update 2015年12月29日 下午5:33:48 
	 * <pre>
	 *   分页查询文章
	 * <pre>
	 */
	public PageInfo<Article> queryArticle(Integer pageNum, Integer pageSize,Integer type){
		PageInfo<Article> page = null;
		try{
			pageNum = pageNum==null?1:pageNum;
			pageSize = pageSize == null ?  20 : pageSize;
			PageHelper.startPage(pageNum, pageSize);
			List<Article> articles= articleDao.queryArticle(type);
			page = new PageInfo<Article>(articles);
		}catch(Exception e){
			LOGGER.error("ArticleService>>> Article queryArticle(Integer pageNum, Integer pageSize,Integer type)>>>分页查询文章异常>>>", e);
		}
		return page;
	}

}
