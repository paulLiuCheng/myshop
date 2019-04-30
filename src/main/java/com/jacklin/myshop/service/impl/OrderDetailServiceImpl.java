package com.jacklin.myshop.service.impl;

import com.jacklin.myshop.entity.OrderDetail;
import com.jacklin.myshop.mapper.OrderDetailMapper;
import com.jacklin.myshop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单详情ServiceImpl
 */
@Transactional(readOnly = true)
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return orderDetailMapper.deleteByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int insert(OrderDetail record) {
        return orderDetailMapper.insert(record);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int deleteByOrderId(Integer id) {
        return orderDetailMapper.deleteByOrderId(id);
    }

    @Override
    public OrderDetail selectByPrimaryKey(Integer id) {
        return orderDetailMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<OrderDetail> selectAll() {
        return orderDetailMapper.selectAll();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(OrderDetail record) {
        return orderDetailMapper.updateByPrimaryKey(record);
    }
}
