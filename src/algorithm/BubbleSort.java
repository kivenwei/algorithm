package algorithm;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[]{8,3,2,1,7,4,6,5};
		printResult(array);
		for(int i = 0; i <= array.length-1; i++)
		{
			for(int j = 0; j < array.length-1-i; j++)
			{
				if(array[j] > array[j+1])
				{
					swap(array, j, j+1);
				}
				printResult(array);
			}
		}
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
