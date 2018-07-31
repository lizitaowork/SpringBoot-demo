package com.example.springbootredis.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 缓存实现类
 * Created by zitao.li on 2018/7/31.
 */
@Service
public class CacheService {
    private Map<Integer, String> map = new HashMap<>();

    @PostConstruct
    public void init(){
        map.put(1,"张三");
        map.put(2,"李四");
    }

    /**
     * 查找，如果没有缓存，查询并做缓存；
     * 如果有缓存，直接拿缓存
     * @param key
     * @return
     */
    @Cacheable(value = "generator", key = "'map_'+#key")
    public String get(int key){
        System.out.println(key + "获取数据！");
        return map.get(key);
    }

    /**
     * 插入或更新数据
     * 插入或更新成功，缓存到generator,如果缓存已存在则更新缓存
     * @param key
     * @param value
     * @return
     */
    @CachePut(value = "generator", key = "'map_'+#key")
    public String put(int key, String value){
        System.out.println(key + "更新数据为："+value);
        map.put(key, value);
        return map.get(key);
    }

    /**
     * 删除数据并删除缓存
     * @param key
     * @return
     */
    @CacheEvict(value = "generator", key = "'map_'+#key")
    public String remove(int key){
        System.out.println(key + "删除数据");
        map.remove(key);
        return "remove success";
    }

    /**
     * 自定义key
     * @param key
     * @return
     */
    @Cacheable(value = "keyGenerator",keyGenerator = "keyGenerator")
    public String cacheOfKeyGenerator(int key){
        System.out.println(key + "获取数据！");
        return map.get(key);
    }
}
