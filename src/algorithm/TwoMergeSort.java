package algorithm;

public class TwoMergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[]{8,3,2,1,7,4,6,5};
		printResult(array);
		for(int gap =1; gap < array.length; gap = 2 * gap)
		{
			MergePass(array, gap, array.length);
		}
		printResult(array);
		
	}
	public static void MergePass(int[] array, int gap, int length)
	{
		int i = 0;
		for(i = 0; i + 2 * gap -1 < length; i = i + 2 * gap)
		{
			Merge(array, i, i + gap -1, i + 2 * gap - 1);
		}
		if(i + gap -1 < length)
		{
			Merge(array, i, i + gap - 1, length -1);
		}
	}
	public static void Merge(int[] array, int left, int mid, int right)
	{
		int i = left;
		int j = mid + 1;
		int k = 0;
		int[] tmp = new int[right - left + 1];
		while(i <= mid && j <= right)
		{
			if(array[i] < array[j])
			{
				tmp[k] = array[i];
				k++;
				i++;
			}
			if(array[i] > array[j])
			{
				tmp[k] = array[j];
				k++;
				j++;
			}
		}
		while(i <= mid)
		{
			tmp[k] = array[i];
			k++;
			i++;
		}
		while(j <= right)
		{
			tmp[k] = array[j];
			k++;
			j++;
		}
		for(k = 0, i = left; i <= right; i++, k++)
		{
			array[i] = tmp[k];
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
