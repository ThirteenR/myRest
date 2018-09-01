package com.thirteen.core.component.first.service;

import com.thirteen.core.component.first.dao.FirstDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: rsq0113
 * Date: 2018-08-31 15:44
 * Description:
 **/
@Service
public class FirstServiceImpl<UserInfo> implements FirstService<UserInfo> {
     @Resource
    FirstDao firstDao;
    @Override
    public int post(UserInfo u) {
        return firstDao.post(u);
    }

    @Override
    public List<UserInfo> get(UserInfo u) {
        return firstDao.get(u);
    }

    @Override
    public int put(UserInfo t) {
        return 0;
    }

    @Override
    public int delete(UserInfo t) {
        return 0;
    }
}
