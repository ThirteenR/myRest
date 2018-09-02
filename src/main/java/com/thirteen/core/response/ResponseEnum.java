package com.thirteen.core.response;

public enum ResponseEnum {
	
	SUCCESS(200,"成功"),
	
	NUKNOW_ERROR(100,"未知错误");
	
	private Integer status;
	private String message;
	ResponseEnum(Integer status, String message) {
		this.status = status;
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
}
