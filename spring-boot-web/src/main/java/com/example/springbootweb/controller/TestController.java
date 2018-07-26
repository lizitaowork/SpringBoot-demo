package com.example.springbootweb.controller;

import com.example.springbootweb.dao.UserMapper;
import com.example.springbootweb.dao.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zitao.li on 2018/7/26.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Resource
    private UserMapper userMapper;
    @RequestMapping("/{id}")
    public String index(@PathVariable(value = "id") int id, Model model){
        User user = userMapper.selectByPrimaryKey(id);
        List<User> userList = userMapper.selectAll();

        model.addAttribute("singleUser", user);
        model.addAttribute("users", userList);

        return "index";
    }
}
