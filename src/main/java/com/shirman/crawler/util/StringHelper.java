package com.shirman.crawler.util;

/**
 * 
 * @ClassName: StringHelper 
 * @Description: 字符串帮助类
 * @author Shirman
 * @date 2015年12月31日 上午9:47:33 
 * @version V1.0
 */
public class StringHelper {
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月31日 上午9:47:57 
	 * @param str
	 * @return
	 * @update 2015年12月31日 上午9:47:57 
	 * <pre>
	 *   判断字符串是否为null或者为空，符合条件返回true
	 * <pre>
	 */
	public static boolean isEmpty(String str){
		return str==null || str=="";
	}
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月31日 上午9:48:37 
	 * @param str
	 * @return
	 * @update 2015年12月31日 上午9:48:37 
	 * <pre>
	 *   判断字符串是否不为null而且为空，符合条件返回true
	 * <pre>
	 */
	public static boolean isNotEmpty(String str){
		return str !=null && str != "";
	}
}
