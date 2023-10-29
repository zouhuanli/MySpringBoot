package com.homura.myspringboot.dao;


import com.homura.myspringboot.entity.dvo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 查找全部用户
     * <p>
     * 不要使用 select  *
     *
     * @return
     */
    @Select("select * from user")
    @ResultMap("BaseResultMap")
    List<User> findAll();

    /**
     * 添加用户
     *
     * @param user 用户
     * @return
     */
    @Insert(" insert  into user (uid,uname,password,gender,phone,email,address) " +
            " values " +
            " (#{user.uid},#{user.uname},#{user.password},#{user.gender},#{user.phone},#{user.email},#{user.address})")
    @ResultType(int.class)
    int save(@Param("user") User user);


    /**
     * 根据id查询用户
     * 不要使用 select  *
     *
     * @param uid 用户id
     * @return
     */
    @Select("select * from user where uid = #{uid}")
    @Results(id = "BaseResultMapByAnnotation", value =
            {@Result(id = true, property = "uid", column = "uid", jdbcType = JdbcType.INTEGER)
                    , @Result(property = "uname", column = "uname", jdbcType = JdbcType.VARCHAR)
                    , @Result(property = "password", column = "password", jdbcType = JdbcType.VARCHAR)
                    , @Result(property = "gender", column = "gender", jdbcType = JdbcType.VARCHAR)
                    , @Result(property = "phone", column = "phone", jdbcType = JdbcType.VARCHAR)
                    , @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR)
                    , @Result(property = "address", column = "address", jdbcType = JdbcType.VARCHAR)})
    User selectByPrimaryKey(@Param("uid") Integer uid);
}
