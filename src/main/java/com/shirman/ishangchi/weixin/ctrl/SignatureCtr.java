package com.shirman.ishangchi.weixin.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shirman.ishangchi.weixin.entity.Signature;
import com.shirman.ishangchi.weixin.service.SignatureService;

@RequestMapping(value="/weixin")
@Controller
public class SignatureCtr {
	
	@Resource(name="wechatSignature")
	private SignatureService signatureService;
	private static final Logger LOGGER = 	LoggerFactory.getLogger(SignatureCtr.class);
	
	@RequestMapping(value="/signature")
	@ResponseBody
	public void signature(String signature,String timestamp,String nonce,String echostr,HttpServletResponse response){
		Signature signa = new Signature();
		signa.setSignature(signature);
		signa.setNonce(nonce);
		signa.setTimestamp(timestamp);
		boolean result = signatureService.signature(signa);
		try {
			PrintWriter writer = response.getWriter();
			if (result) {// 验证成功返回ehcostr
				writer.print(echostr);
			} else {
				writer.print("error");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			LOGGER.error("SignatureCtr>>>signature>>>wechat signature error", e);
		}
	}
}
