package com.shop.order.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.shop.order.dao.OrderDao;
import com.shop.order.domain.Order;
import com.shop.order.domain.OrderItem;
import com.shop.utils.PageHibernateCallback;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {
	
	//保存订单的方法
	@Override
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}

	@Override
	public int findByCountUid(Integer uid) {
		String hql = "select count(*) from Order o where o.user.uid=?";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, uid);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Order> findByPageUid(Integer uid, int limit, int begin) {
		String hql = "from Order o where o.user.uid=? order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[]{uid}, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public Order findByOid(Integer oid) {	
		Order order = this.getHibernateTemplate().get(Order.class, oid);
		return order;
	}

	@Override
	public void updateOrder(Order currOrder) {
		this.getHibernateTemplate().update(currOrder);
		
	}

	@Override
	public int findByCount() {
		String hql = "select count(*) from Order";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		
		return 0;
	}

	@Override
	public List<Order> findByPage(int begin, int limit) {
		String hql = "from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, null, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public List<OrderItem> findOrderItem(Integer oid) {
		String hql = "from OrderItem oi where oi.order.oid=?";
		List<OrderItem> list = (List<OrderItem>) this.getHibernateTemplate().find(hql, oid);
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public int findCount(Integer state) {
		String hql = "select count(*) from Order where state=?";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, state);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Order> findByState(int begin, int limit, Integer state) {
		String hql = "from Order where state=? order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[] {state}, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

}
