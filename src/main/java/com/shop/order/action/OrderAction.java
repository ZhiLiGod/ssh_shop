package com.shop.order.action;

import java.io.IOException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.cart.domain.Cart;
import com.shop.cart.domain.CartItem;
import com.shop.order.domain.Order;
import com.shop.order.domain.OrderItem;
import com.shop.order.service.OrderService;
import com.shop.user.domain.User;
import com.shop.utils.PageBean;
import com.shop.utils.PaymentUtil;

/**
 * 订单管理的action
 * @author think
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	private OrderService orderService;	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	private Order order = new Order();
	@Override
	public Order getModel() {
		return order;
	}
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}

	//支付银行
	private String pd_FrpId;
	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}
	
	//接受付款成功后相应的数据
	private String r3_Amt;
	private String r6_Order;
	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}
	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}
	

	//生成订单
	public String save(){
		//保存数据到数据库
		order.setOrdertime(new Date());
		order.setState(1); //1.未付款 2.已经付款没有发货 3.已经发货没有确认收货 4.确认收货
		//总计的数据从购物车获得
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart == null){
			this.addActionError("Please shopping first");
			return "msg";
		}
		
		order.setTotal(cart.getTotal());
		//设置订单项
		for(CartItem cartItem : cart.getCartItems()){
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			//加进Set
			order.getOrderItems().add(orderItem);
		}
		//订单所属的用户
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(user == null){
			this.addActionError("Please log in first");
			return "login";
		}
		order.setUser(user);
		orderService.save(order);
		//将订单的对象显示到页面上
		
		
		//保存完 清空购物车
		cart.clearCart();
		return "saveSuccess";
	}
	
	
	//根据uid查询订单
	public String findByUid(){
		//根据用户id查询
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		PageBean<Order> pb = orderService.findByPageUid(user.getUid(), page);
		ActionContext.getContext().getValueStack().set("pb", pb);
		
		return "findByUidSuccess";
	}
	
	//根据订单ID查询订单信息
	public String findByOid(){
		order = orderService.findByOid(order.getOid());
		return "findByOidSuccess";
	}
	
	//为订单付款
	public String payOrder() throws Exception{
		//修改订单
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setAddr(order.getAddr());
		currOrder.setName(order.getName());
		currOrder.setPhone(order.getPhone());
		
		orderService.updateOrder(currOrder);
		//付款
		String p0_Cmd = "Buy";//业务类型
		String p1_MerId = "10001126856";//商户编号
		String p2_Order = order.getOid().toString();
		String p3_Amt = "0.01"; //测试
		String p4_Cur = "CNY";//交易币种
		String p5_Pid = "";//商品名称
		String p6_Pcat = "";//商品的种类
		String p7_Pdesc = "";//商品的描述
		String p8_Url = "http://localhost:8080/ssh_shop/order_callBack.action";//支付成功后跳转的页面路径
		String p9_SAF = "";//送货地址
		String pa_MP = "";//商户的扩展信息
		String pd_FrpId = this.pd_FrpId;
		String pr_NeedResponse = "1";//应答机制
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";//密钥
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
		//向易宝出发
		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		
		//重定向到易宝
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
	}
	
	//付款成功后
	public String callBack(){
		//修改订单状态：已经付款
		Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
		currOrder.setState(2);
		orderService.updateOrder(currOrder);
		
		//页面显示付款成功
		this.addActionMessage("Paid successful, Order ID:" + r6_Order + "Price:" + r3_Amt);
		
		return "msg";
	}
	
	//更改状态
	public String updateState(){
		
		Order curr = orderService.findByOid(order.getOid());
		curr.setState(4);
		orderService.updateOrder(curr);
		return "updateState";
	}
	
}
