package com.example.shiyanspring.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 接口参数校验 注解
 * @author yuxue
 * @date 2019-05-11
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckParams {
    /**
     *
     * 多个CheckParam，由上往下判断
     */
	CheckParam[] value();
}