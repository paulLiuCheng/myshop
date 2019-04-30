package com.jacklin.myshop.service;

import com.jacklin.myshop.entity.AdminUser;

public interface AdminUserService {
    AdminUser selectByUser(String ausername, String apassword);

}
