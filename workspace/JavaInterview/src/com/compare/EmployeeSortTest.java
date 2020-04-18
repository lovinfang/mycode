package com.compare;

import java.util.Arrays;

public class EmployeeSortTest {

	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("harry Hacker", 35000);
		staff[1] = new Employee("carl cracke", 75000);
		staff[2] = new Employee("tony Tester", 38000);
		Arrays.sort(staff);  //sort��������ʵ�ֶ����������򣬵��Ǳ���ʵ��Comparable�ӿ�
		for(Employee e : staff){
			System.out.println("id=" + e.getId() + "  name=" + e.getName() + ".salary=" + e.getSalary());
		}
	}
}
