import org.smart4j.framework.util.ClassUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;

/**
 * Created by cpppp on 17-5-2.
 */
public class test {

    public static void main(String[] args) {
        Set<Class<?>> classSet = ClassUtil.getClassSet("org.smart4j.framework");
        for (Class<?> cls : classSet) {
            System.out.println(cls.getName());
        }
    }

}
