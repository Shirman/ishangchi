package com.shirman.crawler.core;

import com.shirman.crawler.entity.ConnectionParams;

public class BaseResolve {
	protected ConnectionParams connPar = null; //网络连接参数
	protected String html = ""; // 抓取过来的html
	
	public BaseResolve(ConnectionParams connPar){
		this.connPar = connPar;
	}
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月31日 上午10:48:59 
	 * @update 2015年12月31日 上午10:48:59 
	 * <pre>
	 *   获取页面内容
	 * <pre>
	 */
	protected  void contentFetch(){
		Crawler crawler = new Crawler();
		html = crawler.crawl(connPar);
	}
}
