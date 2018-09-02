package com.thirteen.core.response;
/*
 * rsq0113 2018年3月22日
 */
public class ResponseJson {
	private Integer status;
	private String message;
	private Object data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 描述:请求成功
	 * 
	 * @return 2018年3月22日 rsq0113
	 */
	public static ResponseJson success(Object data) {
		return new ResponseJson(data);
	}

	/**
	 * 描述:请求出现异常
	 * 
	 * @param status
	 * @param message
	 * @return 2018年3月22日 rsq0113
	 */
	public static ResponseJson error(Integer status, String message) {
		return new ResponseJson(status, message, null);
	}

	/**
	 * 描述:结果状态是否成功
	 * 
	 * @return 2018年3月22日 rsq0113
	 */
	public boolean isSuccess() {
		return this.status == 200 ? true : false;
	}

	/**
	 * @param data
	 */
	public ResponseJson(Object data) {
		super();
		this.status = ResponseEnum.SUCCESS.getStatus();
		this.message = ResponseEnum.SUCCESS.getMessage();
		this.data = data;
	}

	/**
	 * @param status
	 * @param message
	 * @param data
	 */
	public ResponseJson(Integer status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	/**
	 * 构造方法
	 */
	public ResponseJson() {
		super();
		this.status = ResponseEnum.SUCCESS.getStatus();
		this.message = ResponseEnum.SUCCESS.getMessage();
		this.data = null;
	}
}
