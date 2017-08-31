package com.shop.order.dao;

import java.util.List;

import com.shop.order.domain.Order;
import com.shop.order.domain.OrderItem;

public interface OrderDao {

	public void save(Order order);

	public int findByCountUid(Integer uid);

	public List<Order> findByPageUid(Integer uid, int limit, int begin);

	public Order findByOid(Integer oid);

	public void updateOrder(Order currOrder);

	public int findByCount();

	public List<Order> findByPage(int begin, int limit);

	public List<OrderItem> findOrderItem(Integer oid);

	public int findCount(Integer state);

	public List<Order> findByState(int begin, int limit, Integer state);

}
