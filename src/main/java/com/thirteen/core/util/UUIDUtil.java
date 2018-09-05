package com.thirteen.core.util;

import java.util.UUID;

/**
 * Author: rsq0113
 * Date: 2018-09-03 14:41
 * Description:
 **/
public class UUIDUtil {
    public static String createUUID(){
       return format( UUID.randomUUID().toString());
    }
    private static String format(String uuid){
        return uuid.replace("-","");
    }
}
