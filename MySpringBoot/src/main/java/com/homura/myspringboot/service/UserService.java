package com.homura.myspringboot.service;

import com.homura.myspringboot.dao.UserMapper;

import com.homura.myspringboot.entity.dvo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void add(User user) {
        userMapper.save(user);
    }

    /**
     * 查找全部
     *
     * @return
     */
    public List<User> listAll() {
        return userMapper.findAll();
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
