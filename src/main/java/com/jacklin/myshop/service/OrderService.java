package com.jacklin.myshop.service;

import com.jacklin.myshop.entity.Order;

import java.util.List;

public interface OrderService {

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer id);

    List<Order> selectAll(int page, int limit);

    int updateByPrimaryKey(Order record);

    int count();
}
