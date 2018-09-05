package com.thirteen.core.norm;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: rsq0113
 * Date: 2018-09-04 18:19
 * Description:
 **/
public class BaseServiceImpl<T> implements BaseService<T>{
    @Resource
    BaseDao basedao;
    @Override
    public int post(T t) {
        return 0;
    }
    @Override
    public List<T> get(T t) {
        return basedao.get(t);
    }

    @Override
    public int put(T t) {
        return basedao.put(t);
    }

    @Override
    public int delete(T t) {
        return basedao.delete(t);
    }
}
