package com.thirteen.web.first;

import com.thirteen.core.component.first.entity.UserInfo;
import com.thirteen.core.component.first.service.FirstService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: rsq0113
 * Date: 2018-08-31 15:51
 * Description:
 **/
@RestController
@RequestMapping("/firstCtrl")
public class FirstCtrl {
    @Resource
    FirstService firstService;
    private Logger logger = LoggerFactory.getLogger(FirstCtrl.class);
    @RequestMapping("/get/{userId}")
    public List<UserInfo> get(@PathVariable(value = "userId") int userId, UserInfo userInfo){
        userInfo.setUserId(userId);
           return firstService.get(userInfo);
    }
    @RequestMapping("/get")
    public List<UserInfo> get(UserInfo userInfo){
        return firstService.get(userInfo);
    }
}
