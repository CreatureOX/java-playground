package com.creatureox.annotation.aop;

import com.creatureox.annotation.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author CreatureOX
 * date: 2020/7/26
 * description:
 */
@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    @Pointcut("@annotation(com.creatureox.annotation.aop.annotation.OperationLog)")
    public void operationLog(){
    }

    @Before("operationLog()")
    public void doBefore(JoinPoint joinPoint){
        try {
            log.info("=============<do before>=============");
        }catch (Exception e){
            log.error("doBefore error {}", e);
        }
    }

    @Around("operationLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object[] objects = proceedingJoinPoint.getArgs();
        String name = proceedingJoinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();

        log.warn("current class：{}, method name：{}", proceedingJoinPoint.getTarget().getClass().getName(), name);
        if (objects != null){
            for (Object object: objects){
                if (null != object){
                    log.warn("request param: {}： <{}>", object.getClass().getName(), JsonUtil.toString(object));
                }
            }
        }
        if (result != null){
            log.warn("response: <{}>", result.toString());
        }
        log.warn(name + " cost time: {}", System.currentTimeMillis() - startTime + "ms");
        return result;
    }


    @After("operationLog()")
    public void doAfter(JoinPoint joinPoint){
        try {
            log.info("=============<do after>=============");
        }catch (Exception e){
            log.error("doAfter error {}", e);
        }
    }

}
