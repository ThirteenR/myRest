package com.thirteen.core.norm;

import com.thirteen.core.response.ResponseJson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: rsq0113
 * Date: 2018-09-03 15:51
 * Description:
 **/
public interface LoginHandler {
   ResponseJson login(HttpServletRequest request, HttpServletResponse response, User u);
   ResponseJson logout(HttpServletRequest request, HttpServletResponse response,User u);
}
