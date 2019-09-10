package com.xiangzi.mybatisplus.response;

import lombok.Getter;
import lombok.Setter;

/**
 * 通用返回格式
 */
@Getter
@Setter
public class CommonReturnType {

    private Integer code;
    private String status;
    private Object data;

    /**
     * 定义一个通用的创建方法
     *
     * @param result
     * @return
     */
    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result, 0, "success");
    }

    public static CommonReturnType create(Object result, int code, String status) {
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setData(result);
        commonReturnType.setCode(code);
        commonReturnType.setStatus(status);
        return commonReturnType;
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setData(result);
        type.setStatus(status);
        return type;
    }

}
