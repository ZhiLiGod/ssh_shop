package com.shop.user.service;

import com.shop.user.domain.User;

public interface UserService {
	public User findByName(String username);

	public void save(User user);
	
	public User findByCode(String code);
	
	public void update(User user);

	public User login(User user);
}
