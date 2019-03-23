package com.red.red2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
//模仿
@Component
@Aspect
public class UserqAspect {

    @Pointcut("execution(public * com.red.red2.controller.*.*(..))")
    public void userq() {
    }

    @Around("userq()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        String role = (String) request.getSession().getAttribute("role");
        if (request.getRequestURI().contains("user")) {
            if(!"user".equals(role)){
                return "403";
            }
        }
        return pjp.proceed();
    }
}
