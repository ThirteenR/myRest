package com.thirteen.core.response;

public enum ResponseEnum {
	LOGIN_ERROR(101,"登陆失败！"),
	NOT_LOGIN(102,"未登录!"),
	SUCCESS(200,"成功！"),
	IS_DOUBLE(201,"此客户端已有用户登录！"),
	HAS_LANDED(202,"此用户在别处登录！"),
    NULL_PASSWORD(103,"密码加密失败！"),
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
