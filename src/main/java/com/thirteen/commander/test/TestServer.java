package com.thirteen.commander.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author: rsq0113
 * Date: 2019-01-15 13:22
 * Description:
 **/
@RestController
@RequestMapping("/TestServer")
public class TestServer {
    @RequestMapping("/phoneRe")
    public HashMap<String, Object> phoneRe(HttpServletRequest request){
        System.out.println(request.getContentType());
        System.out.println(request.getParameterMap().get(0));
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        HashMap<String, Object> RSP_PARAM = new HashMap<String, Object>();
        HashMap<String, Object> PUB_INFO = new HashMap<String, Object>();
        HashMap<String, Object> PAGE_INFO = new HashMap<String, Object>();
        HashMap<String, Object> BUSI_INFO = new HashMap<String, Object>();
        stringObjectHashMap.put("RSP_PARAM",RSP_PARAM);
        RSP_PARAM.put("PUB_INFO",PUB_INFO);
        RSP_PARAM.put("PAGE_INFO",PAGE_INFO);
        RSP_PARAM.put("BUSI_INFO",BUSI_INFO);
        PUB_INFO.put("CODE","A0000");
        PUB_INFO.put("MESSAGE","成功");
        PUB_INFO.put("RSP_SERIAL_NO","36UUID0022");
        PUB_INFO.put("REQ_SERIAL_NO","CALL20180205101527057321");
        PUB_INFO.put("RSP_TIME","20180205101528");
        PAGE_INFO.put("RECORD_COUNT","");
        BUSI_INFO.put("ID_VALUE","1390931xxxx");
        BUSI_INFO.put("CHANNEL_TRANS_NO","448888323223232");
        HashMap<String, String> listMap = new HashMap<String, String>();
        ArrayList<HashMap> list = new ArrayList<HashMap>();
        BUSI_INFO.put("ATTRIBUTE",list);
        list.add(listMap);
        listMap.put("ATTRIBUTE","XXX");
        listMap.put("VALUE","YYY");
        BUSI_INFO.put("ATTRIBUTE",list);
        return stringObjectHashMap;

    }
}
