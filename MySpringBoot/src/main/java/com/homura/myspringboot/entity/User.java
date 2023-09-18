package com.homura.myspringboot.entity;

import lombok.Data;

@Data
public class User {
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户名字
     */
    private String userName;
}
