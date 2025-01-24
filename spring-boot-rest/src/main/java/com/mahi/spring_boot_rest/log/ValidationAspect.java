package com.mahi.spring_boot_rest.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);
    @Around("execution(* com.mahi.spring_boot_rest.service.JobService.getJob(..)) && args(postId)")
    public Object validationAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {

        if(postId<0){
            LOGGER.info(" PostID is negative and updating it");
            postId = -postId;
            LOGGER.info("The updated PostID is "+postId);
        }
        Object obj1=jp.proceed(new Object[]{postId});

        return obj1;
    }
}
