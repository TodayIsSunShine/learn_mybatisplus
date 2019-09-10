package com.xiangzi.mybatisplus.controller;


import com.xiangzi.mybatisplus.model.SysUser;
import com.xiangzi.mybatisplus.response.CommonReturnType;
import com.xiangzi.mybatisplus.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qianjiu
 * @since 2019-05-24
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;


    @GetMapping("/index")
    public String index() {
        return "admin/login";
    }

    @PostMapping("/register")
    @ResponseBody
    public CommonReturnType register(@RequestBody SysUser sysUser) {
        sysUserService.register(sysUser);
        return CommonReturnType.create(null);
    }

}

