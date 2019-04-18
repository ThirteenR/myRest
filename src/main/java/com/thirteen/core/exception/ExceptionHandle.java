package com.thirteen.core.exception;

import com.thirteen.core.response.ResponseJson;
import org.springframework.web.bind.annotation.ExceptionHandler;



public abstract class ExceptionHandle {

	/**
	 * 描述:统一异常处理
	 * @param exception
	 * @return
	 * 2018年3月22日
	 * rsq0113
	 */
	    @ExceptionHandler(value= Exception.class)
        public ResponseJson handle(Exception exception){
	       if(exception instanceof ConstException)
			return ResponseJson.error(((ConstException) exception).getStatus(),exception.getMessage());
			return ResponseJson.error(500,exception.getMessage());
        }
}
