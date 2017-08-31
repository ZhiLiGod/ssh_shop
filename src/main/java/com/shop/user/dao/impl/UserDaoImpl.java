package com.shop.user.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.shop.user.dao.UserDao;
import com.shop.user.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
	//按照名称查询是否有该用户
	@Override
	public User findByName(String username) {
		String hql = "from User where username = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username);
		if(list != null && list.size()>0){
			return list.get(0);
		}else {
			return null;
		}
	
	}

	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
		
	}

	@Override
	public User findByCode(String code) {
		String hql = "from User where code=?";
		List<User> user = (List<User>) this.getHibernateTemplate().find(hql, code);
		
		if(user!=null||user.size()>0){
			return user.get(0);
		}
		return null;
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	@Override
	public User login(User user) {
		String hql = "from User where username = ? and password = ? and state = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, user.getUsername(), user.getPassword(), 1);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		
		return null;
	}
	
	
	
}
