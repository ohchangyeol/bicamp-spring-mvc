package spring.service.lifecycle;

import org.springframework.beans.factory.BeanNameAware;

public class LifeCycle02{

	private static LifeCycle02 lifeCycle;
	
	public LifeCycle02() {
		System.out.println("\n ::"+getClass().getName() + "디폴트 생성자...");
	}

	
	public static LifeCycle02 getInstance() {
		System.out.println("\n LifeCycle02.getInstance");
		if(lifeCycle == null) {
			lifeCycle = new LifeCycle02();
		}
		return lifeCycle;
	}
}
