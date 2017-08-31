package com.shop.category.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.shop.category.dao.CategoryDao;
import com.shop.category.domain.Category;

public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

	@Override
	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list = (List<Category>) this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
		
	}

	@Override
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
		
	}
	
	@Override
	public void delete(Category c) {
		this.getHibernateTemplate().delete(c);
		
	}

	@Override
	public void update(Category category) {
		this.getHibernateTemplate().update(category);
		
	}
	
	
	
}
