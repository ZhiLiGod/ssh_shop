package com.shop.user.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.shop.user.dao.UserDao;
import com.shop.user.dao.impl.UserDaoImpl;
import com.shop.user.domain.User;
import com.shop.user.service.UserService;
import com.shop.utils.MailUtils;
import com.shop.utils.UUIDUtils;

@Transactional
public class UserServiceImpl implements UserService {
	private UserDao userDao;
		
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public User findByName(String username){
		return userDao.findByName(username);
	}


	@Override
	public void save(User user) {
		//将数据存入数据库
		user.setState(0); //0代表用户未激活    1代表已经激活
		String code = UUIDUtils.getUUID() + UUIDUtils.getUUID(); 
		user.setCode(code);
		
		userDao.save(user);
		MailUtils.sendMail(user.getEmail(), code);
	}


	@Override
	public User findByCode(String code) {
		
		return userDao.findByCode(code);
	}


	@Override
	public void update(User user) {
		userDao.update(user);
		
	}


	@Override
	public User login(User user) {
		
		return userDao.login(user);
	}
	
}
