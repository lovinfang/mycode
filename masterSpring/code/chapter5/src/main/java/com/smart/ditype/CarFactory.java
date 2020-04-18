package com.smart.ditype;

public class CarFactory {
	//非静态工厂方法
   public Car createHongQiCar(){
	   Car car = new Car();
	   car.setBrand("红旗CA72");
	   return car;
   }

   //静态工厂方法
   public static Car createCar(){
	   Car car = new Car();
	   return car;
   }
}
