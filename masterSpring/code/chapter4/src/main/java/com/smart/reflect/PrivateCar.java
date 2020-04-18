package com.smart.reflect;

public class PrivateCar {
   // private 成员变量，使用传统的类实例调用方式，只能在本类中使用
   private String color;
   //protected 方法，使用传统的类实例调用方式，只能在子类和本包中使用
   protected void drive(){
	   System.out.println("drive private car! the color is:"+color);
   }
}
