package com.example.springbootredis.controller;

import com.example.springbootredis.service.CacheService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zitao.li on 2018/7/31.
 */
@RestController
@RequestMapping("/cache")
public class CacheController {
    @Resource
    private CacheService cacheService;

    @RequestMapping("/get")
    public String get(int key){
        return cacheService.get(key);
    }

    @RequestMapping("/put")
    public String put(int key, String value){
        return cacheService.put(key, value);
    }

    @RequestMapping("/remove")
    public String remove(int key){
        return cacheService.remove(key);
    }

    @RequestMapping("/get/generator")
    public String cacheOfKeyGenerator(int key){
        return cacheService.cacheOfKeyGenerator(key);
    }

}
