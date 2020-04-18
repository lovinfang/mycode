package com.smart.context;

import com.smart.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration 表示是一个配置信息提供类
@Configuration
public class Beans {

    @Bean(name="car")  //定义一个Bean
    public Car buildCar(){
        Car car = new Car();
        car.setBrand("红旗CA72");
        car.setMaxSpeed(200);
        return car;
    }

}
