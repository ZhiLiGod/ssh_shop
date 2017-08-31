package com.shop.cart.domain;

import com.shop.product.domain.Product;

/**
 * 购物项
 * @author think
 *
 */
public class CartItem {
	private Product product;
	private Integer count;//数量
	private double subtotal;//小记
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	//小计自动计算
	public double getSubtotal() {
		return count * product.getShop_price();
	}
	
	
}
