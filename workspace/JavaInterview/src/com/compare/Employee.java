package com.compare;

import java.util.Random;

public class Employee implements Comparable<Employee>{
	
	private int id;
	private String name;
	private double salary;
	
	public Employee(String n,double s){
		name = n;
		salary = s;
		Random ID = new Random();
		id = ID.nextInt(10000000);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void raiseSalary(double byPercent){
		double raise = salary*byPercent / 100;
		salary += raise;
	}

	@Override
	public int compareTo(Employee other) {
		if(id < other.id){    
			//这里比较的是什么 sort方法实现的就是按照此比较的东西从小到大排列
			return -1;
		} 
		if(id > other.id){
			return 1;
		}
		return 0;
	}

}
