package algorithm;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[]{8,3,2,1,7,4,6,5};
		printResult(array);
		for(int i = array.length - 1; i > 0; i--)
		{
			HeapAdjust(array, i, array.length - 1);
		}
		for(int i = array.length - 1; i > 0; i--)
		{
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			HeapAdjust(array, 0, i);
		}
		printResult(array);
	}
	public static void HeapAdjust(int[] array, int parent, int length)
	{
		int temp = array[parent];
		int child = 2 * parent + 1;
		while(child < length)
		{
			if(child + 1 < length && array[child] < array[child + 1])
			{
				child++;
			}
			if(temp >= array[child])
			{
				break;
			}
			array[parent] = array[child];
			parent = child;
			
			child = 2 * child +1;
		}
		array[parent] = temp;
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
