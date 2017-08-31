package com.shop.order.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.order.domain.Order;
import com.shop.order.domain.OrderItem;
import com.shop.order.service.OrderService;
import com.shop.utils.PageBean;

public class AdminOrderAction extends ActionSupport implements ModelDriven<Order> {
	private Order order = new Order();
	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	
	//带分页的查询执行的方法
	public String findAllByPage(){
		PageBean<Order> pb = orderService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pb);
		return "findAllByPage";
	}
	
	//根据订单id查询订单项
	public String findOrderItem(){
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		ActionContext.getContext().getValueStack().set("list", list);
		return "findOrderItem";
	}
	
	//修改订单状态
	public String updateState(){
		Order curr = orderService.findByOid(order.getOid());
		curr.setState(3);
		orderService.updateOrder(curr);
		return "updateState";
	}
	
	//按订单状态查找
	public String findByState(){
		
		PageBean<Order> pb = orderService.findByState(order.getState(), page);
		ActionContext.getContext().getValueStack().set("pageBean", pb);
		return "findByState";
	}
	
}
