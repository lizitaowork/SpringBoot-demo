package com.example.springbootcache.controller;

import com.example.springbootcache.service.CacheService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zitao.li on 2018/7/31.
 */
@RestController
@RequestMapping("/cache")
public class CacheController {
    @Resource
    private CacheService cacheService;

    @RequestMapping("/put")
    public String put(Long id, String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  sdf.format(new Date()) + " : value is " + cacheService.put(id, value) ;
    }

    @RequestMapping("/get")
    public String query(Long id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date()) + " : value is " +cacheService.query(id) ;
    }

    @RequestMapping("/remove")
    public String remove(Long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cacheService.remove(id) ;
        return sdf.format(new Date()) + " : success " ;
    }

}
