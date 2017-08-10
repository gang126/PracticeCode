package chapter2;

public class Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={10,9,8,7};
		System.out.println(mountainSequence2(nums));
	}
	public static int mountainSequence(int[] nums) {
        // Write your code here
        int start=0;
        int end=nums.length-1;
        int mid;
        if(nums==null || nums.length==0){
            return -1;
        }
        while(start+1< end){
            mid= (start+end)/2;
            if(nums[mid]>nums[mid+1] && nums[mid] > nums[mid-1]){
                return mid;
            }else if(nums[mid]>nums[mid+1] && nums[mid] < nums[mid-1]){
                end=mid;
            }else if(nums[mid]<nums[mid+1] && nums[mid] > nums[mid-1]){
                start=end;
            }
        }
        
        return -1;
    }
	
	public static int mountainSequence2(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.max(nums[start], nums[end]);
    }

}
