package algorithm;

public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {
                50, 123, 543, 187, 49, 30, 0, 2, 11, 100
        };
		printResult(array);
		radix(array, 0, array.length-1, 3);
		printResult(array);

	}
	
	public static int getDigit(int x, int d)
	{
		int a[] = {1, 1, 10, 100};
		return ((x / a[d])%10);
	}
	
	public static void radix(int[] array, int begin, int end, int digit)
	{
		final int radix = 10;
		int i = 0, j = 0;
		int[] count = new int[radix];
		int[] bucket = new int[end - begin +1];
		for(int d = 1; d <= digit; d++)
		{
			for(i = 0; i < radix; i++)
			{
				count[i] = 0;
			}
			for(i = begin; i <= end; i++)
			{
				j = getDigit(array[i], d);
				count[j]++;
			}
			for(i = 1; i < radix; i++)
			{
				count[i] = count[i] + count[i - 1];
			}
			for(i = end; i >= begin; i--)
			{
				j = getDigit(array[i], d);
				bucket[count[j] - 1] = array[i];
				count[j]--;
			}
			
			for(i = begin, j = 0; i <= end; i++, j++)
			{
				array[i] = bucket[j];
			}
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
