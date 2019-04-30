package com.jacklin.myshop.service;

import com.jacklin.myshop.entity.User;

import java.util.List;

public interface UserService {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll(int page, int limit);

    int updateByPrimaryKey(User record);
    List<User> selectByUsername(String username,int page, int limit);
    int count();

    List<User> selectAll();
}
