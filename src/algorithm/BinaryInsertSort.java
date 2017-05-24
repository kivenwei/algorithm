package algorithm;

public class BinaryInsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{8,3,2,1,7,4,6,5};
		printResult(array);
		for(int i = 1; i < array.length; i++)
		{
			int tempData = array[i];
			int low = 0;
			int high = i-1;
			while(low <= high)
			{
				int middle = (low + high)/2;
				if(array[middle] < tempData)
				{
					low = middle + 1;
				}
				else
				{
					high = middle -1;
				}
			}
			System.arraycopy(array, low, array, low + 1, i - low);
			array[low] = tempData;
			printResult(array);
		}

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
