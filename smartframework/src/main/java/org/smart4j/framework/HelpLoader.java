package org.smart4j.framework;

import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.helper.*;
import org.smart4j.framework.util.ClassUtil;

/**
 * 加载相应的Helper类
 * Created by cpppp on 17-5-2.
 */
public final class HelpLoader {


    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(),true);
        }
    }

}
