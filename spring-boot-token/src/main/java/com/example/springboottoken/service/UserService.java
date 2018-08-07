package com.example.springboottoken.service;

import com.example.springboottoken.dao.UserMapper;
import com.example.springboottoken.dao.bean.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zitao.li on 2018/8/2.
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public Map<String, String> redister(User user){
        Map<String, String> map = new HashMap<>();

        if(user == null){
            map.put("msg", "用户信息不能为空");
            return map;
        }

        if(StringUtils.isEmpty(user.getName())){
            map.put("msg", "用户名不能为空");
            return map;
        }

        if(StringUtils.isEmpty(user.getPassword())){
            map.put("msg", "密码不能为空");
            return map;
        }

        userMapper.insertSelective(user);
        return map;
    }


}
