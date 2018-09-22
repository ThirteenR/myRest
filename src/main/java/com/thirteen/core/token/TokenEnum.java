package com.thirteen.core.token;

/**
 * Author: rsq0113
 * Date: 2018-09-21 16:08
 * Description:
 **/
public enum TokenEnum {
    USER_ID("userId"),
    USER_NAME("userName"),
    USER_RAND("userRand"),
    ISS("iss"), // JWT的签发者
    sub("sub"),// JWT所面向的用户
    AUD("aud"),// 接收JWT的一方
    EXP("exp"),// JWT的过期时间
    NBF("nbf"),// 在xxx日期之间，该JWT都是可用的
    IAT("iat"),// 该JWT签发的时间
    JTI("jti");//JWT的唯一身份标识
    private String value;

    TokenEnum(String s) {
        value = s;
    }

    public String getValue() {
        return value;
    }
}
