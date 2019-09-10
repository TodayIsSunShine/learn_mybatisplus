package com.xiangzi.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiangzi.mybatisplus.dao.SysUserMapper;
import com.xiangzi.mybatisplus.error.EmBusinessError;
import com.xiangzi.mybatisplus.exception.BusinessException;
import com.xiangzi.mybatisplus.model.SysUser;
import com.xiangzi.mybatisplus.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qianjiu
 * @since 2019-05-24
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public void register(SysUser sysUser) {
        if (StringUtils.isBlank(sysUser.getUsername()) || StringUtils.isBlank(sysUser.getPassword())) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "请输入完整信息");
        }
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", sysUser.getUsername());
        SysUser object = sysUserMapper.selectOne(queryWrapper);
        if (null != object) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "该用户已存在");
        }
        sysUser.setState(0);
        sysUserMapper.insert(sysUser);
    }
}
