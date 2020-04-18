package com.smart.attr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertNotNull;

public class BeanAttrDITest {

    public ApplicationContext factory = null;

    private static String[] CONFIG_FILES = { "com/smart/attr/beans.xml" };

    @BeforeClass
    public void setUp() throws Exception {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testBeanCar() {
        Car car = (Car) factory.getBean("car");
        assertNotNull(car);
        System.out.println(""+car);
    }

    @Test
    public void testBeanCar1() {
        Car car = (Car) factory.getBean("car1");
        assertNotNull(car);
        System.out.println(""+car);
    }

    @Test
    public void testBeanBoss(){
        Boss boss = (Boss) factory.getBean("boss1");
        assertNotNull(boss);
        System.out.println(boss);
    }

    @Test
    public void testBeanBoss2(){
        Boss boss = (Boss) factory.getBean("boss2");
        assertNotNull(boss);
        System.out.println(boss);
    }

    @Test
    public void testBeanBoss3(){
        Boss boss = (Boss) factory.getBean("boss3");
        assertNotNull(boss);
        System.out.println(boss);
    }

    @Test
    public void testBeanBoss4(){
        Boss boss = (Boss) factory.getBean("boss4");
        assertNotNull(boss);
        System.out.println(boss);
    }

    @Test
    public void testBeanChildBoss() {
        Boss childBoss = (Boss) factory.getBean("childBoss");
        assertNotNull(childBoss);
        System.out.println("childBoss:"+childBoss);
    }

    @Test
    public void testUtilBean(){
        List list = (LinkedList)factory.getBean("utilList");
        Set set = (HashSet)factory.getBean("utilSet");
        Map map = (HashMap)factory.getBean("utilMap");
        for (int i=0 ; i< list.size();i++){
            System.out.println(list.get(i));
        }
        map.forEach((key, value) -> {
            System.out.println("key:"+key+" value:"+value);
        });
        for (Iterator it=set.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }

}
