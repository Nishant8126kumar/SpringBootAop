package com.example.demo.studentAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StudentAop {
    //    @Before(value = "execution(* com.example.demo.serviceImpl.EmpServiceImpl.*(..)) and args(empRecord)")
    @Before(value = "execution(* com.example.demo.serviceImpl.EmpServiceImpl.*(..)) and args(empRecord)")
    public void display(JoinPoint joinPoint, String empRecord) {
//        System.out.println("From Aspect" + joinPoint.getSignature());
//        System.out.println("data=:" + empRecord);
    }

//    @Before(value = "execution(* com.example.demo.serviceImpl.EmpServiceImpl.*(..)) and args(empId)")
    public void deleteEmp(JoinPoint joinPoint, int empId) {
//        System.out.println("Joint pointcut" + joinPoint.getSourceLocation());
//        System.out.println("empId=:" + empId);

    }
}
