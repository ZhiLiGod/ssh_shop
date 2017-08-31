package com.shop.order.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shop.order.dao.OrderDao;
import com.shop.order.domain.Order;
import com.shop.order.domain.OrderItem;
import com.shop.order.service.OrderService;
import com.shop.utils.PageBean;
@Transactional
public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	//保存订单
	@Override
	public void save(Order order) {
		orderDao.save(order);
		
	}
	
	//我的订单的业务层代码
	@Override
	public PageBean<Order> findByPageUid(Integer uid, Integer page) {
		PageBean<Order> pb = new PageBean<Order>();
		pb.setPage(page);
		int limit = 5;
		pb.setLimit(limit);
		int totalCount = 0;
		totalCount = orderDao.findByCountUid(uid);
		pb.setTotalCount(totalCount);
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount/limit;
		}else{
			totalPage = totalCount/limit + 1;
		}
		pb.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		List<Order> list = orderDao.findByPageUid(uid, limit, begin );
		pb.setList(list);
		
		return pb;
	}

	@Override
	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
		
	}

	@Override
	public void updateOrder(Order currOrder) {
		orderDao.updateOrder(currOrder);
		
	}

	@Override
	public PageBean<Order> findByPage(Integer page) {
		PageBean<Order> pb = new PageBean<Order>();
		pb.setPage(page);
		int limit = 10;
		pb.setLimit(limit);
		int totalCount = 0;
		int totalPage = 0;
		totalCount = orderDao.findByCount();
		pb.setTotalCount(totalCount);
		if(totalCount % limit == 0){
			totalPage = totalCount/limit;
		}else{
			totalPage = totalCount/limit + 1;
		}
		pb.setTotalPage(totalPage);
		int begin = (page-1)*limit;
		List<Order> list = orderDao.findByPage(begin, limit);
		pb.setList(list);
		return pb;
	}

	@Override
	public List<OrderItem> findOrderItem(Integer oid) {
		// TODO Auto-generated method stub
		return orderDao.findOrderItem(oid);
	}

	@Override
	public PageBean<Order> findByState(Integer state, Integer page) {
		PageBean<Order> pb = new PageBean<Order>();
		int limit = 10;
		int totalCount = 0;
		int totalPage = 0;
		pb.setPage(page);
		pb.setLimit(limit);
		totalCount = orderDao.findCount(state);
		pb.setTotalCount(totalCount);
		if(totalCount % limit == 0){
			totalPage = totalCount/limit;
		}else{
			totalPage = totalCount/limit + 1;
		}
		int begin = (page-1)*limit;
		pb.setTotalPage(totalPage);
		List<Order> list = orderDao.findByState(begin, limit, state);
		pb.setList(list);
		return pb;
	}

	
	
}
