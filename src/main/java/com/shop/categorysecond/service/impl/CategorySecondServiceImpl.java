package com.shop.categorysecond.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shop.categorysecond.dao.CategorySecondDao;
import com.shop.categorysecond.domain.CategorySecond;
import com.shop.categorysecond.service.CategorySecondService;
import com.shop.utils.PageBean;

@Transactional
public class CategorySecondServiceImpl implements CategorySecondService {
	
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	@Override
	public PageBean<CategorySecond> findByPage(Integer page) {
		PageBean<CategorySecond> pb = new PageBean<CategorySecond>();
		pb.setPage(page);
		int limit = 10;
		pb.setLimit(limit);
		int totalCount = 0;
		totalCount = categorySecondDao.findCount();
		pb.setTotalCount(totalCount);
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount/limit;
		}else{
			totalPage = totalCount/limit + 1;
		}
		pb.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin, limit);
		pb.setList(list);
		return pb;
	}

	@Override
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
		
	}
	
	//根据二级分类id查询
	@Override
	public CategorySecond findByCsid(Integer csid) {
		// TODO Auto-generated method stub
		return categorySecondDao.findByCsid(csid);
	}
	
	//删除二级分类
	@Override
	public void delete(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.delete(categorySecond);
	}

	@Override
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
		
	}

	@Override
	public List<CategorySecond> findAll() {
		// TODO Auto-generated method stub
		return categorySecondDao.findAll();
	}
	
}
