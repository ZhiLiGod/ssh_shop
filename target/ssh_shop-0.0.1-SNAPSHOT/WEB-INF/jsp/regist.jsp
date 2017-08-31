<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Register</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet" type="text/css"/>
<script>
	function checkForm(){
		//校验用户名
		var username = document.getElementById("username").value;
		if(username == null || username == ''){
			document.getElementById("nameSpan").innerHTML="&nbsp<font color='red' size='2'><b>Name is empty</b></font>";
			return false;
		}	
		var password = document.getElementById("password").value;
		if(password == null || password == ''){
			document.getElementById("pwdSpan").innerHTML="&nbsp<font color='red' size='2'><b>Password is empty</b></font>";
			return false;
		}
		var repassword = document.getElementById("repassword").value;
		if(repassword != password){
			document.getElementById("repwdSpan").innerHTML="&nbsp<font color='red' size='2'><b>Password is different</b></font>";
			return false;
		}
		
		var email = document.getElementById("email").value;
		if(email == null || email == ''){
			document.getElementById("emailSpan").innerHTML="&nbsp<font color='red' size='2'><b>Email is empty</b></font>";
			return false;
		}
		var reg= /^\w+@\w+\.(com|cn|gov)$/;
		if(reg.test(email) == false){
			document.getElementById("emailSpan").innerHTML="&nbsp<font color='red' size='2'><b>Worng email</b></font>";
			return false;
		}
	}
	
	function checkUsername(){
		// 获得文件框值:
		var username = document.getElementById("username").value;
		// 1.创建异步交互对象
		var xhr = createXmlHttp();
		// 2.设置监听
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					document.getElementById("span1").innerHTML = xhr.responseText;
				}
			}
		};
		// 3.打开连接 time="+new Date().getTime()+"&
		xhr.open("GET","${pageContext.request.contextPath}/user_findByName.action?time="+new Date().getTime()+"&username="+username,true);
		// 4.发送
		xhr.send(null);
	}
	
	function createXmlHttp(){
		   var xmlHttp;
		   try{ // Firefox, Opera 8.0+, Safari
		        xmlHttp=new XMLHttpRequest();
		    }
		    catch (e){
			   try{// Internet Explorer
			         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			      }
			    catch (e){
			      try{
			         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			      }
			      catch (e){}
			      }
		    }

			return xmlHttp;
	}
	
	function change(){
		
		var img1 = document.getElementById("verifyCodeImg");
		//alert(img.src);
		img1.src = "${pageContext.request.contextPath}/verifyCode.action?"+new Date().getTime();
		//alert(img.src);
	}
	
</script>
</head>
<body>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="http://localhost:8080/mango/">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.jpg" alt="Online Shop" />
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/title.jpg" width="320" height="50" alt="Real" title="Real" />
</div>	</div>
	<%@ include file="menu.jsp" %>
</div>	<div class="container register">
		<div class="span24">
			<div class="wrap">
				<div class="main clearfix">
					<div class="title">
						<strong>Register</strong>USER REGISTER
					</div>
					<div>
						<s:actionerror />
					</div>
					<form id="registerForm"  method="post" action="${pageContext.request.contextPath}/user_regist.action" novalidate="novalidate" onsubmit="return checkForm();">
						<table>
							<tbody><tr>
								<th>
									<span class="requiredField">*</span>Username:
								</th>
								<td>
									<input type="text" id="username" name="username" class="text" maxlength="20" onblur="checkUsername()" /><span id="nameSpan"></span>
									<span id="span1"></span>
									<span><s:fielderror fieldName="username" /></span>
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>Password:
								</th>
								<td>
									<input type="password" id="password" name="password" class="text" maxlength="20" autocomplete="off" /><span id="pwdSpan"></span>
									<span><s:fielderror fieldName="password" /></span>
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>Confirm Password:
								</th>
								<td>
									<input type="password" id="repassword" name="repassword" class="text" maxlength="20" autocomplete="off" /><span id="repwdSpan"></span>
									
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>E-mail:
								</th>
								<td>
									<input type="text" id="email" name="email" class="text" maxlength="200" /><span id="emailSpan"></span>
									<span><s:fielderror fieldName="email" /></span>
								</td>
							</tr>
									<tr>
										<th>
											Full Name:
										</th>
										<td>
												<input type="text" name="name" class="text" maxlength="200" />
												<span><s:fielderror fieldName="name" /></span>
										</td>
									</tr>
					
									<tr>
										<th>
											Telephone:
										</th>
										<td>
												<input type="text" name="phone" class="text" onfocus="WdatePicker();" />
										</td>
									</tr>
									
									<tr>
										<th>
											Address:
										</th>
										<td>
												<input type="text" name="addr" class="text" maxlength="200" />
												<span><s:fielderror fieldName="addr" /></span>
										</td>
									</tr>
								<tr>
									<th>
										<span class="requiredField">*</span>Verify Code:
									</th>
									<td>
										<span class="fieldSet">
											<input type="text" 
											id="verifyCode" name="verifyCode" 
											class="text captcha" maxlength="4" 
											autocomplete="off" />
											<img id="verifyCodeImg" class="captchaImage" 
											src="${pageContext.request.contextPath}/verifyCode.action" 
											onclick="change()"
											title="Change Vcode" />
										</span>
									</td>
								</tr>
							<tr>
								<th>&nbsp;
									
								</th>
								<td>
									<input type="submit" class="submit" value="Agree and Regist" />
								</td>
							</tr>
							<tr>
								<th>&nbsp;
									
								</th>
								<td>
									Register Protocol
								</td>
							</tr>
							<tr>
								<th>&nbsp;
									
								</th>
								<td>
									<div id="agreement" class="agreement" style="height: 200px;">
										<p>.......................................</p>
									</div>
								</td>
							</tr>
						</tbody></table>
						<div class="login">
<div class="ad">
					<dl>
	<dt>
		Good Value
	</dt>
	<dd>
		Big Brand
	</dd>
	<dd>
		Fast Delivery
	</dd>
	<dd>
		Free Refund
	</dd>
</dl>
</div>							<dl>
								<dt>Already have an account？</dt>
								<dd>
									Sign in now!
									<a href="${pageContext.request.contextPath}/user_loginPage.action">Sign in</a>
								</dd>
							</dl>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/image/footer1.jpg" width="950" height="52" alt="Good" title="Good" />
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a>Get to Know Us</a>
						|
					</li>
					<li>
						<a>Contact us</a>
						|
					</li>
					<li>
						<a>Customer service</a>
						|
					</li>
					<li>
						<a>Help</a>
						|
					</li>
					<li>
						<a>Track</a>
						|
					</li>
					<li>
						<a>Payment Methods</a>
						|
					</li>
					<li>
						<a>Delivery Methods</a>
						|
					</li>
					<li>
						<a>Advertisement</a>			
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2017 Online Shop</div>
	</div>
</div>
<div id="_my97DP" style="position: absolute; top: -1970px; left: -1970px;"><iframe style="width: 190px; height: 191px;" src="./会员注册 - Powered By Mango Team_files/My97DatePicker.htm" frameborder="0" border="0" scrolling="no"></iframe></div></body></html>