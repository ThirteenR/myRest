package com.thirteen.web.exception;

import com.thirteen.core.exception.ExceptionHandle;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: rsq0113
 * Date: 2018-09-02 11:45
 * Description:
 **/
@ControllerAdvice
@ResponseBody
public class ExceptionCtrl extends ExceptionHandle {
}
