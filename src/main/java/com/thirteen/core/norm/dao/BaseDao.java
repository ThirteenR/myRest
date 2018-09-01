package com.thirteen.core.norm.dao;

import java.util.List;

/**
 * Author: rsq0113
 * Date: 2018-08-31 15:16
 * Description:
 **/
public interface BaseDao<T> {
    int post(T t);

    List<T> get(T t);

    int put(T t);

    int delete(T t);
}
