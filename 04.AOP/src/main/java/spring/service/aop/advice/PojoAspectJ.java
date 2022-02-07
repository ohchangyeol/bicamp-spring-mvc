package spring.service.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PojoAspectJ {

   public PojoAspectJ() {
   System.out.println("::TestAspect01 Default Constructor");
   }
//   
//   @Pointcut("execution(* *.getMessage(..))")
//   public void work() {
//      System.out.println("work() pointcut call...........");
//   }
   
   public void before(JoinPoint joinPoint) {
      System.out.println("beforelog"+getClass()+"befoerstart");
      System.out.println("beforelogtarget objet:"+joinPoint.getTarget().getClass().getName());
      System.out.println(("beforelog target object method :" +joinPoint.getSignature().getName()));
      
      if(joinPoint.getArgs().length !=0) {
         System.out.println("beforelog target object call"+"method argument:"+joinPoint.getArgs()[0]);
      }
      System.out.println("before log"+getClass()+"before() end....");
      
   }
   public void afterReturning (JoinPoint joinPoint,Object returnValue) {
      System.out.println("afterlog"+getClass()+"afterRetruning start....");
      System.out.println("afterlog 鸥百按眉"+joinPoint.getTarget().getClass().getName());
      System.out.println("afterlog 龋免等 皋家靛"+joinPoint.getSignature().getName());
      System.out.println("afterlog return value"+returnValue);
      System.out.println("afterlog"+getClass()+"run end");
      
   }
   
   public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
      
   Object obj = joinPoint.proceed();
   
   System.out.println("+obj");
   System.out.println(getClass());
   return obj;
   }
   
   public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
      System.out.println(getClass());
   }
   
   
}