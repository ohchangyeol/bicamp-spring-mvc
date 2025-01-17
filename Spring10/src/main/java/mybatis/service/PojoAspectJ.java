package mybatis.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PojoAspectJ {

   public PojoAspectJ() {
   System.out.println("::TestAspect01 Default Constructor");
   }
   
   
   public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
      
	   System.out.println("\n[Around before]"+getClass() + ".invoke() Start....");
	   System.out.println("[Around before] Ÿ�� ��ü : "+joinPoint.getTarget().getClass().getName());
	   System.out.println("[Around before] Ÿ�� ��ü�� ȣ��� method  : "+joinPoint.getSignature().getName());
	   
	   if(joinPoint.getArgs().length != 0 ) {
		   System.out.println("[Around before] Ÿ�� ��ü�� ȣ���� "+"method�� ���޵Ǵ� ���� : "+ joinPoint.getArgs()[0]);
	   }
	   
	   Object obj = joinPoint.proceed();
	   
	   System.out.println("[Around after] Ÿ�� ��ü�� ȣ���� return value : "+obj);
	   System.out.println("[Around after] " +getClass() + "invoke()end......");
	   return obj;
   }
   
}