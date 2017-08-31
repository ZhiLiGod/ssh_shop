package com.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.user.domain.User;
import com.shop.user.service.UserService;
import com.shop.user.service.impl.UserServiceImpl;

/**
 * 用户模块
 * @author think
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	//模型驱动
	private User user = new User();

	public User getModel() {
		return user;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//接收验证码
	private String verifyCode;
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
	//接受repassword
	private String repassword;
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	/*
	 * 跳转到注册页面
	 */
	public String registPage(){		
		return "registPage";
	}
	
	/*
	 * 跳转到登陆
	 */
	public String loginPage(){
		return "loginPage";
	}
	
	/*
	 * AJAX进行异步校验用户名的方法
	 */
	public String findByName() throws IOException{
		//调用service进行查询
		User existUser = userService.findByName(user.getUsername());
		//获得response对象想页面输出
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		
		//判断
		if(existUser!=null){
			response.getWriter().println("<font color='red'>Username has already existed</font>");
		}else{
			response.getWriter().println("<font color='green'>Username correct</font>");
		}
		
		return NONE;
	
	}
	
	
	//用户注册
	public String regist(){
		//判断验证码
		String verifyCodeFromSession = ServletActionContext.getRequest().getSession().getAttribute("verifyCode").toString();
		if(!verifyCodeFromSession.equalsIgnoreCase(verifyCode)){
			this.addActionError("Incorrect verify code");
			return "verifyCodeFail";
		}		
		//xml进行校验
		userService.save(user);
		this.addActionMessage("Register successful, activite mail");
		return "msg";
	}

	//用户激活
	public String active(){
		String code = user.getCode();
		//根据激活码查询用户
		User user = userService.findByCode(code);
		
		if(user == null){
			this.addActionMessage("Active failed");
		}else{
			//激活成功
			//修改用户状态
			user.setState(1);
			user.setCode(null);
			userService.update(user);
			this.addActionMessage("Active successful");
		}
		
		return "msg";
	}
	
	
	//用户登录
	public String login(){
		User existUser = userService.login(user);
		if(existUser==null){
			//登陆失败
			this.addActionError("Username or password incorrect");
			return LOGIN;
		}else{
			//存用户信息进session
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginSuccess";
		}
		
	}
	
	//用户退出
	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
}
