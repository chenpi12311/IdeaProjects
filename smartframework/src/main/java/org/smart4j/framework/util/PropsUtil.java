package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by cpppp on 17-5-2.
 */
public final class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loadProps(String fileName) {
        Properties props = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException(fileName + " file is not found ");
            }
            props = new Properties();
            props.load(is);
        } catch(IOException e) {
            LOGGER.error("load properties file failure", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("close input stream failure", e);
                }
            }
        }

        return props;
    }

    /**
     * 获取字符型属性(默认值为空字符串)
     * @param props
     * @param key
     * @return
     */
    public static String getString(Properties props, String key) {
        return getString(props,key,"");
    }

    /**
     * 获取字符型属性(可指定默认值)
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue;
        if (props.containsKey(key)) {
            value = props.getProperty(key);
        }
        return value;
    }

    /**
     * 获取数值型属性(默认值为0)
     */
    public static int getInt(Properties props, String key) {
        return getInt(props, key, 0);
    }

    /**
     * 获取数值型属性(可指定默认值)
     */
    public static int getInt(Properties props, String key, int defaultValue) {
        int value = defaultValue;
        if (props.containsKey(key)) {
            try {
                value = Integer.parseInt(props.getProperty(key));
            } catch (NumberFormatException e) {
                value = defaultValue;
            }
        }
        return value;
    }

    /**
     * 获取布尔值属性(默认值为false)
     * @param props
     * @param key
     * @return
     */
    public static boolean getBoolean(Properties props, String key) {
        return getBoolean(props, key, false);
    }

    /**
     * 获取布尔值属性(可指定默认值)
     */
    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if (props.containsKey(key)) {
            try {
                value = Boolean.parseBoolean(props.getProperty(key));
            } catch (Exception e) {
                value = defaultValue;
            }
        }
        return value;
    }

}
