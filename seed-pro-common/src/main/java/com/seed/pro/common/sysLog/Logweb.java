package com.seed.pro.common.sysLog;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Logweb
{
    String value() default "";
}
