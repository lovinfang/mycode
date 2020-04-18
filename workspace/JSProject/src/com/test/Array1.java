package com.test;

public class Array1 {

	public static void main(String[] args) {
		int array1[] = new int [4];
		array1[0] = 5;
		array1[2] = 8;
		printA("array1", array1);
		int array2[];
		array2 = array1;
		array2[1] = 3;
		printA("array2", array2);
		int array3[] = new int [5];
		array3[4] = 1;
		System.arraycopy(array2, 0, array3, 1, array2.length); // 5380  05380
		printA("array3", array3);
	}
	
	public static void printA(String str,int a[]){
		System.out.println(str+":");
		for(int i=0;i<a.length;i++){
			System.out.print("   "+a[i]);
		}
		System.out.println();
	}
}
