package com.smart.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateCarReflect {

    public static void main(String[] args) throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.PrivateCar");
        PrivateCar privateCar = (PrivateCar) clazz.newInstance();
        Field colorFld = clazz.getDeclaredField("color");

        //取消java语言访问检查以访问private变量
        colorFld.setAccessible(true);
        colorFld.set(privateCar,"红色");

        Method driveMtd = clazz.getDeclaredMethod("drive",(Class[]) null);
        //Method driveMtd = clazz.getDeclaredMethod("drive") java5.0以下使用
        //取消java语言访问检查以访问protected 方法
        driveMtd.setAccessible(true);
        driveMtd.invoke(privateCar,(Object[]) null);
    }
}
