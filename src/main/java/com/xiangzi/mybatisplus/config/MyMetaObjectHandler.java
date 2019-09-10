package com.xiangzi.mybatisplus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * description
 * author:zhangxx
 * Date:2019/6/17
 * Time:10:52
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("自动填充insert方法进入...");
        Object created_time = getFieldValByName("createdTime", metaObject);
        if (null == created_time) {
            setFieldValByName("createdTime", new Date(), metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("自动填充update方法进入...");
        Object modify_time = getFieldValByName("modifyTime", metaObject);
        if (null == modify_time) {
            setFieldValByName("modifyTime", new Date(), metaObject);
        }
    }
}
