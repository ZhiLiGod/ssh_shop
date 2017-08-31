package com.shop.categorysecond.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.category.domain.Category;
import com.shop.category.service.CategoryService;
import com.shop.categorysecond.domain.CategorySecond;
import com.shop.categorysecond.service.CategorySecondService;
import com.shop.utils.PageBean;

public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	private CategorySecond categorySecond = new CategorySecond();
	@Override
	public CategorySecond getModel() {
		// TODO Auto-generated method stub
		return categorySecond;
	}
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}


	//查询二级分类
	public String findAllByPage(){
		PageBean<CategorySecond> pb = categorySecondService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pb", pb);
		return "findByPage";
	}
	private CategoryService categoryService;	
	//要查询所有的一级分类并且跳转
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	//跳转去添加页面
	public String addPage(){
		
		List<Category> clist = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "add";
	}
	
	//保存添加的二级分类
	public String save(){
		
		categorySecondService.save(categorySecond);
		
		return "saveSuccess";
	}
	
	//删除二级分类
	public String delete(){
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	
	//编辑二级分类第一步
	public String edit(){
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "edit";
	}
	
	//编辑完成
	public String update(){
		categorySecondService.update(categorySecond);
		return "update";
	}

}
