package com.thirteen.core.exception;


import com.thirteen.core.response.ResponseEnum;

/**
 * rsq0113
 * 2018年3月22日
 */
public class ConstException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Integer status;

	public ConstException(ResponseEnum re, String msg) {
		super(msg==null || "".equals(msg)?re.getMessage():msg);
		this.status = re.getStatus();
	}

	public Integer getStatus() {
		return status;
	}
}
