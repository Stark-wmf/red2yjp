package com.red.red2.aspect;

import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
@Component
@Aspect
public class AuthenticationAspect {

    @Pointcut("execution(public * com.red.red2.controller.*.*(..))")
    public void authentication() {
    }

    @Around("authentication()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        String role = (String) request.getSession().getAttribute("role");
        if (request.getRequestURI().contains("admin")) {
            if(!"admin".equals(role)){
                return "403";
            }
        }
        return pjp.proceed();
    }
}