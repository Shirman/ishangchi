package com.shirman.crawler.resolve;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.shirman.crawler.core.BaseResolve;
import com.shirman.crawler.entity.ConnectionParams;
import com.shirman.crawler.util.StringHelper;
import com.shirman.ishangchi.rest.entity.Article;

/**
 * 
 * @ClassName: QiushibaikeResolve 
 * @Description: 糗事百科页面转换工具
 * @author Shirman
 * @date 2015年12月31日 上午10:02:13 
 * @version V1.0
 */
public class QiushibaikeResolve extends BaseResolve {
	
	public QiushibaikeResolve(ConnectionParams connPar){
		super(connPar);
	}
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月31日 上午10:10:38 
	 * @return
	 * @update 2015年12月31日 上午10:10:38 
	 * <pre>
	 *   获取糗事百科的文章
	 * <pre>
	 */
	public List<Article> getQiushiArticles(){
		List<Article> articles = new ArrayList<Article>();
		Elements articleEles = getArticlesHtml();
		if(articleEles !=null ){
			Calendar cal = Calendar.getInstance();
			ListIterator<Element> it = articleEles.listIterator();
			while(it.hasNext()){
				Element e = it.next();
				String author = e.select("a div span").eq(0).text();
				String content = e.select("a div").eq(1).text();
				Article article = new Article();
				article.setAuthor(author);
				article.setContent(content);
				article.setTitle("糗事百科");
				article.setCreateTime(cal.getTime());
				article.setModifyTime(cal.getTime());
				articles.add(article);
			}
		}
		return articles;
	}
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月31日 上午10:56:18 
	 * @update 2015年12月31日 上午10:56:18 
	 * <pre>
	 *   获取糗事百科html格式的文章
	 * <pre>
	 */
	private Elements getArticlesHtml(){
		Elements articles = null;
		contentFetch(); //获取html
		if(StringHelper.isNotEmpty(html)){
			Document doc = Jsoup.parse(html);
			articles = doc.select("article");
		}
		return articles;
	}
}
