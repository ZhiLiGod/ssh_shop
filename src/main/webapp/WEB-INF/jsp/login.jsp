<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0080)http://localhost:8080/mango/login.jhtml?redirectUrl=%2Fmango%2Fcart%2Flist.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Login</title>

<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css"/>
<script>
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
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.jpg" alt="OnlineShop" />
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/title.jpg" width="320" height="50" alt="Real" title="Real" />
</div>	</div>
	<%@ include file="menu.jsp" %>	
</div>	<div class="container login">
		<div class="span12">
<div class="ad">
					<img src="${pageContext.request.contextPath}/image/Online-Shop.jpg" width="500" height="330" alt="Login" title="Login" />
</div>		</div>
		<div class="span12 last">
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>Login</strong>USER LOGIN 
					</div>
					<div>
						<strong><s:actionerror/></strong> 
					</div>
					<form id="loginForm" action="${pageContext.request.contextPath}/user_login.action"  method="post" novalidate="novalidate">
						<table>
							<tbody><tr>
								<th>
										Username:
								</th>
								<td>
									<input type="text" id="username" name="username" class="text" maxlength="20" />
									
								</td>
							</tr>
							<tr>
								<th>
									Password:
								</th>
								<td>
									<input type="password" id="password" name="password" class="text" maxlength="20" autocomplete="off" />
								</td>
							</tr>
								<tr>
									<th>
										Verify Code:
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
									<label>
										<input type="checkbox" id="isRememberUsername" name="isRememberUsername" value="true" />Remember
									</label>
									<label>
										&nbsp;&nbsp;<a >Forget Password</a>
									</label>
								</td>
							</tr>
							<tr>
								<th>&nbsp;
									
								</th>
								<td>
									<input type="submit" class="submit" value="Sign In" />
								</td>
							</tr>
							<tr class="register">
								<th>&nbsp;
									
								</th>
								<td>
									<dl>
										<dt>Don't have an account?</dt>
										<dd>
											Register Now!
											<a href="${pageContext.request.contextPath}/user_registPage.action">Register</a>
										</dd>
									</dl>
								</td>
							</tr>
						</tbody></table>
					</form>
				</div>
			</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
	  <div class="footerAd"><img src="${pageContext.request.contextPath}/image/footer1.jpg" width="950" height="52" alt="Good" title="Good" /></div>	
	</div>
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
</body></html>