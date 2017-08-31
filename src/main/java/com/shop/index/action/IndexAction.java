package com.shop.index.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.category.domain.Category;
import com.shop.category.service.CategoryService;
import com.shop.product.domain.Product;
import com.shop.product.service.ProductService;

/**
 * 首页访问的action
 * @author think
 *
 */
public class IndexAction extends ActionSupport {
	
	//注入一级分类的service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//诸如商品的service
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	/*
	 * 执行访问首页
	 */
	public String execute(){
		List<Category> clist = categoryService.findAll();
		//因为每个页面都有 就存在session中 就不用每次都查询了
		ActionContext.getContext().getSession().put("clist", clist);
		
		//查询热门商品 is_hot 0不是 1是
		//只显示10个
		List<Product> plist = productService.findHot();
		ActionContext.getContext().getValueStack().set("plist", plist);
		
		//查询最新商品
		List<Product> newpList = productService.findNew();
		ActionContext.getContext().getValueStack().set("newpList", newpList);
		return "index";
	}
	
	
}
