package com.geekhub;

import org.aspectj.lang.annotation.*;

@Aspect
public class CarAspect {

    @Before("selectAll()")
    public void logBefore() {
        System.out.println("==> Before");
    }

    @After("selectAll()")
    public void logAfter() {
        System.out.println("==> After");
    }

    @AfterReturning(pointcut = "selectAll()")
    public void afterReturningAdvice(){
        System.out.println("==> Returning");
    }

    @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
    public void AfterThrowingAdvice(IllegalArgumentException ex){
        System.out.println("==> There has been an exception: " + ex.toString());
    }

    @Pointcut("execution(* com.geekhub.Car.startCar(..))")
    private void selectAll() {}
}
