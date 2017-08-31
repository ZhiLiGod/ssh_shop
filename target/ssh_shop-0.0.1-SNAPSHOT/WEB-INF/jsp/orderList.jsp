<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<title>My Orders</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>

</head>
<body>

<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.jpg" alt="OnlineShop"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
	<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/title.jpg" width="320" height="50" alt="Real" title="Real"/>
</div>	
</div>
	<%@ include file="menu.jsp" %>
</div>	
<div class="container cart">

		<div class="span24">
		
			<div class="step step1">
				<ul>
					
					<li  class="current"></li>
					<li>My Orders</li>
				</ul>
			</div>
				<table>
					<tbody>
					<s:iterator value="pb.list" var="order">
						<tr>
							<th colspan="5">Number:<s:property value="#order.oid" />&nbsp;&nbsp;&nbsp;&nbsp;Total:<font
								color="red"><s:property value="#order.total" />
							</font>
							&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">
								<s:if test="#order.state == 1">
									<a href="${ pageContext.request.contextPath }/order_findByOid.action?oid=<s:property value="#order.oid" />">Unpaid</a>
								</s:if>
								<s:if test="#order.state == 2">
									Paid
								</s:if>
								<s:if test="#order.state == 3">
									<a href="${ pageContext.request.contextPath }/order_updateState.action?oid=<s:property value="#order.oid" />">Confirm Received</a>
								</s:if>
								<s:if test="#order.state == 4">
									Successful
								</s:if>
							</font>
							</th>
						</tr>
						
						<tr>
							<th>Image</th>
							<th>Product</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Subtotal</th>
						</tr>
						<s:iterator value="#order.orderItems" var="orderitem">
						<tr>
							<td width="60">
								<input type="hidden" name="id" value="22"/>
								<img src="${pageContext.request.contextPath}/<s:property value="#orderitem.product.image" />"/>
							</td>
							<td>
								<a target="_blank"><s:property value="#orderitem.product.pname"/></a>
							</td>
							<td>
								€<s:property value="#orderitem.product.shop_price"/>
							</td>
							<td class="quantity" width="60">
								<s:property value="#orderitem.count"/>
							</td>
							<td width="140">
								<span class="subtotal">€<s:property value="#orderitem.subtotal"/></span>
							</td>
						</tr>
						</s:iterator>
						</s:iterator>
						<tr>
						<th colspan="5">
						<div class="pagination">
							<span>Page <s:property value="pb.page" /> / <s:property value="pb.totalPage" /></span>
								<s:if test="pb.page != 1">
									<a class="firstPage" href="${pageContext.request.contextPath}/order_findByUid.action?page=1">&nbsp;</a>
									<a class="previousPage" href="${pageContext.request.contextPath}/order_findByUid.action?page=<s:property value="pb.page-1" /> ">&nbsp;</a>
								</s:if>	
								<s:iterator begin="1" end="pb.totalPage" var="i">
									<s:if test="pb.page != #i">	
										<a href="${pageContext.request.contextPath}/order_findByUid.action?page=<s:property value="#i" /> "><s:property value="#i" /></a>
									</s:if>
									<s:else>
										<span class="currentPage"><s:property value="#i" /></span>
									</s:else>
								</s:iterator>	
								<s:if test="pb.page != pb.totalPage">
									<a class="nextPage" href="${pageContext.request.contextPath}/order_findByUid.action?page=<s:property value="pb.page+1" /> ">&nbsp;</a>			
									<a class="lastPage" href="${pageContext.request.contextPath}/order_findByUid.action?page=<s:property value="pb.totalPage" /> ">&nbsp;</a>
								</s:if>
						</div>
						</th>
						</tr>
				</tbody>
			</table>
	</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="image/footer1.jpg" alt="Good" title="Good" height="52" width="950" />
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
		<div class="copyright">Copyright © 2017 Online Shop</div>
	</div>
</div>
</body>
</html>