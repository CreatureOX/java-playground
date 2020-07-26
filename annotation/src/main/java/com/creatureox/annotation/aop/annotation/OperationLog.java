package com.creatureox.annotation.aop.annotation;

import java.lang.annotation.*;

/**
 * @author CreatureOX
 * date: 2020/7/26
 * description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface OperationLog {

    String description() default "";

}
