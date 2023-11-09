package com.homura.myspringboot.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorMapper {


    @Select("select * from actor where actor_id = #{actorId}")
    @Results(id = "actorMap", value = {
            @Result(property = "actorId", column = "actor_id", id = true),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "lastUpdate", column = "last_update")
    })
    ActorMapper selectByPrimaryKey(@Param("actorId") Integer actorId);


}
