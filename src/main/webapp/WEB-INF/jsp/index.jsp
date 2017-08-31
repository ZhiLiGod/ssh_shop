<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Shop</title>
<link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>

</head>
<body>

<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="${pageContext.request.contextPath}/index.action">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.jpg" alt="onlineshop"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
	<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/title.jpg" width="320" height="50" alt="Genuine" title="Genuine"/>
</div>	
</div>
	
	<%@ include file="menu.jsp" %>


</div>	

<div class="container index">
		

		<div class="span24">
			<div id="hotProduct" class="hotProduct clearfix">
					<div class="title">
						<strong>Popular Products</strong>
						<!-- <a  target="_blank"></a> -->
					</div>
					<ul class="tab">
							<li class="current">
								<a href="" target="_blank"></a>
							</li>
							<li>
								<a  target="_blank"></a>
							</li>
							<li>
								<a target="_blank"></a>
							</li>
					</ul>
<!-- 					<div class="hotProductAd">
			<img src="${pageContext.request.contextPath}/image/a.jpg" width="260" height="343" alt="热门商品" title="热门商品">
</div> -->
						<ul class="tabContent" style="display: block;">
							<s:iterator var="p" value="plist">
								<li>
									<a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid" />" target="_blank"><img src="${pageContext.request.contextPath}/<s:property value="#p.image" />" data-original="http://storage.shopxx.net/demo-image/3.0/201301/0ff130db-0a1b-4b8d-a918-ed9016317009-thumbnail.jpg" style="display: block;" /></a>
								</li>	
							</s:iterator>							
						</ul>
			</div>
		</div>
		<div class="span24">
			<div id="newProduct" class="newProduct clearfix">
					<div class="title">
						<strong>New Coming</strong>
						<a  target="_blank"></a>
					</div>
					<ul class="tab">
							<li class="current">
								<a href="" target="_blank"></a>
							</li>
							<li>
								<a  target="_blank"></a>
							</li>
							<li>
								<a target="_blank"></a>
							</li>
					</ul>
<!-- 					<div class="newProductAd">
									<img src="${pageContext.request.contextPath}/image/q.jpg" width="260" height="343" alt="最新商品" title="最新商品">
						</div>
						 -->						
						 <ul class="tabContent" style="display: block;">
						 	<s:iterator var="n" value="newpList">
							<li>
								<a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#n.pid" />" target="_blank"><img src="${pageContext.request.contextPath}/<s:property value="#n.image" />" data-original="http://storage.shopxx.net/demo-image/3.0/201301/4a51167a-89d5-4710-aca2-7c76edc355b8-thumbnail.jpg" style="display: block;" /></a>									
							</li>
							</s:iterator>			
						</ul>
			</div>
		</div>
		<div class="span24">
			<div class="friendLink">
				<!-- <dl>
					<dt>新手指南</dt>
							<dd>
								<a  target="_blank">支付方式</a>
								|
							</dd>
							<dd>
								<a  target="_blank">配送方式</a>
								|
							</dd>
							<dd>
								<a  target="_blank">售后服务</a>
								|
							</dd>
							<dd>
								<a  target="_blank">购物帮助</a>
								|
							</dd>
							<dd>
								<a  target="_blank">蔬菜卡</a>
								|
							</dd>
							<dd>
								<a  target="_blank">礼品卡</a>
								|
							</dd>
							<dd>
								<a target="_blank">银联卡</a>
								|
							</dd>
							<dd>
								<a  target="_blank">亿家卡</a>
								|
							</dd>
							
					<dd class="more">
						<a >更多</a>
					</dd>
				</dl> -->
			</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/image/footer1.jpg" width="950" height="52" alt="" title="" />
		</div>	
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
		<div class="copyright">Copyright © 2017 OnlineShop</div>
	</div>
</div>
</body>
</html>