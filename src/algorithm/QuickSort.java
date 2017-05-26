package algorithm;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[]{8,3,2,1,7,4,6,5};
		printResult(array);
		
		qqsort(array, 0, (array.length-1));
		printResult(array);
	}
	
	public static void qqsort(int[] array, int left, int right)
	{
		if(left < right)
		{
			int mid = division(array, left, right);
			qqsort(array, left, mid - 1);
			qqsort(array, mid + 1, right);
		}
	}
	
	public static int division(int[] array, int left, int right)
	{
		int base = array[left];
		while(left < right)
		{
			while(left < right && array[right] > base)
			{
				right--;
			}
			array[left] = array[right];
			
			while(left < right && array[left] < base)
			{
				left++;
			}
			array[right] = array[left];
		}
		array[left] =base;
		return left;
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
