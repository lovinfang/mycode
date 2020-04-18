package com.smart.context;

import com.smart.Car;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * Spring支持基于类注解的配置方式，主要功能来自Spring的一个名为 JavaConfig的子项目
 * JavaConfig现在升级为Spring核心框架的一部分
 */
public class AnnotationApplicationContextTest {

    @Test
    public void getBean(){
        //通过一个带@Configuration的POJO装在Bean配置
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = ctx.getBean("car",Car.class);
        Assert.assertNotNull(car);
        car.introduce();
    }
}
