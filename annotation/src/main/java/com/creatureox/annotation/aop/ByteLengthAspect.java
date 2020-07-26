package com.creatureox.annotation.aop;

import com.creatureox.annotation.aop.annotation.ByteLength;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author CreatureOX
 * date: 2020/7/26
 * description:
 */
@Aspect
@Component
@Slf4j
public class ByteLengthAspect {

    private static final String PACKAGE_PREFIX = "com.creatureox.annotation";

    @Before("execution(* com.creatureox.annotation.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        for (Object arg: args){
            validate(arg);
        }
    }

    private void validate(Object object) throws Throwable {
        if (!object.getClass().getName().startsWith(PACKAGE_PREFIX)){
            return;
        }
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field: fields){
            field.setAccessible(true);
            ByteLength byteLength = field.getAnnotation(ByteLength.class);
            if (byteLength != null){
                int length = field.get(object).toString().getBytes().length;
                if (length < byteLength.min() || length > byteLength.max()){
                    throw new RuntimeException(object.getClass().getName() + "." + field.getName() + byteLength.message());
                }
            }
            validate(field.get(object));
        }
    }

}
