package com.jacklin.myshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jacklin.myshop.entity.Order;
import com.jacklin.myshop.mapper.OrderMapper;
import com.jacklin.myshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单ServiceImpl
 */
@Transactional(readOnly = true)
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public List<Order> selectAll(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Order> orders = orderMapper.selectAll();
        PageInfo info = new PageInfo(orders);
        return info.getList();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }


    @Override
    public Order selectByPrimaryKey(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int count() {
        return orderMapper.count();
    }
}
