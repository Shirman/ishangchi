package com.shirman.crawler.core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shirman.crawler.entity.ConnectionParams;
import com.shirman.crawler.entity.DefaultParams;

/**
 * 
 * @ClassName: Crawler 
 * @Description: 
 * @author Shirman
 * @date 2015年12月31日 上午9:27:11 
 * @version V1.0
 */
public class Crawler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Crawler.class);
	private HttpURLConnection conn = null;
	private URL url = null;
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月31日 上午9:27:40 
	 * @param params
	 * @return
	 * @throws Exception 
	 * @update 2015年12月31日 上午9:27:40 
	 * <pre>
	 *   爬虫开始爬行，获取网页内容
	 * <pre>
	 */
	public String crawl(ConnectionParams params) {
		try {
			if(params.getUrl()!=null){
				url = new URL(params.getUrl());
				conn = (HttpURLConnection) url.openConnection();
				setConnection(params);
			}else{
				return "";
			}
			InputStream is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			is.close();
			conn.disconnect();
			return sb.toString();
		} catch (Exception e) {
			LOGGER.error("Crawler>>>String crawl(ConnectionParams params) >>>获取网页内容异常",e);
			return "";
		}
	}
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月31日 上午9:27:19 
	 * @param params
	 * @throws Exception
	 * @update 2015年12月31日 上午9:27:19 
	 * <pre>
	 *   设置连接的参数
	 * <pre>
	 */
	private void setConnection(ConnectionParams params) throws Exception{
		if(conn!=null){
			if(params.getRequestMethod()!=null){
				conn.setRequestMethod( params.getRequestMethod());
			}else{
				conn.setRequestMethod("GET");
			}
			if(params.getUserAgent()!=null){
				conn.setRequestProperty("User-Agent", params.getUserAgent());
			}else{
				conn.setRequestProperty("User-Agent", DefaultParams.USER_AGENT);
			}
			if(params.getConnectTimeout()!=null){
				conn.setConnectTimeout(params.getConnectTimeout());
			}else{
				conn.setConnectTimeout(DefaultParams.TIME_OUT);
			}
			if(params.getReadTimeout()!=null){
				conn.setConnectTimeout(params.getReadTimeout());
			}else{
				conn.setConnectTimeout(DefaultParams.TIME_OUT);
			}
			if(params.getxForwardedFor()!=null){
				conn.setRequestProperty("x-forwarded-for",params.getxForwardedFor());
			}
		}
	}
}
