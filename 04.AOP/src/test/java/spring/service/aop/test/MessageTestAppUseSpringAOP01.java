package spring.service.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.aop.Message;

public class MessageTestAppUseSpringAOP01 {
	
	///Main Method
	public static void main(String[] args) throws Exception{

		ApplicationContext context = 
				new ClassPathXmlApplicationContext("/config/messageservice01.xml");
				
		//==> IoC Container �� ���� Look Up �� �ν��Ͻ��� ProxyFactoryBean ��ü�� �������� 
		//==> Message interface ������ Dynamic Proxy
		System.out.println("������");
		Message message = (Message)context.getBean("message");

	    message.setMessage("Hello");
	    System.out.println("\n���� ���� �޼��� : "+message.getMessage());
	}
}//end of class