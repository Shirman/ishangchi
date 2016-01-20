package com.shirman.ishangchi.rest.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.shirman.ishangchi.common.util.RestResult;
import com.shirman.ishangchi.common.util.StringUtil;
import com.shirman.ishangchi.rest.entity.User;

@Service("loginService")
public class LoginService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2016年1月13日 下午2:51:52 
	 * @param user
	 * @return
	 * @update 2016年1月13日 下午2:51:52 
	 * <pre>
	 *   shiro 登陆
	 * <pre>
	 */
	public RestResult login(User user){
		RestResult result = new RestResult();
		String username = user.getUsername();
		String password = user.getPassword();
		if(StringUtil.isEmpty(password)){
			result.setResultCode(RestResult.RESULT_FAILURE);
			result.setResultMsg(RestResult.RESULT_LOGIN_EMPTY_PASSWORD);
			return result;
		}
		if(StringUtil.isEmpty(password)){
			result.setResultCode(RestResult.RESULT_FAILURE);
			result.setResultMsg(RestResult.RESULT_LOGIN_EMPTY_USERNAME);
			return result;
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, DigestUtils.md5Hex(password));
		//shiro框架 登录
		 try {
			 subject.login(token);
	        } catch (UnknownAccountException e) {
	            LOGGER.error("账号不存在", e);
	            result.setResultMsg(RestResult.RESULT_LOGIN_NOT_EXIT_USER);
	            result.setResultCode(RestResult.RESULT_FAILURE);
	            return result;
	        } catch (IncorrectCredentialsException e) {
	            LOGGER.error("密码错误", e);
	            result.setResultMsg(RestResult.RESULT_LOGIN_ERROR_PASSWORD);
	            result.setResultCode(RestResult.RESULT_FAILURE);
	            return result;
	        } catch (RuntimeException e) {
	            LOGGER.error("未知错误,请联系管理员"+e.getLocalizedMessage(), e);
	            result.setResultMsg(RestResult.RESULT_FAILURE_MSG);
	            result.setResultCode(RestResult.RESULT_FAILURE);
	            return result;
	        }
		 	result.setResultCode(RestResult.RESULT_SUCCESS);
	        return result;
	}
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2016年1月13日 下午3:06:55 
	 * @return
	 * @update 2016年1月13日 下午3:06:55 
	 * <pre>
	 *   登出
	 * <pre>
	 */
	public RestResult logout(){
		RestResult result = new RestResult();
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		result.setResultCode(RestResult.RESULT_SUCCESS);
		return result;
	}
}
