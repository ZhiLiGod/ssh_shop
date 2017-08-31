package com.shop.categorysecond.dao;

import java.util.List;

import com.shop.categorysecond.domain.CategorySecond;

public interface CategorySecondDao {

	public int findCount();

	public List<CategorySecond> findByPage(int begin, int limit);

	public void save(CategorySecond categorySecond);

	public CategorySecond findByCsid(Integer csid);

	public void delete(CategorySecond categorySecond);

	public void update(CategorySecond categorySecond);

	public List<CategorySecond> findAll();

}
