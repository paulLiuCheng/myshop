package com.jacklin.myshop.mapper;

import com.jacklin.myshop.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    int count();

    List<User> selectByUsername(String username);
}