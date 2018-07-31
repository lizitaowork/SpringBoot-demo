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

    public String set(String key, String value){
        stringRedisTemplate.opsForValue().set(key,value);
        if(value.equals(stringRedisTemplate.opsForValue().get(key))){
            return "set successful";
        }
        return "set failed";
    }

    @Cacheable(value = "cache", key = "#key")
    public Object get(String key){
        System.out.println("get方法执行了");
        return stringRedisTemplate.opsForValue().get(key);
    }

    public Object delete(String key){
        return stringRedisTemplate.delete(key);
    }
}
