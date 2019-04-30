package com.jacklin.myshop.mapper;

import com.jacklin.myshop.entity.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);
    Order selectByPrimaryKey(Integer id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);

    int count();
}