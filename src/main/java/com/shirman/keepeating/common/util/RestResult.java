/**
 * <p>Title: CtrlResult.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: OlymTech</p>
 * @author will
 * @date 2015年1月29日
 * @version 1.0
 */
package com.shirman.keepeating.common.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @ClassName: RestResult 
 * @Description: 
 * @author Shirman
 * @date 2015年12月31日 下午1:34:05 
 * @version V1.0
 */
public class RestResult implements Serializable {

	private static final long serialVersionUID = 3164557480468498162L;
	/**
	 * 成功标识
	 */
	public static final Integer RESULT_SUCCESS = 100;
	/**
	 * 失败标识
	 */
	public static final Integer RESULT_FAILURE = 101;
	/**
	 * 默认错误消息
	 */
	public static final String RESULT_FAILURE_MSG = "系统繁忙，稍后重试！";

	private static final Map<Integer, String> RESULT_MSG_MAP = new HashMap<Integer, String>();
	
	{
		RESULT_MSG_MAP.put(RESULT_SUCCESS, "");
		RESULT_MSG_MAP.put(RESULT_FAILURE, RESULT_FAILURE_MSG);
	}
	
	/**
	 * 无参数构造函数
	 */
	public RestResult() {

	}

	/**
	 * 
	 * @param result
	 *            操作结果状态
	 * @param resultMsg
	 *            后台返回值
	 */
	public RestResult(Integer resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}

	/**
	 * 
	 * @param result
	 *            操作结果状态
	 */
	public RestResult(Integer resultCode) {
		if (RestResult.RESULT_FAILURE.equals(resultCode)) {
			this.resultMsg = RestResult.RESULT_FAILURE_MSG;
		}
		this.resultCode = resultCode;
	}

	/**
	 * 
	 * @param resultCode
	 *            操作结果状态
	 * @param data
	 *            返回页面数据
	 */
	public RestResult(Integer resultCode, Object data) {
		this.resultCode = resultCode;
		this.data = data;
	}

	/**
	 * 
	 * @param resultCode
	 *            操作结果状态
	 * @param resultMsg
	 *            后台返回值
	 * @param data
	 *            返回页面数据
	 */
	public RestResult(Integer resultCode, String resultMsg, Object data) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.data = data;
	}

	/**
	 * 返回结果代码
	 */
	private Integer resultCode;
	/**
	 * 消息
	 */
	private String resultMsg = "";
	/**
	 * 返回页面数据
	 */
	private Object data = "";

	/**
	 * @return the resultCode
	 */
	public Integer getResultCode() {
		return resultCode;
	}

	/**
	 * @param resultCode
	 *            要设置的resultCode
	 */
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * @return the resultMsg
	 */
	public String getResultMsg() {
		if (resultMsg != null && resultMsg != "") {
			return resultMsg;
		} else {
			return RESULT_MSG_MAP.get(this.resultCode);
		}
	}

	/**
	 * @param resultMsg
	 *            要设置的resultMsg
	 */
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            要设置的data
	 */
	public void setData(Object data) {
		this.data = data;
	}
}
