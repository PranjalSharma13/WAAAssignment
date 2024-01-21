package edu.miu.assignment.aop;

import edu.miu.assignment.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import edu.miu.assignment.entity.Logger;

import java.time.LocalDateTime;


@Aspect
@Component
public class LoggerAspect {
    @Autowired
    LoggerService loggerService;
    @Pointcut("@annotation(edu.miu.assignment.aop.annotation.LogMe)")
 public void logMeAnnotation(){}

    @Before("logMeAnnotation()")
    public void beforeAnnotation()
    {
        System.out.println("This is before ........");
    }
    @Pointcut("execution(public * edu.miu.assignment.controller.*.*(..))")
    public void logOperations()
    {

    }
    @After("logOperations()")
    public void  saveAllExecutedOperations(JoinPoint joinPoint)
    {
        Logger logger=new Logger();
        logger.setDate(LocalDateTime.now());
        logger.setPrinciple("Principle");
        logger.setOperation(String.valueOf(joinPoint.getSignature()));
         loggerService.save(logger);


    }
}
