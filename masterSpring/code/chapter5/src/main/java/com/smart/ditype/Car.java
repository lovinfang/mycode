package com.smart.ditype;

public class Car {
	public String brand;
	private String corp;	
	private double price;
	private int maxSpeed;

	/**
	 * 当Car类中没有其他带参数的构造函数，那么 JAVA会给类定义一个默认的不带参的构造函数
	 * 如果有其他带参数的构造函数，那么JAVA不会给类定义一个默认不带参的构造函数
	 * Spring默认通过无参的构造函数构造Bean，并为需要注入的属性提供对应的Setter方法
	 * 如果没有无参的构造函数， 那么Spring在使用属性注入的时候会抛出异常
	 */
	public Car() {}	
	public Car(String brand, double price) {
		this.brand = brand;
		this.price = price;
	}	

	public Car(String brand, String corp, double price) {
		this.brand = brand;
		this.corp = corp;
		this.price = price;
	}
	public Car(String brand, String corp, int maxSpeed) {
		this.brand = brand;
		this.corp = corp;
		this.maxSpeed = maxSpeed;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString(){
		return "brand:"+brand+"/maxSpeed:"+maxSpeed+"/price:"+price+"/corp:"+corp;
	}

}

