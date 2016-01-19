package com.shirman.ishangchi.weixin.util;

import java.util.Arrays;

import com.shirman.ishangchi.common.util.StringUtil;
import com.shirman.ishangchi.weixin.entity.Signature;

public class WechatUtil {
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2016年1月11日 上午10:56:27 
	 * @param sign
	 * @return
	 * @update 2016年1月11日 上午10:56:27 
	 * <pre>
	 *   验证服务器地址的有效性
	 * <pre>
	 */
	public static boolean checkSignature(Signature sign){
		boolean result = false;
		String signature = sign.getSignature();
		String nonce = sign.getNonce();
		String timestamp = sign.getTimestamp();
		String token = sign.getToken();
		String[] arrayTemp = {token,timestamp,nonce};
		Arrays.sort(arrayTemp);
		String iSignature = StringUtil.join(arrayTemp, null);
		iSignature = StringUtil.encrypt(iSignature);
		if(signature!=null && signature.equals(iSignature)){
			result = true;
		}
		return result;
	}
}
