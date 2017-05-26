package algorithm;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{8,3,2,1,7,4,6,5};
		printResult(array);
		int gap = array.length/2;
		while(1 <= gap)
		{
			for(int i = gap; i < array.length; i++)
			{
				int j = 0;
				int temp = array[i];
				for(j = i - gap; j >= 0 && temp < array[j]; j = j - gap )
				{
					array[j + gap] = array[j];
				}
				array[j + gap] = temp;
			}
			gap = gap/2;
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
