package com.homura.myspringboot.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class MybatisCacheConfig {
    private static final AtomicInteger id = new AtomicInteger(0);

    @Bean("mybatisCacheId")
    public String generateId() {
        return "MYBATIS_CACHE_" + id.getAndIncrement();
    }

    @Autowired
    public void setRedisTemplate(@Autowired @Qualifier("myRedisTemplate") RedisTemplate<String, Object> redisTemplate) {
        MybatisRedisCacheImpl.setRedisTemplate(redisTemplate);
    }
}
