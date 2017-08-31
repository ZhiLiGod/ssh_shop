package com.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.cart.domain.Cart;
import com.shop.cart.domain.CartItem;
import com.shop.product.domain.Product;
import com.shop.product.service.ProductService;

public class CartAction extends ActionSupport {
	
	private Integer pid;
	private Integer count;
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//将购物项添加到购物车
	public String addCart(){
		//封装cartItem对象
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		
		//根据pid查询商品
		Product product = productService.findByPid(pid);
		cartItem.setProduct(product);
		
		//将购物项添加到购物车
		//购物车存在session中
		Cart cart = getCart();
		cart.addCart(cartItem);
		return "addCart";
	}
	
	//获得购物车 从session中 获得购物车
	private Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart == null){
			cart = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}
	
	//清空购物车
	public String clearCart(){
		Cart cart = getCart();
		cart.clearCart();
		return "clearCart";
	}
	
	//移除购物箱
	public String deleteItem(){
		Cart cart = getCart();
		cart.removeCart(pid);
		return "deleteItem";
	}
	
	//获得购物车
	public String myCart(){
		
		return "myCart";
	}
}
