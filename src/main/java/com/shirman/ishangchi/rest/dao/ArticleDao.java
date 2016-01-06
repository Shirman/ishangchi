package com.shirman.ishangchi.rest.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shirman.ishangchi.rest.entity.Article;

@Repository
public interface ArticleDao {
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月28日 下午2:56:09 
	 * @param map
	 * @return
	 * @update 2015年12月28日 下午2:56:09 
	 * <pre>
	 *   map:
	 *   	key				valueType				description
	 *   	title				String					文章标题
	 * <pre>
	 */
	Article getArticleByTitle(Map<String,Object> map);
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月29日 下午5:34:52 
	 * @param sortBy
	 * @param sortColumn
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @update 2015年12月29日 下午5:34:52 
	 * <pre>
	 *  分页查询文章
	 * <pre>
	 */
	List<Article> queryArticle(Integer pageNum, Integer pageSize);
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月31日 下午1:01:49 
	 * @param articles
	 * @update 2015年12月31日 下午1:01:49 
	 * <pre>
	 *   批量插入文章
	 * <pre>
	 */
	void insertArticles(List<Article> articles);
}
