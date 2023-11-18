package com.homura.myspringboot.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class MybatisCacheConfig {

    @Autowired
    public void setRedisTemplate(@Autowired @Qualifier("myRedisTemplate") RedisTemplate<String, Object> redisTemplate) {
        MybatisRedisCacheImpl.setRedisTemplate(redisTemplate);
    }
}
