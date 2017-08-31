package com.shop.adminuser.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.shop.adminuser.dao.AdminUserDao;
import com.shop.adminuser.domain.AdminUser;
import com.shop.adminuser.service.AdminUserService;
@Transactional
public class AdminUserServiceImpl implements AdminUserService{
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	
	//登陆
	@Override
	public AdminUser login(AdminUser adminUser) {		
		return adminUserDao.login(adminUser);
	}
	
		
}
