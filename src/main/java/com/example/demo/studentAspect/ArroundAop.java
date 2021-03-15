package com.example.demo.studentAspect;

import com.example.demo.exception.MainException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ArroundAop {

    @Pointcut(value = "execution(* com.example.demo.serviceImpl.EmpServiceImpl.*(..))")
    public void aspectForLogging() {

    }

    @Around(value = "aspectForLogging()")
    public void arrondAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint.getSignature().getName());
        try {
            if (1 == 1) {
                throw new MainException("User not authenticate");
            }
            joinPoint.proceed();
        } finally {
            System.out.println("The method aroundAdvice() after invokation of the method " + joinPoint.getSignature().getName() + " method");
        }
    }
}
