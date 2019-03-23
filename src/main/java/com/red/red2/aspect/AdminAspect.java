package com.red.red2.aspect;

import com.red.red2.annotation.Adminq;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
//自己写的简单模仿Au
@Aspect
@Component
public class AdminAspect {
    @Pointcut("execution(public * com.red.red2.controller.*.*(..))")
    public void admin(){

    }

public Object handleControllerMethod(ProceedingJoinPoint pjp, HttpSession session) throws Throwable {
    if(session.getAttribute("role")=="admin"){
        return pjp.proceed();
    }
return "403";
}

}
