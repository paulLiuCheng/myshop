package com.jacklin.myshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jacklin.myshop.entity.Goods;
import com.jacklin.myshop.mapper.GoodsMapper;
import com.jacklin.myshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    @Override
    public Goods selectByPrimaryKey(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Goods> selectAll(int page, int limit) {
        //分页
        PageHelper.startPage(page, limit);
        List<Goods> goods = goodsMapper.selectAll();
        PageInfo info = new PageInfo(goods);
        return info.getList();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(Goods record) {
        return goodsMapper.updateByPrimaryKey(record);
    }

    @Override
    public int count() {
        return goodsMapper.count();
    }
}
