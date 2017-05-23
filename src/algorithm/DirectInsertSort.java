package algorithm;

public class DirectInsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{8,3,2,1,7,4,6,5};
		printResult(array);
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(array[i] < array[j])
				{
					int temp = array[i];
					System.arraycopy(array, j, array, j+1, i-j);
					array[j] = temp;
				}
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
