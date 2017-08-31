package com.shop.product.adminaction;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.categorysecond.domain.CategorySecond;
import com.shop.categorysecond.service.CategorySecondService;
import com.shop.product.domain.Product;
import com.shop.product.service.ProductService;
import com.shop.utils.PageBean;

public class AdminProductAction extends ActionSupport implements ModelDriven<Product> {
	private Product product = new Product();
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}


	//带分页的查询所有
	public String findAllByPage(){
		PageBean<Product> pb = productService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pb);
		return "findAllByPage";
	}
	
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}


	//添加商品第一步
	public String addPage(){
		
		List<CategorySecond> list = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", list);
		return "addProduct";
	}
	
	//文件上传需要的参数
	private File upload;//于表单中的属性名一致
	private String uploadFileName;//接收文件上传的文件名
	private String uploadContextType;//文件上传的类型
	public void setUpload(File upload) {
		this.upload = upload;
	}


	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}


	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}


	//添加商品第二部
	public String save()throws Exception{
		if(upload!=null){
			//获得文件上传的磁盘的绝对路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/products/1/");
		
			//创建一个文件
			File diskFile = new File(realPath + "//" + uploadFileName);
			//文件上传
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/1/" + uploadFileName);
		}
		product.setPdate(new Date());
		productService.save(product);
		
		return "saveSuccess";
	}
	
	//删除商品
	public String delete(){
		product = productService.findByPid(product.getPid());
		productService.delete(product);
		//删除上传的图片
		String path = product.getImage();
		if(path!=null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/"+path);
		
			File file = new File(realPath);
			file.delete();
		}
		return "deleteSuccess";
	}
	
	//编辑商品第一步
	public String edit(){
		
		product = productService.findByPid(product.getPid());
		List<CategorySecond> list = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", list);
		return "editSuccess";
		
	}
	
	//编辑商品第二部
	public String update()throws Exception{
		product.setPdate(new Date());
		if(upload!=null){
			String old = product.getImage();	
			String oldPath = ServletActionContext.getServletContext().getRealPath("/" + old);
			File of = new File(oldPath); 
			of.delete();
			String realPath = ServletActionContext.getServletContext().getRealPath("/products/1/");
			File file = new File(realPath + "//" + uploadFileName);
			FileUtils.copyFile(upload, file);
			product.setImage("products/1/" + uploadFileName);
		}
		productService.update(product);
		return "updateSuccess";
	}
}
