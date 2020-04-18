package com.smart.ditype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DiTypeTest {

    public ApplicationContext factory = null;

    private static String[] CONFIG_FILES = { "com/smart/ditype/beans.xml" };

    @BeforeClass
    public void setUp() throws Exception {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testCar(){
        Car car = (Car) factory.getBean("car");
        Assert.assertNotNull(car);
        System.out.println(car.toString());
    }

    @Test
    public void testCar1(){
        Car car1 = (Car)factory.getBean("car1");
        Assert.assertNotNull(car1);
        System.out.println(car1);
    }

    @Test
    public void testCar2(){
        Car car2 = (Car)factory.getBean("car2");
        Assert.assertNotNull(car2);
        System.out.println(car2);
    }

    @Test
    public void testCar3(){
        Car car3 = (Car)factory.getBean("car3");
        Assert.assertNotNull(car3);
        System.out.println(car3);
    }

    @Test
    public void testCar4(){
        Car car4 = (Car)factory.getBean("car4");
        Assert.assertNotNull(car4);
        System.out.println(car4);
    }

    @Test
    public void testCar5(){
        Car car = (Car)factory.getBean("car5");
        Assert.assertNotNull(car);
        System.out.println(car);
    }

    @Test
    public void testCar6(){
        Car car = (Car)factory.getBean("car6");
        Assert.assertNotNull(car);
        System.out.println(car);
    }

    @Test
    public void testBoss(){
        Boss boss = (Boss) factory.getBean("boss");
        Assert.assertNotNull(boss);
        System.out.println(boss);
    }

    @Test
    public void testBoss1(){
        Boss boss = (Boss) factory.getBean("boss1");
        Assert.assertNotNull(boss);
        System.out.println(boss);
    }

    @Test
    public void testBoss2(){
        Boss boss = (Boss) factory.getBean("boss2");
        Assert.assertNotNull(boss);
        System.out.println(boss);
    }

    @Test
    public void testBoss3(){
        Boss boss = (Boss) factory.getBean("boss3");
        Assert.assertNotNull(boss);
        System.out.println(boss);
    }
}
