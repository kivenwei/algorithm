package algorithm; 

import org.omg.CORBA.WCharSeqHelper;

public class Numberof1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(number1(9));
	}
	
	public static int number1(int n){
		int count = 0;
		while(n != 0){
			count++;
			n = n & (n-1);
		}
		return count;
	}

}
