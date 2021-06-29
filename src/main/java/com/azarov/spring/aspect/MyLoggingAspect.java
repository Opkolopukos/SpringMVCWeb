package com.azarov.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* com.azarov.spring.dao.EmployeeDAO.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("Begin of " + methodName);
        Object methodResult = proceedingJoinPoint.proceed();
        System.out.println("End of method " + methodName);
        return methodResult;
    }
}
