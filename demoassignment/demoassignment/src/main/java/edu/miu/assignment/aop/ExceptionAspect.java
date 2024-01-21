package edu.miu.assignment.aop;

import edu.miu.assignment.entity.ExceptionClass;
import edu.miu.assignment.service.ExceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class ExceptionAspect {
    @Autowired
    ExceptionService exceptionService;
    @Pointcut("@annotation(edu.miu.assignment.aop.annotation.ExecutionTime)")
   public void ExecutionTimeAnnotation()
   {

   }
   @AfterThrowing(value = "within(edu.miu.assignment.controller.*)", throwing = "ex")
   public void saveAllExceptions(JoinPoint joinPoint, java.lang.Exception ex){

       ExceptionClass exceptionClass=new ExceptionClass();
       exceptionClass.setDate(LocalDateTime.now());
       exceptionClass.setExceptionType(ex.getMessage());
       exceptionClass.setOperation(joinPoint.getSignature().getName());
       exceptionClass.setPrinciple("Principle");
       exceptionService.save(exceptionClass);
   }

}
