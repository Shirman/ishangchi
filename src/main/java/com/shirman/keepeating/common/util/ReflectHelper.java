package com.shirman.keepeating.common.util;

import java.lang.reflect.Method;

public class ReflectHelper {
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月17日 下午5:26:45 
	 * @return
	 * @throws NoSuchMethodException 
	 * @update 2015年12月17日 下午5:26:45 
	 * <pre>
	 *   获取对象的属性值
	 * <pre>
	 */
	public static Object getFieldValue(Object ob, String fieldName) throws NoSuchMethodException{
		Method method = null;
		try {
			method = ob.getClass().getMethod("get"+StringUtil.upperCaseFirst(fieldName));
		} catch (NoSuchMethodException e) {
			try {
				method = ob.getClass().getMethod("is"+StringUtil.upperCaseFirst(fieldName));
			} catch (NoSuchMethodException e1) {
				throw e1;
			}
		}
		try {
			return method.invoke(ob);
		} catch (Exception e) {
			return null;
		} 
	}
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2015年12月17日 下午6:16:06 
	 * @param ob
	 * @param fieldName
	 * @param value
	 * @update 2015年12月17日 下午6:16:06 
	 * <pre>
	 *   设置对象属性值
	 * <pre>
	 */
	public static void setFieldValue(Object ob, String fieldName, Object... value){
		Method method = null;
		try {
			method = ob.getClass().getMethod("set" + StringUtil.upperCaseFirst(fieldName),value.getClass());
		}catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		try {
			method.invoke(ob, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
