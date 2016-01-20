package com.shirman.ishangchi.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.shirman.ishangchi.rest.dao.UserDao;
import com.shirman.ishangchi.rest.entity.User;

/**
 * 
 * @ClassName: DbRealm 
 * @Description: 
 * @author Shirman
 * @date 2016年1月13日 下午3:39:10 
 * @version V1.0
 */

public class DbRealm extends AuthorizingRealm{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DbRealm.class);
	
	private UserDao userDao;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection paramPrincipalCollection) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken paramAuthenticationToken)
			throws AuthenticationException {
		String username = (String)paramAuthenticationToken.getPrincipal();
		String password = new String((char[])paramAuthenticationToken.getCredentials());
		if(username==null || password == null){
			LOGGER.error("doGetAuthorizationInfo>>>doGetAuthenticationInfo>>>shiro登录验证时密码或者用户名为空");
			throw new RuntimeException();
		}
		User user = new User(username,password);
		User userDb=null;
		try {
			userDb = userDao.selectUserByName(user);
		} catch (Exception e) {
			LOGGER.error("doGetAuthorizationInfo>>>doGetAuthenticationInfo>>>获取用户信息异常");
			throw new RuntimeException();
		}
		if(userDb == null){
			 throw new UnknownAccountException(); //用户不存在
		}
		return new SimpleAuthenticationInfo(userDb, password, username);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
