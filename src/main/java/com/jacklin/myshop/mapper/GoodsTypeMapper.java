package com.jacklin.myshop.mapper;

import com.jacklin.myshop.entity.GoodsType;

import java.util.List;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsType record);

    GoodsType selectByPrimaryKey(Integer id);

    List<GoodsType> selectAll();

    int updateByPrimaryKey(GoodsType record);

    int count();
}