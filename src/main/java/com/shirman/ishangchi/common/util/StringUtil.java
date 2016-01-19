package com.shirman.ishangchi.common.util;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	}
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2016年1月11日 上午11:18:38 
	 * @param arry
	 * @param joinKey
	 * @return
	 * @update 2016年1月11日 上午11:18:38 
	 * <pre>
	 *   将字符串数组拼接成由joinKey分割的一个字符串
	 * <pre>
	 */
	public static String join(String[] arry,String joinKey){
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < arry.length ; i++){
			sb.append(arry[i]);
			if(StringUtil.isNotEmpty(joinKey) &&arry.length-i>1){//判断是否是最后一次循环
				sb.append(joinKey);
			}
		}
		return sb.toString();
	}
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
	
	/**
	 * 
	 * @author Shirman
	 * @projectNo:
	 * @date 2016年1月11日 下午1:33:25 
	 * @param strSrc
	 * @return
	 * @update 2016年1月11日 下午1:33:25 
	 * <pre>
	 *   sha1加密
	 * <pre>
	 */
    public static String encrypt(String strSrc) {  
        MessageDigest md = null;  
        String strDes = null;  
  
        byte[] bt = strSrc.getBytes();  
        try {  
            md = MessageDigest.getInstance("SHA-1");  
            md.update(bt);  
            strDes = bytes2Hex(md.digest()); // to HexString  
        } catch (NoSuchAlgorithmException e) {  
            return "";  
        }  
        return strDes;  
    }  
  
    /**
     * 
     * @author Shirman
     * @projectNo:
     * @date 2016年1月11日 下午1:36:38 
     * @param bts
     * @return
     * @update 2016年1月11日 下午1:36:38 
     * <pre>
     *   转换成16进制的字符串
     * <pre>
     */
    private static String bytes2Hex(byte[] bts) {  
        String des = "";  
        String tmp = null;  
        for (int i = 0; i < bts.length; i++) {  
            tmp = (Integer.toHexString(bts[i] & 0xFF));  
            if (tmp.length() == 1) {  
                des += "0";  
            }  
            des += tmp;  
        }  
        return des;  
    }  
}
