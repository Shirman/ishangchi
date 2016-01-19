package com.shirman.ishangchi.weixin.entity;

import java.io.Serializable;

public class Signature implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8522644461937826451L;
	private String signature; //微信加密签名
	private String timestamp; //时间戳
	private String nonce; // 随机数
	private String echostr; //随机字符串
	private String token; 
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getEchostr() {
		return echostr;
	}
	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	

}
