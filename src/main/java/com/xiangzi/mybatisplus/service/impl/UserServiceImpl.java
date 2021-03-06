package com.xiangzi.mybatisplus.service.impl;

import com.xiangzi.mybatisplus.model.User;
import com.xiangzi.mybatisplus.dao.UserMapper;
import com.xiangzi.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qianjiu
 * @since 2019-05-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
