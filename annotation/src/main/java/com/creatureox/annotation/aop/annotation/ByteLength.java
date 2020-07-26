package com.creatureox.annotation.aop.annotation;

import java.lang.annotation.*;

/**
 * @author CreatureOX
 * date: 2020/7/26
 * description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
public @interface ByteLength {

    int min() default 0;

    int max() default 2147483647;

    String message() default " out of length limit";

}
