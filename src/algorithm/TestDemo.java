package com.lintcode;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(solution(3));

	}
	
	public static int solution(int n){
		int sum = n;
		boolean bool = (n != 0) && ((sum += solution(n - 1)) != 0);
		return sum;
	}

}
