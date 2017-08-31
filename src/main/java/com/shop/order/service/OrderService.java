package com.shop.order.service;

import java.util.List;

import com.shop.order.domain.Order;
import com.shop.order.domain.OrderItem;
import com.shop.utils.PageBean;

public interface OrderService {

	public void save(Order order);

	public PageBean<Order> findByPageUid(Integer uid, Integer page);

	public Order findByOid(Integer oid);

	public void updateOrder(Order currOrder);

	public PageBean<Order> findByPage(Integer page);

	public List<OrderItem> findOrderItem(Integer oid);

	public PageBean<Order> findByState(Integer state, Integer page);

	

}
