package com.shop.category.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.category.domain.Category;
import com.shop.category.service.CategoryService;

public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category> {
	private Category category = new Category();
	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return category;
	}
	
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}



	//后台执行查询所有一级分类
	public String findAll(){
		List<Category> list = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("clist", list);
		return "findAll";
	}
	
	//添加新的一级分类
	public String save(){
		categoryService.save(category);
		
		return "saveSuccess";
	}
	
	//删除一级分类
	public String delete(){
		//删除一级分类也同时删除下面的二级分类 必须先查再删除 不能直接根据id删除
		Category c = categoryService.findByCid(category.getCid());
		categoryService.delete(c);
		return "deleteSuccess";
	}
	
	//编辑一级分类
	public String edit(){
		category = categoryService.findByCid(category.getCid());
		//ActionContext.getContext().getValueStack().set("c", c);
		return "edit";
	}
	
	//编辑
	public String update(){
		categoryService.update(category);
		return "update";
	}
}
