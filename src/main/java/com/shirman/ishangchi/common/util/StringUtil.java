package com.shirman.ishangchi.common.util;

import java.lang.reflect.Field;

import com.shirman.ishangchi.rest.entity.User;

public class StringUtil {
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月17日 下午4:57:42 
	 * @param ob
	 * @update 2015年12月17日 下午4:57:42 
	 * <pre>
	 *   设置object对象中类型为String、值为null的对象的值为空
	 * <pre>
	 */
	public static  void replaceNullToEmpty(Object ob){
		String emptyString = "";
		@SuppressWarnings("rawtypes")
		Class clazz = ob.getClass();
		Field[] declaredFields = clazz.getDeclaredFields();
		for(Field field : declaredFields){
			String typeName = field.getType().getName();
			String fieldName = field.getName();
			try {
				Object fieldValue = ReflectHelper.getFieldValue(ob, fieldName);
				if(fieldValue==null && String.class.getName().equals(typeName)){
					ReflectHelper.setFieldValue(ob, fieldName, emptyString);
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月17日 下午4:57:42 
	 * @param ob
	 * @update 2015年12月17日 下午4:57:42 
	 * <pre>
	 *   设置object对象中类型为boolean或Boolean的对象的值为true
	 * <pre>
	 */
//	public static  void setTrue(Object ob){
//		@SuppressWarnings("rawtypes")
//		Class clazz = ob.getClass();
//		Field[] declaredFields = clazz.getDeclaredFields();
//		for(Field field : declaredFields){
//			String typeName = field.getType().getName();
//			String fieldName = field.getName();
//			if( Boolean.class.getName().equals(typeName) || boolean.class.getName().equals(typeName)){
//				ReflectHelper.setFieldValue(ob, fieldName, true);
//			}
//		}
//	}
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月17日 下午5:32:27 
	 * @param str
	 * @return
	 * @update 2015年12月17日 下午5:32:27 
	 * <pre>
	 *   字符串第一个字母转成大写
	 * <pre>
	 */
	public static String upperCaseFirst( String str ){
		return str.substring(0,1).toUpperCase() + str.substring(1);
	}
	public static void main(String[] args) {
		User user = new User();
		replaceNullToEmpty(user);
		System.out.println(user.isMan());
	}

}
