package com.shop.cart.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车
 * @author think
 * 要存在session中
 */
public class Cart implements Serializable {
	//key就是商品id value就是购物项 linkedhashmap就有续了
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
	
	//转成单列的结合	****重点 
	public Collection<CartItem> getCartItems(){	
		return map.values();
	}
	
	private double total;//总计
	public double getTotal() {
		return total;
	}	
	public void setTotal(Double total) {
		this.total = total;
	}

	//购物车的功能
	//将购物项添加到购物车
	public void addCart(CartItem cartItem){
		//判断购物车中是否存在购物项
		//存在：数量增加 总计增加
		//不存在：添加购物项 总计变化
		Integer pid = cartItem.getProduct().getPid();
		//判断购物车中是否存在该购物项
		if(map.containsKey(pid)){
			//存在
			CartItem _cartItem = map.get(pid);//获得原来的购物项
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
		}else{
			map.put(pid, cartItem);
		}
		
		//设置总计
		total += cartItem.getSubtotal();
	
	}
	//从购物车中移除购物箱
	public void removeCart(Integer pid){
		//将某个购物箱移除购物车
		//总计-移除的购物箱的小计
		CartItem cartItem = map.remove(pid);
		total -= cartItem.getSubtotal();
	}
	//清空购物车
	public void clearCart(){
		//将所有的购物项清空
		map.clear();
		total = 0.0;
	}
}
