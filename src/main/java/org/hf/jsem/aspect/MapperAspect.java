package org.hf.jsem.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hf.jsem.annotations.DataSourceInvoke;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * Created by adramer on 2016/11/17.
 */
@Component
@Aspect
public class MapperAspect {

    private static final Log log = LogFactoryImpl.getLog(MapperAspect.class);

    @Pointcut("execution(* org.hf.jsem.dao.*.*(..))")
    public void daoAspect() {
    }

    @Before("daoAspect()")
    public void beforeMethod(JoinPoint joinPoint) {
    }

}
