package com.homura.myspringboot.service;

import com.github.pagehelper.PageHelper;
import com.homura.myspringboot.dao.UserMapper;

import com.homura.myspringboot.entity.dvo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 添加
     *
     * @param user
     */
    @Transactional
    public void add(User user) {
        userMapper.save(user);
        userMapper.findAll();
        userMapper.findAll();
        userMapper.findAll();
        userMapper.deleteUser(user);

        userMapper.save(user);
    }

    /**
     * 查找全部
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public List<User> listAll() {
        //仅供测试
        PageHelper.startPage(2, 5);
        List<User> list = userMapper.findAll();
        userMapper.findAll();
        userMapper.findAll();
        return list;
    }


    /**
     * 按用户ID查询
     *
     * @param uid
     * @return
     */
    public User getByUid(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }
}
