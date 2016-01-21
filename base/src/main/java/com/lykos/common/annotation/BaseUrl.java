package com.lykos.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 *
 * http 请求域名路径
 * Created by Lykos on 16/1/21.
 */
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BaseUrl {
    String value() default "";
}
