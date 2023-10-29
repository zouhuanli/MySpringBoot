package com.homura.myspringboot.entity.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    /**
     * 用户ID
     */
    @NotNull(message = "parameter cannot  be empty")
    private Integer userId;
    /**
     * 用户名字
     */
    @NotEmpty(message = "parameter cannot  be empty")
    private String userName;
}
