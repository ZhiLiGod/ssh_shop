package com.shop.product.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.shop.product.dao.ProductDao;
import com.shop.product.domain.Product;
import com.shop.utils.PageBean;
import com.shop.utils.PageHibernateCallback;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

	@Override
	public List<Product> findHot() {
		
		//使用离线查询热门商品
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//查询热门商品 is_hot == 1
		criteria.add(Restrictions.eq("is_hot", 1));
		//倒叙排序进行输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> products = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		
		return products;
	}

	@Override
	public List<Product> findNew() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//按日期倒序排列
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> products = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		
		return products;
	}

	@Override
	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
		
	}
	
	//根据分类id查询商品个数
	@Override
	public int findCountCid(Integer cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, cid);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	//根据分类的id查询商品的集合
	@Override
	public List<Product> findByCidPage(Integer cid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid=?";
		//分页就不能用离线了
		//分页的另一种写法
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,
				new Object[] {cid}, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}		
		return null;
	}
	
	//二积分类查询商品个数
	@Override
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid=?";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, csid);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Product> findByCsidPage(Integer csid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid=?";
		//分页就不能用离线了
		//分页的另一种写法
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,
				new Object[] {csid}, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}		
		return null;
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from Product";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		
		return 0;
	}

	@Override
	public List<Product> findByPage(int begin, int limit) {
		String hql = "from Product order by pdate desc";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, null, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}

	@Override
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
		
	}

	@Override
	public void update(Product product) {
		this.getHibernateTemplate().update(product);
		
	}
	
	
}
