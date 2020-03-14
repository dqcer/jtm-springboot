package com.dqcer.jwt.annotation;


import java.lang.annotation.*;

/**
 * JWT验证忽略注解
 * @author dqcer
 * @description
 * @date 10:27 2020/3/14
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtIgnore {
}
