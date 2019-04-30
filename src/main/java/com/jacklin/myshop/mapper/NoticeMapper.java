package com.jacklin.myshop.mapper;

import com.jacklin.myshop.entity.Notice;

import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    Notice selectByPrimaryKey(Integer id);

    List<Notice> selectAll();

    int updateByPrimaryKey(Notice record);
    //查询结果总数
    int count();
}