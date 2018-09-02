package com.thirteen.web.first;

import com.thirteen.component.first.entity.UserInfo;
import com.thirteen.component.first.service.FirstService;
import com.thirteen.core.response.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(method = RequestMethod.GET)
    public ResponseJson get(UserInfo userInfo){
           return ResponseJson.success(firstService.get(userInfo));
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseJson post(UserInfo userInfo){
        return ResponseJson.success(firstService.post(userInfo));
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseJson put(UserInfo userInfo){
        return ResponseJson.success(firstService.put(userInfo));
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseJson delete(UserInfo userInfo){
        return ResponseJson.success(firstService.delete(userInfo));
    }
}
