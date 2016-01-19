package com.shirman.ishangchi.weixin.service;

import org.springframework.stereotype.Service;

import com.shirman.ishangchi.weixin.entity.Signature;
import com.shirman.ishangchi.weixin.util.WechatUtil;

@Service("signatureService")
public class SignatureService {
	private String token;
	public boolean signature(Signature sign){
		sign.setToken(this.getToken());
		return WechatUtil.checkSignature(sign);
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
