/**
 *
 */
package com.cpaladin.study.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.stereotype.Component;

/**
 * @author chenzhiwei
 * @since 2015-2-9
 */
//@Aspect
//@Component
public class ServiceAspect {

//    @Before("execution(* com.cpaladin.studyspring.aop.service.*.*(..))")
    public void before() {
        System.out.println("before-->");
    }

    public void afterReturning(int retVal) {
        System.out.println("after returning-->" + retVal);
    }

    public void afterThrowing(Exception e) {
        System.out.println("after throwing-->" + e);
    }

    public void after() {
        System.out.println("after(finally)-->");
    }

    public Object around(ProceedingJoinPoint pjp, String string) throws Throwable {
        System.out.println("around-->" + string);
        System.out.println(pjp.getSignature());
        pjp.getArgs()[0] = "aaa";
        return pjp.proceed(pjp.getArgs());
    }

}
