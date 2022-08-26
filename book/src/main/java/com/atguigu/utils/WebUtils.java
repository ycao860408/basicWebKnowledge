package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static <T> T copy2Bean(T bean, Map params) {
        try {
            BeanUtils.populate(bean, params);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static Integer parseInt(String item, Integer alt) {
        try {
            //System.out.println("inside: " + item);
            if(item != null && item != "") {
                return Integer.parseInt(item);
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return alt;
    }
}
