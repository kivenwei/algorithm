package com.lintcode;

public class NumberSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(add(3, 2));
	}
	
	public static int add(int num1, int num2){
		int sum = 0; 
		int carry = 0;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
			
		} while (num2 != 0);
		return sum;
	}

}
