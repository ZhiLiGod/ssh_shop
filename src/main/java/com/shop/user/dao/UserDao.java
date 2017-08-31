package com.shop.user.dao;

import com.shop.user.domain.User;

public interface UserDao {
	public User findByName(String username);

	public void save(User user);
	
	public User findByCode(String code);
	
	public void update(User user);
	
	public User login(User user);
}
