package com.thirteen.component.first.service;

import com.thirteen.component.first.dao.FirstDao;
import com.thirteen.component.first.entity.UserInfo;
import com.thirteen.core.exception.ConstException;
import com.thirteen.core.response.ResponseEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: rsq0113
 * Date: 2018-08-31 15:44
 * Description:
 **/
@Service
public class FirstServiceImpl<T> implements FirstService<T> {
     @Resource
     FirstDao firstDao;
    @Override
    public int post(T t) {
        return firstDao.post(t);
    }

    @Override
    public List<T> get(T t) {
        return firstDao.get(t);
    }

    @Override
    public int put(T t) {
        return 0;
    }

    @Override
    public int delete(T t) {
        return 0;
    }
}
