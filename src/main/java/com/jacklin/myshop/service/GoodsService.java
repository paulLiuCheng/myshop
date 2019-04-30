package com.jacklin.myshop.service;

import com.jacklin.myshop.entity.Goods;

import java.util.List;

public interface GoodsService {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer id);

    List<Goods> selectAll(int page,int limit);

    int updateByPrimaryKey(Goods record);
    int count();
}
