<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    

	<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
				<s:if test="#session.existUser == null">
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="${ pageContext.request.contextPath }/user_loginPage.action">Login</a>|</li>
					<li id="headerRegister" class="headerRegister"
						style="display: list-item;"><a href="${ pageContext.request.contextPath }/user_registPage.action">Register</a>|
					</li>
				</s:if>
				<s:else>
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<s:property value="#session.existUser.name"/>
					|</li>
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="${ pageContext.request.contextPath }/order_findByUid.action?page=1">My Orders</a>
					|</li>
					<li id="headerRegister" class="headerRegister"
						style="display: list-item;">
						<a href="${ pageContext.request.contextPath }/user_quit.action">Sign Out</a>|
					</li>
				</s:else>
				
						<!--<li>
							<a>会员中心</a>
							|
						</li>
						<li>
							<a>购物指南</a>
							|
						</li>-->
						<li>
							<a>About Us</a>							
						</li>
			</ul>
		</div>
		<div class="cart">
			<a  href="${pageContext.request.contextPath}/cart_myCart.action">My Cart</a>
		</div>
			<div class="phone">
				Tel:
				<strong>(+353)0838817191</strong>
			</div>
	</div>
	
	<div class="span24" >
		<ul class="mainNav" >			
			<li >
				<a href="${pageContext.request.contextPath}/index.action">Home</a> |
			</li>
			<s:iterator var="c" value="#session.clist">
				<li>
					<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#c.cid" />&page=1"><s:property value="#c.cname" /></a> |
				</li>
			</s:iterator>
		</ul>
	</div>