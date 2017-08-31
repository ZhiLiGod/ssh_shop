package com.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
/**
 * 邮件发送的工具类
 * @author think
 *
 */
public class MailUtils {
	//发送邮件
	public static void sendMail(String to, String code){
		//1.获得session对象
		//2.创建一个代表邮件的对象Message
		//3.发送邮件 transport
		Properties props = new Properties();
		props.setProperty("mail.host", "localhost");
		
		
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("service@shop.com", "123");
			}
			
		});
		
		Message message = new MimeMessage(session);
		//设置发件人
		
		try {
			message.setFrom(new InternetAddress("service@shop.com"));
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject("Confirmation mail from Shop.com");
			message.setContent("<h1>Confirmation email from Shop.com, click link below to activite your account</h1><h3><a href='http://localhost:8080/ssh_shop/user_active.action?code="+code+"'>http://localhost:8080/ssh_shop/user_active.action?code="+code+"</a></h3>",
					"text/html;charset=utf-8");
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}
	
//	public static void main(String[] args) {
//		sendMail("aaa@shop.com", "1234567890");
//	}
	
}
