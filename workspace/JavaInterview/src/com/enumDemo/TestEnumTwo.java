package com.enumDemo;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map.Entry;


public class TestEnumTwo {

	public enum EnumTest{
		
		//其实MON,TUE等都继承了 EnumTest
		MON(1),TUE(2),WED(3),THU(4),FRI(5),SAT(6){
			public boolean isRest(){
				return true;
			}
		},
		SUN(7){
			public boolean isRest(){
				return true;
			}
		};
		
		private int value;
		private EnumTest(int value){
			this.value = value;
		}
		private int getValue(){
			return value;
		}
		
		private boolean isRest(){
			return false;
		}
		
//		public abstract boolean isRest();
		
	}
	
	public static void main(String[] args) {
		for(EnumTest test : EnumTest.values()){
			System.out.println(test.value);
			System.out.println(test.getValue()); //必须要在EnumTest中有getValue()方法
		}
		System.out.println("EnumTest.FRI 的 value = "+EnumTest.FRI.value);
		System.out.println("EnumTest.FRI 的 value = "+EnumTest.FRI.getValue());
		System.out.println("EnumTest.FRI 的 value = "+EnumTest.FRI.isRest()); //调用的是父类的方法
		System.out.println("EnumTest.FRI 的 value = "+EnumTest.SAT.isRest());
		
		/**
		 * EnumSet,EnumMap的应用
		 */
		System.out.println("EnumSet,EnumMap的应用");
		EnumSet<EnumTest> weetSet = EnumSet.allOf(EnumTest.class);
		for(EnumTest day : weetSet){
			System.out.println(day);
		}
		
		EnumMap<EnumTest, String> weekMap = new EnumMap(EnumTest.class);
		weekMap.put(EnumTest.MON, "星期一");
		weekMap.put(EnumTest.TUE, "星期二");
		weekMap.put(EnumTest.WED, "星期三");
		weekMap.put(EnumTest.THU, "星期四");
		weekMap.put(EnumTest.FRI, "星期五");
		weekMap.put(EnumTest.SAT, "星期六");
		weekMap.put(EnumTest.SUN, "星期日");
		
		for(Iterator<Entry<EnumTest,String>> iter = weekMap.entrySet().iterator();iter.hasNext();){
			Entry<EnumTest,String> entry = iter.next();
			System.out.println(entry.getKey().name() + ":"+entry.getValue());
		}
		
	}
}
