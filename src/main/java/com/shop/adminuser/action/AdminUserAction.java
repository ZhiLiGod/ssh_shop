package com.shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.adminuser.domain.AdminUser;
import com.shop.adminuser.service.AdminUserService;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {
	private AdminUser adminUser = new AdminUser();
	
	@Override
	public AdminUser getModel() {
		return adminUser;
	}
	
	private AdminUserService adminUserService;

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	//登陆
	public String login(){
		//调用service完成登陆
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if(existAdminUser == null){
			//失败
			this.addActionError("Username or password wrong");
			return "loginFail";
		}else{
			//成功
			ServletActionContext.getRequest().getSession().setAttribute("eu", existAdminUser);
			return "loginSuccess";
		}
		
	}
	
	//登出
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}
	

}
