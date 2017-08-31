<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<title>Order</title>
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
					<li>Order Successful</li>
				</ul>
			</div>
	
		
				<table>
					<tbody>
					<tr>
						<th colspan="5">ID: <s:property value="model.oid" /></th>
					</tr>
					<tr>
						<th>Image</th>
						<th>Product</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Subtotal</th>
					</tr>
						<s:iterator value="model.orderItems" var="orderitem">
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
				</tbody>
			</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total">
					<em id="promotion"></em>
					Total: <strong id="effectivePrice">€<s:property value="model.total"/></strong>
				</div>
			<form id="orderForm" action="${pageContext.request.contextPath}/order_payOrder.action" method="post">
				<input type="hidden" name="oid" value="<s:property value="model.oid" />"/>
				<div class="span24">
					<p>
							Address：<input name="order.user.addr" type="text" value="<s:property value="model.user.addr"/>" style="width:350px" />
								<br />
							Name&nbsp;&nbsp;&nbsp;：<input name="order.user.username" type="text" value="<s:property value="model.user.name"/>" style="width:150px" />
								<br /> 
							Telephone：<input name="order.user.phone" type="text"value="<s:property value="model.user.phone"/>" style="width:150px" />

						</p>
						<hr />
						<p>
							Choose a Online Bank：<br/>
							<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>AIB
							<img src="${pageContext.request.contextPath}/bank_img/aib.png" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>Bank of Ireland
							<img src="${pageContext.request.contextPath}/bank_img/boi.jpg" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<!-- <input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
							<img src="${pageContext.request.contextPath}/bank_img/abc.bmp" align="middle"/>
							<br/>
							<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
							<img src="${pageContext.request.contextPath}/bank_img/bcc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="PINGANBANK-NET"/>平安银行
							<img src="${pageContext.request.contextPath}/bank_img/pingan.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
							<img src="${pageContext.request.contextPath}/bank_img/ccb.bmp" align="middle"/>
							<br/>
							<input type="radio" name="pd_FrpId" value="CEB-NET-B2C"/>光大银行
							<img src="${pageContext.request.contextPath}/bank_img/guangda.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>招商银行
							<img src="${pageContext.request.contextPath}/bank_img/cmb.bmp" align="middle"/>
							 -->
						</p>
						<hr />
						<p style="text-align:right">
							<a href="javascript:document.getElementById('orderForm').submit();">
								<img src="${pageContext.request.contextPath}/images/pay.png" width="204" height="51" border="0" />
							</a>
						</p>
				</div>
			</form>
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