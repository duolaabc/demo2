package com.imooc.demo.Aspect;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;





@Component
@Aspect
public class TestAspect {

    @Pointcut("execution(* com.imooc.demo.service.Impl.AreaServiceImpl.*(..))")
    public void point() {      }


    @Before("point()")
    public void before(){

        System.out.println("before------------------------------");
    }

    @After("point()")
    public void after(JoinPoint joinPoint){            //joinpoint  用来得到目标类里切入点的信息
        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("after------------------------------");

    }


}

