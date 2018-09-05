package com.thirteen.core.web.first;

import com.thirteen.component.user.entity.UserInfo;
import com.thirteen.component.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Author: rsq0113
 * Date: 2018-09-01 10:32
 * Description:
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class FirstTest {
    @Resource
    UserService firstService;
    @Test
    public void get(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1);
        firstService.get(userInfo);
    }
}
