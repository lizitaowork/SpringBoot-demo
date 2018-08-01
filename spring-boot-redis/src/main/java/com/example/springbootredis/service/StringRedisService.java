package com.example.springbootredis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by zitao.li on 2018/7/30.
 */
@Service
public class StringRedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 保存数据到redis
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value){
        stringRedisTemplate.opsForValue().set(key,value);
        if(value.equals(stringRedisTemplate.opsForValue().get(key))){
            return "set successful";
        }
        return "set failed";
    }

    /**
     * 从redis获取数据
     * @param key
     * @return
     */
    @Cacheable(value = "cache", key = "#key")
    public Object get(String key){
        System.out.println("get方法执行了");
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 删除数据
     * @param key
     * @return
     */
    public Object delete(String key){
        return stringRedisTemplate.delete(key);
    }
}
