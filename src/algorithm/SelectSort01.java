package algorithm;

public class SelectSort01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{8,3,2,1,7,4,6,5};
		printResult(array);
		int count = 0;
		for(int i = 0; i < array.length-1; i++)
		{
			int temp = i;
			for(int j = i + 1; j < array.length; j++)
			{
				if(array[temp] > array[j])
				{
                    temp = j;
				}
				
			}
			if(temp != i)
			{
				swap(array, i, temp);
				count++;
			}
			printResult(array);
		}
		printResult(array);
		System.out.println(count);
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
