package com.homura.myspringboot.dao;

import com.homura.myspringboot.entity.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserMapper {
    //示例DAO层，还未使用数据库和mybatis。有并发问题
    private final List<User> userList = new ArrayList<>();

    /**
     * 添加
     *
     * @param user
     */
    public void save(User user) {
        userList.add(user);
    }

    /**
     * 查找全部
     *
     * @return
     */
    public List<User> findAll() {
        return userList;
    }
}
