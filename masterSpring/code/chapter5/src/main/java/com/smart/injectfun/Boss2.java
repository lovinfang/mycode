package com.smart.injectfun;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class Boss2 implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        Car car = new Car();
        car.setBrand("美人豹");
        return car;
    }
}
