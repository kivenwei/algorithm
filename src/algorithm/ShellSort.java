package algorithm;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{8,3,2,1,7,4,6,5};
		printResult(array);
		
		printResult(array);

	}
	
	private static void printResult(int[] array){
		for(int value:array){
			System.out.print(" " + value + " ");
		}
		System.out.println();
	}
	
	private static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}


}
