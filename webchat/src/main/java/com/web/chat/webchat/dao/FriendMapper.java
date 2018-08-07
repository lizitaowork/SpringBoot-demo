package com.web.chat.webchat.dao;

import com.web.chat.webchat.dao.bean.Friend;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Friend record);

    int insertSelective(Friend record);

    Friend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Friend record);

    int updateByPrimaryKey(Friend record);
}