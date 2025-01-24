package com.mahi.spring_boot_rest.log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type fullyQualified-class-name.method-name(args)
    @Before("execution(* com.mahi.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.mahi.spring_boot_rest.service.JobService.updateJob(..)) ")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method called "+ jp.getSignature().getName());
    }

    @After("execution(* com.mahi.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.mahi.spring_boot_rest.service.JobService.updateJob(..)) ")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed"+ jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.mahi.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.mahi.spring_boot_rest.service.JobService.updateJob(..)) ")
    public void logMethodExecutedComplete(JoinPoint jp){
        LOGGER.info("Method Executed SUccess"+ jp.getSignature().getName());
    }
}

