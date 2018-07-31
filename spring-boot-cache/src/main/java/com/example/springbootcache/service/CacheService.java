package com.example.springbootcache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.SimpleFormatter;

/**
 * Created by zitao.li on 2018/7/31.
 */
@Service
public class CacheService {
    private Map<Long, String> dataMap = new HashMap<>();

    @PostConstruct
    public void init(){
        dataMap.put(1L, "张三");
        dataMap.put(2L, "李四");
        dataMap.put(3L, "王五");
    }

    /**
     * 如果数据没有缓存，从dataMap里面获取，并做缓存；
     * 如果有缓存，从guavaDemo中获取
     * @param id
     * @return
     */
    @Cacheable(value = "guavaDemo", key = "#id + 'dataMap'")
    public String query(Long id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + "query id is " + id);
        return dataMap.get(id);
    }

    /**
     * 插入 或者更新
     * 插入或更新数据到dataMap中
     * 并且缓存到 guavaDemo中
     * 如果存在了那么更新缓存中的值
     * 其中key 为 #id+dataMap
     */
    @CachePut(value="guavaDemo" ,key="#id + 'dataMap'")
    public String put(Long id, String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + " : add data ,id is "+ id);
        dataMap.put(id, value);
        return value;
    }

    /**
     * 删除
     * 删除dataMap里面的数据
     * 并且删除缓存guavaDemo中的数据
     * 其中key 为 #id+dataMap
     */
    @CacheEvict(value="guavaDemo" , key="#id + 'dataMap'")
    public void remove(Long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + " : remove id is "+ id + " data");
        dataMap.remove(id);
        // data remove
    }

}
