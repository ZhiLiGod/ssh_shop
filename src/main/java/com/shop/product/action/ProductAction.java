package com.shop.product.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.category.domain.Category;
import com.shop.category.service.CategoryService;
import com.shop.product.domain.Product;
import com.shop.product.service.ProductService;
import com.shop.utils.PageBean;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	private Product product = new Product();
	
	@Override
	public Product getModel() {
		
		return product;
	}
	
	private Integer cid;
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	//可以直接用 取到cid
	public Integer getCid() {
		return cid;
	}
	//一级分类的service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//接收当前的页数
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	
	private Integer csid;	
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public Integer getCsid() {
		return csid;
	}
	//根据商品id查询商品
	public String findByPid(){
		Integer pid = product.getPid();
		product = productService.findByPid(pid);	
		return "findByPid";
	}
	
	
	//根据分类的cid跳转到页面
	public String findByCid(){
		//不能用模型驱动，无法直接接收cid
		//直接定义一个cid接受
		//查找所有的一级分类 可以调用已经存在冯方法
		//List<Category> categoryList = categoryService.findAll();		
		//ActionContext.getContext().getValueStack().set("clist", categoryList);
		
		//根据一级分类查询商品，带分页
		PageBean<Product> pageBean = productService.findByPageCid(cid, page);
		ActionContext.getContext().getValueStack().set("pb", pageBean);
		return "findByCid";
	}
	
	//根据二级分类id查询商品
	public String findByCsid(){
		PageBean<Product> pageBean = productService.findByPageCsid(csid, page);
		ActionContext.getContext().getValueStack().set("pb", pageBean);
		return "findByCsid";
	}
	
}
