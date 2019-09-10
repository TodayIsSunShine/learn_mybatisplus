package com.xiangzi.mybatisplus.error;

/**
 * commonError
 */
public interface CommonError {
    public int getErrCode();

    public String getErrMsg();

    public CommonError setErrMsg(String errMsg);
}
