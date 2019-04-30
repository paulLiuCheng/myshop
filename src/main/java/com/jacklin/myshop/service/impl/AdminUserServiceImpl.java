package com.jacklin.myshop.service.impl;

import com.jacklin.myshop.entity.AdminUser;
import com.jacklin.myshop.mapper.AdminUserMapper;
import com.jacklin.myshop.service.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Transactional(readOnly = true)
@Service
public class AdminUserServiceImpl implements AdminUserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser selectByUser(String ausername, String apassword) {
        if (ausername != null && apassword != null) {
            return adminUserMapper.selectByUser(ausername, DigestUtils.md5DigestAsHex(apassword.getBytes()));
        }
        return null;
    }
}
