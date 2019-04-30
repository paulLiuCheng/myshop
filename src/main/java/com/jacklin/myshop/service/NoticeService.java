package com.jacklin.myshop.service;

import com.jacklin.myshop.entity.Notice;

import java.util.List;

public interface NoticeService {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    Notice selectByPrimaryKey(Integer id);

    List<Notice> selectAll(int page, int limit);

    int updateByPrimaryKey(Notice record);
    //查询结果总数
    int count();
}
