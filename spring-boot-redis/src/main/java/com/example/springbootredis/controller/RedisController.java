package com.example.springbootredis.controller;

import com.example.springbootredis.bean.User;
import com.example.springbootredis.bean.vo.RedisRequestVO;
import com.example.springbootredis.service.StringRedisService;
import com.example.springbootredis.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by zitao.li on 2018/7/30.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Resource
    private StringRedisService stringRedisService;
    @Resource
    private UserService userService;

    @RequestMapping("/set")
    public String set(){
        return stringRedisService.set("testSet","hello world!");
    }

    @RequestMapping("/get/{key}")
    public Object get(@PathVariable(value = "key") String key){
        return stringRedisService.get(key);
    }

    @RequestMapping("/delete/{key}")
    public Object delete(@PathVariable(value = "key") String key){
        return stringRedisService.delete(key);
    }

    @RequestMapping(value = "/set/user", method = RequestMethod.POST)
    public String setUser(@RequestBody RedisRequestVO<User> param) {
        return userService.setUser(param.getKey(),param.getData());
    }

    @RequestMapping(value = "/get/user/{key}")
    public User setUser(@PathVariable(value = "key") String key) {
        return userService.getUser(key);
    }
}