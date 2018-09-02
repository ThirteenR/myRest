package com.thirteen.component.first.service;

import com.thirteen.core.norm.BaseService;

import java.util.List;

/**
 * Author: rsq0113
 * Date: 2018-08-31 15:43
 * Description:
 **/
public interface FirstService<T> extends BaseService<T> {
    @Override
    int post(T t);

    @Override
    List<T> get(T t);

    @Override
    int put(T t);

    @Override
    int delete(T t);
}
