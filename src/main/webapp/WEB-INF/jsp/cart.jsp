<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>My Cart</title>

<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css" />


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
			<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/title.jpg" width="320" height="50" alt="Good" title="Good" />
</div>	</div>
	<%@ include file="menu.jsp" %>
</div>	<div class="container cart">
	<s:if test="#session.cart.cartItems.size() != 0">
		<div class="span24">		
			<div class="step step1"></div>
				<table>
					<tbody>
					<tr>
						<th>Image</th>
						<th>Product</th>
						<th>Price</th>
						<th>Count</th>
						<th>Subtotal</th>
						<th>Operation</th>
					</tr>
					<s:iterator value="#session.cart.cartItems" var="cartItem">
					<tr>
						<td width="60">
							<input type="hidden" name="id" value="22" />
							<img src="${pageContext.request.contextPath}/<s:property value="#cartItem.product.image" />" />
						</td>
						<td>
							<a target="_blank"><s:property value="#cartItem.product.pname" /></a>
						</td>
						<td>
							€<s:property value="#cartItem.product.shop_price" />
						</td>
						<td class="quantity" width="60">
							<s:property value="#cartItem.count" />
						</td>
						<td width="140">
							<span class="subtotal">€<s:property value="#cartItem.subtotal" /></span>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/cart_deleteItem.action?pid=<s:property value="#cartItem.product.pid" />" class="delete">Delete</a>
						</td>
					</tr>
					</s:iterator>
				</tbody>
				</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total">
					<em id="promotion"></em>
							<em>
								Any Discount
							</em>
					Credit: <em id="effectivePoint"><s:property value="#session.cart.total" /> Points</em>
					Total: <strong id="effectivePrice">€<s:property value="#session.cart.total" /></strong>
				</div>
				<div class="bottom">
					<a href="${pageContext.request.contextPath}/cart_clearCart.action" id="clear" class="clear">Clear Cart</a>
					<a href="${pageContext.request.contextPath}/order_save.action" id="submit" class="submit">Submit</a>
				</div>
			
		</div>
		</s:if>
		<s:else>
			<div class="span24">		
			<div class="step step1">
				<span><h2>No Items</h2></span>
			</div>
			</div>
		</s:else>
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
</body></html>