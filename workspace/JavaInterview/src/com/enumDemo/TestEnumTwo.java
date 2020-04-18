package com.enumDemo;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map.Entry;


public class TestEnumTwo {

	public enum EnumTest{
		
		//��ʵMON,TUE�ȶ��̳��� EnumTest
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
			System.out.println(test.getValue()); //����Ҫ��EnumTest����getValue()����
		}
		System.out.println("EnumTest.FRI �� value = "+EnumTest.FRI.value);
		System.out.println("EnumTest.FRI �� value = "+EnumTest.FRI.getValue());
		System.out.println("EnumTest.FRI �� value = "+EnumTest.FRI.isRest()); //���õ��Ǹ���ķ���
		System.out.println("EnumTest.FRI �� value = "+EnumTest.SAT.isRest());
		
		/**
		 * EnumSet,EnumMap��Ӧ��
		 */
		System.out.println("EnumSet,EnumMap��Ӧ��");
		EnumSet<EnumTest> weetSet = EnumSet.allOf(EnumTest.class);
		for(EnumTest day : weetSet){
			System.out.println(day);
		}
		
		EnumMap<EnumTest, String> weekMap = new EnumMap(EnumTest.class);
		weekMap.put(EnumTest.MON, "����һ");
		weekMap.put(EnumTest.TUE, "���ڶ�");
		weekMap.put(EnumTest.WED, "������");
		weekMap.put(EnumTest.THU, "������");
		weekMap.put(EnumTest.FRI, "������");
		weekMap.put(EnumTest.SAT, "������");
		weekMap.put(EnumTest.SUN, "������");
		
		for(Iterator<Entry<EnumTest,String>> iter = weekMap.entrySet().iterator();iter.hasNext();){
			Entry<EnumTest,String> entry = iter.next();
			System.out.println(entry.getKey().name() + ":"+entry.getValue());
		}
		
	}
}
