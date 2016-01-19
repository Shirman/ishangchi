package com.shirman.ishangchi.rest.dao;

import org.springframework.stereotype.Repository;

import com.shirman.ishangchi.rest.entity.User;

@Repository
public interface UserDao {
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2016年1月13日 上午10:39:05 
	 * @param user
	 * @return
	 * @update 2016年1月13日 上午10:39:05 
	 * <pre>
	 *   根据用户名称查找用户信息
	 * <pre>
	 */
	User selectUserByName(User user);
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2016年1月13日 上午10:39:05 
	 * @param user
	 * @return
	 * @update 2016年1月13日 上午10:39:05 
	 * <pre>
	 *   根据用户id查找用户信息
	 * <pre>
	 */
	User selectUserById(User user);
}
