package com.shop.categorysecond.service;

import java.util.List;

import com.shop.categorysecond.domain.CategorySecond;
import com.shop.utils.PageBean;

public interface CategorySecondService {

	public PageBean<CategorySecond> findByPage(Integer page);

	public void save(CategorySecond categorySecond);

	public CategorySecond findByCsid(Integer csid);

	public void delete(CategorySecond categorySecond);

	public void update(CategorySecond categorySecond);

	public List<CategorySecond> findAll();

}
