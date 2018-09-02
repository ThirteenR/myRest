package com.thirteen.core.norm;

import java.util.List;

/**
 * Author: rsq0113
 * Date: 2018-08-31 15:17
 * Description:
 **/
public interface BaseService<T> {
    int post(T t);

    List<T> get(T t);

    int put(T t);

    int delete(T t);
}
