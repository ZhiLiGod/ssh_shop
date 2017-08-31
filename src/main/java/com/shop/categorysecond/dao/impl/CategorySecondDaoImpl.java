package com.shop.categorysecond.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.shop.categorysecond.dao.CategorySecondDao;
import com.shop.categorysecond.domain.CategorySecond;
import com.shop.utils.PageHibernateCallback;

public class CategorySecondDaoImpl extends HibernateDaoSupport implements CategorySecondDao {
	
	//统计个数
	@Override
	public int findCount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	//分页查询二级分类的方法
	@Override
	public List<CategorySecond> findByPage(int begin, int limit) {
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(new PageHibernateCallback<CategorySecond>(hql, null, begin, limit));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
		
	}
	
	
	@Override
	public CategorySecond findByCsid(Integer csid) {
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
		
	}

	@Override
	public void delete(CategorySecond categorySecond) {
		this.getHibernateTemplate().delete(categorySecond);
		
	}

	@Override
	public void update(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);
		
	}

	@Override
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		return (List<CategorySecond>) this.getHibernateTemplate().find(hql);
	}
	
}
