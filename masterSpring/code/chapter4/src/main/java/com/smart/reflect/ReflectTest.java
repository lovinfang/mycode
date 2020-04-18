package com.smart.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable{
        //通过类装载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.Car");

        //获取类的默认构造器对象并通过它实例化Car
        Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) cons.newInstance();

        //通过反射方法设置属性
        Method setBrand = clazz.getDeclaredMethod("setBrand",String.class);
        setBrand.invoke(car,"红旗CA72");
        Method setColor = clazz.getDeclaredMethod("setColor",String.class);
        setColor.invoke(car,"黑色");
        Method setMaxSpeed = clazz.getDeclaredMethod("setMaxSpeed",int.class);
        setMaxSpeed.invoke(car,200);
        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
