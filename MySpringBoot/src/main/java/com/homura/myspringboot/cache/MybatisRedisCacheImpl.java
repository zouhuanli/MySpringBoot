package com.homura.myspringboot.cache;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用redis简单实现mybatis的二级缓存
 * Created by homura on 2023/11/18.
 */

public class MybatisRedisCacheImpl implements Cache {
    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisRedisCacheImpl.class);
    private static final ReadWriteLock LOCK = new ReentrantReadWriteLock();
    private static final int EXPIRE_TIME_IN_MINUTES = 30;
    private final String id;
    private static RedisTemplate<String, Object> redisTemplate;
    /**
     * 注意这里注入是静态变量
     *
     * @param redisTemplate
     */
    public static void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        MybatisRedisCacheImpl.redisTemplate = redisTemplate;
    }
    public MybatisRedisCacheImpl( String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key.toString(), value, EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES);
        LOGGER.info("Put query result to redis");
    }

    @Override
    public Object getObject(Object key) {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        LOGGER.info("Get cached query result from redis");
        return opsForValue.get(key.toString());
    }

    @Override
    public Object removeObject(Object key) {
        redisTemplate.delete(key.toString());
        LOGGER.info("Remove cached query result from redis");
        return null;
    }

    @Override
    public void clear() {
        //NOP
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return LOCK;
    }


}
