package com.jacklin.myshop.mapper;

import com.jacklin.myshop.entity.OrderDetail;

import java.util.List;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer id);
    int deleteByOrderId(Integer id);
    int insert(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer id);

    List<OrderDetail> selectAll();

    int updateByPrimaryKey(OrderDetail record);
}