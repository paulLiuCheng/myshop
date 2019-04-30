package com.jacklin.myshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jacklin.myshop.entity.User;
import com.jacklin.myshop.mapper.UserMapper;
import com.jacklin.myshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户ServiceImpl
 */

@Transactional(readOnly = true) //类中所有方法默认的事务
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectAll(int page, int limit) {
        //进行分页
        PageHelper.startPage(page, limit);
        List<User> users = userMapper.selectAll();
        PageInfo info = new PageInfo(users);
        return info.getList();
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> selectByUsername(String username, int page, int limit) {
        //进行分页
        PageHelper.startPage(page, limit);
        List<User> users = userMapper.selectByUsername(username);
        PageInfo info = new PageInfo(users);
        return info.getList();
    }

    @Override
    public int count() {
        return userMapper.count();
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
