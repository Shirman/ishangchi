package com.shirman.ishangchi.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shirman.ishangchi.rest.dao.UserDao;
import com.shirman.ishangchi.rest.entity.User;

@Service("userService")
public class UserService {
	@Autowired
	private UserDao userDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2016年1月13日 上午10:48:05 
	 * @param user
	 * @return
	 * @update 2016年1月13日 上午10:48:05 
	 * <pre>
	 *   通过用户名称获取用户信息
	 * <pre>
	 */
	public User getUserByName(User user){
		User userDb = null;
		try {
			userDb = userDao.selectUserByName(user);
		} catch (Exception e) {
			LOGGER.error("UserService>>>getUserByName>>> 通过用户名称获取用户信息异常", e);
		}
		return userDb;
	}
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2016年1月13日 上午10:48:05 
	 * @param user
	 * @return
	 * @update 2016年1月13日 上午10:48:05 
	 * <pre>
	 *   通过用户id称获取用户信息
	 * <pre>
	 */
	public User getUserById(User user){
		User userDb = null;
		try {
			userDb = userDao.selectUserById(user);
		} catch (Exception e) {
			LOGGER.error("UserService>>>getUserByName>>> 通过用户名称获取用户信息异常", e);
		}
		return userDb;
	}
	
}
