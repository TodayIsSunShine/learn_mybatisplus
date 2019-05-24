package com.xiangzi.mybatisplus.plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiangzi.mybatisplus.dao.UserMapper;
import com.xiangzi.mybatisplus.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * description
 * author:zhangxx
 * Date:2019/5/23
 * Time:17:33
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectAll() {
        List<User> users = userMapper.selectList(null);
        Assert.assertEquals(5, users.size());
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectCondition() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("max(id) as id,name,age,email");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void testPage() {
        Page<User> page = new Page<>(1, 2);
        IPage<User> userIPage = userMapper.selectPage(page, new QueryWrapper<User>().gt("age", 6));
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
    }

    @Test
    public void testUpdate() {
        userMapper.update(
                null,
                Wrappers.<User>lambdaUpdate().set(User::getEmail, "123@123").eq(User::getId, 2)
        );
    }

    @Test
    public void testPageByCondition() {
        userMapper.selectList(new QueryWrapper<User>()
                .like("name", "sm").or().like("email", "sm").orderByDesc("id")).forEach(System.out::println);
    }

}
