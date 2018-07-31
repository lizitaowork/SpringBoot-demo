package com.example.springbootredis.service;

import com.example.springbootredis.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;

/**
 * Created by zitao.li on 2018/7/30.
 */
@Service
public class UserService {
    @Autowired
    private RedisTemplate redisTemplate;

    public String setUser(String key, User user){
        boolean result = redisTemplate.opsForValue().setIfAbsent(key, user);
        if(result){
            return "set user successful";
        }
        return "set user failed";
    }

    public User getUser(String key){
        System.out.println(key + "获取数据！");
        return (User)redisTemplate.opsForValue().get(key);
    }
}
