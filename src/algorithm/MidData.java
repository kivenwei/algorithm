package algorithm;

public class MidData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[]{-1,-2,-3,-100,-1,-50};
		System.out.println(median(num));

	}
	
	public static int median(int[] nums) {
        // write your code here
		int left = 0;
		int right = nums.length -1;
		int leng = nums.length;
		qssort(nums, left, right);
		if(leng%2 == 0){
			return nums[leng/2 -1];
		}else {
			return nums[leng/2];
		}
    }
	
	public static void qssort(int[] nums, int left, int right){
		
		if(left < right){
			int index = division(nums, left, right);
			qssort(nums, left, index);
			qssort(nums, index+1, right);
		}
		
	}
	
	public static int division(int[] nums, int left, int right) {
		
		int pos = nums[left];
		while (left < right) {			
			while (left < right && pos <= nums[right]) {
				right--;
			}
			
			nums[left] = nums[right];
			while (left < right && nums[left] <= pos) {
				
				left++;
			}
			nums[right] = nums[left];			
		}
		nums[left] = pos;
		return left;		
	}
	

}
