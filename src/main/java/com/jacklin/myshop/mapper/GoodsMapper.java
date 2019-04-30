package com.jacklin.myshop.mapper;

import com.jacklin.myshop.entity.Goods;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer id);

    List<Goods> selectAll();

    int updateByPrimaryKey(Goods record);

    //查询结果总数
    int count();
}