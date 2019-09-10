package com.xiangzi.mybatisplus.exception;


import com.xiangzi.mybatisplus.error.EmBusinessError;
import com.xiangzi.mybatisplus.response.CommonReturnType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 定义exceptionhandler解决未被controller层吸收的exception
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Object handlerBusinessException(BusinessException ex) {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("errCode", ex.getErrCode());
        responseData.put("errMsg", ex.getErrMsg());
        return CommonReturnType.create(responseData, "fail");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public CommonReturnType handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("errCode", 500);
        responseData.put("errMsg", "数据库已存在");
        return CommonReturnType.create(responseData, "fail");
    }

    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("errCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
        responseData.put("errMsg", EmBusinessError.UNKNOWN_ERROR.getErrMsg());
        return CommonReturnType.create(responseData, "fail");
    }
}
