package com.shirman.crawler.entity;

/**
 * 
 * @ClassName: ConnectionParams 
 * @Description: 用于url连接时参数配置
 * @author Shirman
 * @date 2015年12月31日 上午9:35:31 
 * @version V1.0
 */
public class ConnectionParams {
	
	private String url; //连接的url “http：//www.baidu.com”
	private String requestMethod; //请求方法
	private String userAgent; //浏览器标识
	private Integer connectTimeout; //连接超时时间
	private Integer readTimeout; //读取超时时间
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public Integer getConnectTimeout() {
		return connectTimeout;
	}
	public void setConnectTimeout(Integer connectTimeout) {
		this.connectTimeout = connectTimeout;
	}
	public Integer getReadTimeout() {
		return readTimeout;
	}
	public void setReadTimeout(Integer readTimeout) {
		this.readTimeout = readTimeout;
	}
	public String getxForwardedFor() {
		return xForwardedFor;
	}
	public void setxForwardedFor(String xForwardedFor) {
		this.xForwardedFor = xForwardedFor;
	}
	private String xForwardedFor;

}
