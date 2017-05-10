package org.smart4j.framework.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 * Created by cpppp on 17-5-6.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * 注解类
     * 用来定义Controller这类注解
     */
    Class<? extends Annotation> value();

}
