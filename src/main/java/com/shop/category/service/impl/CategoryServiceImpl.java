package com.shop.category.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shop.category.dao.CategoryDao;
import com.shop.category.domain.Category;
import com.shop.category.service.CategoryService;

@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryDao categoryDao;
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	@Override
	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}
	@Override
	public void save(Category category) {
		categoryDao.save(category);
		
	}
	@Override
	public Category findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return categoryDao.findByCid(cid);
	}
	@Override
	public void delete(Category c) {
		categoryDao.delete(c);
		
	}
	@Override
	public void update(Category category) {
		categoryDao.update(category);
		
	}
	
}
