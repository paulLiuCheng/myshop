package com.jacklin.myshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jacklin.myshop.entity.Notice;
import com.jacklin.myshop.mapper.NoticeMapper;
import com.jacklin.myshop.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class NoticeServiceImpl implements NoticeService {


    @Autowired
    private NoticeMapper noticeMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int insert(Notice record) {
        return noticeMapper.insert(record);
    }

    @Override
    public Notice selectByPrimaryKey(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Notice> selectAll(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Notice> notices = noticeMapper.selectAll();
        PageInfo info = new PageInfo(notices);
        return info.getList();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(Notice record) {
        return noticeMapper.updateByPrimaryKey(record);
    }

    @Override
    public int count() {
        return noticeMapper.count();
    }
}
