package spring.service.lifecycle;

import org.springframework.beans.factory.BeanNameAware;

public class LifeCycle01 implements BeanNameAware{

	public LifeCycle01() {
		System.out.println("\n ::"+getClass().getName() + "����Ʈ ������...");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("::"+ getClass().getName()+ ".setBeanName() Start");
		System.out.println("XML �� ���ǵ� beanName : " + name);
		System.out.println("::"+ getClass().getName()+ ".setBeanName() end");
	}
	
	public void init() {
		System.out.println("::"+getClass().getName()+ ".init()");
	}
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("::"+getClass().getName()+ "destory()");
	}
}
