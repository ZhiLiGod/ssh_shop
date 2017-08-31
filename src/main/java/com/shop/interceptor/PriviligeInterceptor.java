package com.shop.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.shop.adminuser.domain.AdminUser;

/**
 * 后台权限校验的拦截器
 * 对没有登陆的用户是不可以进行访问的
 * @author think
 *
 */
public class PriviligeInterceptor extends MethodFilterInterceptor {
	
	//执行拦截的方法
	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		//判断session中是否保存了后台用户的信息
		AdminUser admin = (AdminUser) ServletActionContext.getRequest().getSession().getAttribute("eu");
		if(admin == null){
			//没登陆
			ActionSupport as = (ActionSupport) actionInvocation.getAction();
			as.addActionError("Please login first");
			return "loginFail";
		}else{
			//放行
			return actionInvocation.invoke();
		}
		
	}

}
