package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLogAdvice implements MethodBeforeAdvice {

	public BeforeLogAdvice() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void before(Method method, Object[] args, Object arg2) throws Throwable {
		System.out.println("\n =======================================");
		System.out.println("[before LOG] " + getClass()+".before() start....");
		System.out.println("[before LOG] targetObject call Method : "+method);
		if(args.length != 0) {
			System.out.println("[before LOG] targetObject Method РќДо argument "+args[0]);
		}
		System.out.println("[before LOG] " + getClass()+".before() end....");

	}

}
