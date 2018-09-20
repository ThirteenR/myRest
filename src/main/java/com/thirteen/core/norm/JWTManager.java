package com.thirteen.core.norm;

import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * Author: rsq0113
 * Date: 2018-09-03 11:40
 * Description:
 **/
public interface JWTManager {
    String createJWT(User u);
    DecodedJWT validJWT(String jwt);
}
