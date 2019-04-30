package com.jacklin.myshop.service.impl;

import com.jacklin.myshop.entity.GoodsType;
import com.jacklin.myshop.mapper.GoodsTypeMapper;
import com.jacklin.myshop.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品类型ServiceImpl
 */
@Transactional(readOnly = true)
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsTypeMapper.deleteByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public int insert(GoodsType record) {
        return goodsTypeMapper.insert(record);
    }

    @Override
    public GoodsType selectByPrimaryKey(Integer id) {
        return goodsTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GoodsType> selectAll() {
        return goodsTypeMapper.selectAll();
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(GoodsType record) {
        return goodsTypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public int count() {
        return goodsTypeMapper.count();
    }
}
