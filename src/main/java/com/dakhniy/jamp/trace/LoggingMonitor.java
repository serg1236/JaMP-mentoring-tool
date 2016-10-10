package com.dakhniy.jamp.trace;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Sergiy_Dakhniy on 10/6/2016.
 */

@Aspect
@Component
public class LoggingMonitor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.dakhniy.jamp.repository.*Repository+.*(..))")
    public void allRepositories(){};

    @Before("allRepositories()")
    public void beforeRepositoryMethods(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        logger.info("Starting: " + signature.getName() + " in " + signature.getDeclaringTypeName());
    }

    @After("allRepositories()")
    public void afterRepositoryMethods(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        logger.info("Successfully executed: " + signature.getName() + " in " + signature.getDeclaringTypeName());
    }

    @AfterThrowing("allRepositories() || within(com.dakhniy.jamp.service..*Service)")
    public void afterRepositoryMethodsException(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        logger.error("Error during executing: " + signature.getName() + " in " + signature.getDeclaringTypeName());
    }


}
