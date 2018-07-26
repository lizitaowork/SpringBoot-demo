package com.example.springbootweb.dao;

import com.example.springbootweb.dao.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zitao.li on 2018/7/26.
 */
@Repository
public interface UserMapper {
    User selectByPrimaryKey(int id);
    List<User> selectAll();
}
