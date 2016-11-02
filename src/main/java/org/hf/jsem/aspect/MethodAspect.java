package org.hf.jsem.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by adramer on 2016/10/26.
 */
@Component
@Aspect
public class MethodAspect {
    private static final Log log = LogFactoryImpl.getLog(MethodAspect.class);

    //配置切入点,第一个星号是否方法的返回值 第二个星是只service的所有子包 另一个是任意方法
    @Pointcut("execution(* org.hf.jsem.serviceImp.*.*(..))")
    public void aspect() {
    }

    /**
     * 切面的前置方法 即方法执行前拦截到的方法 记录并输出
     * 在目标方法执行之前的通知
     *
     * @param joinPoint
     */

    @Before("aspect()")
    public void beforeMethod(JoinPoint joinPoint) {
        List<Object> list = Arrays.asList(joinPoint.getArgs());
        log.info("开始执行 ===>> " + joinPoint.getSignature() + " with params: " + list);
    }

    /**
     * 切面的后置方法，不管抛不抛异常都会走此方法
     * 在目标方法执行之后的通知
     *
     * @param joinPoint
     */
    @After("aspect()")
    public void afterMethod(JoinPoint joinPoint) {
        log.info("执行结束 ===>> " + joinPoint.getSignature());
    }

    /**
     * 在方法正常执行通过之后执行的通知叫做返回通知
     * 可以返回到方法的返回值 在注解后加入returning
     *
     * @param joinPoint
     */
    @AfterReturning(pointcut = "aspect()", returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
        log.info("执行了【" + joinPoint.getSignature() + "方法正常执行结束......】" + "【返回结果:" + result + "】");
    }

    /**
     * 在目标方法非正常执行完成 发生异常 抛出异常的时候会走此方法
     * 获得异常可以用throwing
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(pointcut = "aspect()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        log.error("执行了【" + joinPoint.getSignature() + "方法发生异常......】" + "【异常报告:" + ex + "】");
    }

    /**
     * 环绕通知需要携带ProceedingJoinPoint 这个类型的参数
     * 环绕通知类似于动态代理的全过程 ProceedingJoinPoint类型的参数可以决定是否执行目标函数
     * 环绕通知必须有返回值
     *
     * @param proceedingJoinPoint
     * @return
     */
    //@Around("aspect()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Field[] fields = proceedingJoinPoint.getSignature().getDeclaringType().getFields();
        for(Field field:fields){
            System.out.println("-----------------------------------------------");
            Annotation[] annotations = field.getAnnotations();
            for(Annotation annotation:annotations) {
                System.out.println(annotation.toString());
            }
        }

        System.out.println("-----------------------------------------------");


        return proceedingJoinPoint.proceed();
    }
}
