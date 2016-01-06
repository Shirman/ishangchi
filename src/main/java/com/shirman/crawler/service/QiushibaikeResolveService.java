package com.shirman.crawler.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.shirman.crawler.entity.ConnectionParams;
import com.shirman.crawler.resolve.QiushibaikeResolve;
import com.shirman.keepeating.rest.dao.ArticleDao;
import com.shirman.keepeating.rest.entity.Article;

/**
 * 
 * @ClassName: ResolveService 
 * @Description: 解析html
 * @author Shirman
 * @date 2015年12月31日 上午9:57:16 
 * @version V1.0
 */
public class QiushibaikeResolveService {
	private static final Logger LOGGER = LoggerFactory.getLogger(QiushibaikeResolveService.class);
	private String baseUrl = "http://www.qiushibaike.com/8hr/page/";
	private Integer totalPage = 10;
	private static final String USER_AGENT = "Mozilla/5.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/600.1.3 (KHTML, like Gecko) Version/8.0 Mobile/12A4345d Safari/600.1.4";
	@Autowired
	private ArticleDao articleDao;
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月31日 下午1:02:50 
	 * @update 2015年12月31日 下午1:02:50 
	 * <pre>
	 *   抓取糗事百科文章，并保存到数据库
	 * <pre>
	 */
	public void crawl(){
		LOGGER.info("********************开始抓取糗事百科文章********************");
		for( int i = totalPage; i > 0; i-- ){
			 ConnectionParams connPar = new ConnectionParams();
			 connPar.setUrl(baseUrl+i);
			 connPar.setUserAgent(USER_AGENT);
			 QiushibaikeResolve resolve = new QiushibaikeResolve(connPar);
			List<Article> articles = resolve.getQiushiArticles();
			articleDao.insertArticles(articles);
		}
		LOGGER.info("********************结束抓取糗事百科文章********************");
	}
}
