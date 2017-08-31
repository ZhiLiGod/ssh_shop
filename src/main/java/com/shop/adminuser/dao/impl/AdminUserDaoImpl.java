package com.shop.adminuser.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.shop.adminuser.dao.AdminUserDao;
import com.shop.adminuser.domain.AdminUser;

public class AdminUserDaoImpl extends HibernateDaoSupport implements AdminUserDao {

	@Override
	public AdminUser login(AdminUser adminUser) {
		String hql = "from AdminUser where username=? and password=?";
		List<AdminUser> ad = (List<AdminUser>) this.getHibernateTemplate().find(hql, adminUser.getUsername(), adminUser.getPassword());
		
		if(ad != null && ad.size()>0){
			return ad.get(0);
		}
		return null;
	}
	
}
