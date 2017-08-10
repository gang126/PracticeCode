package chapter2;
/*http://www.jiuzhang.com/solutions/binary-search/

*��Ŀ����
Binary search is a famous question in algorithm.
For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
If the target number does not exist in the array, return -1.
Example If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
��Ŀ��ַ:http://www.lintcode.com/problem/binary-search/
*
*/


public class BinarySearch {
	/**
	  * @param nums: The integer array.
	  * @param target: Target to find.
	  * @return: The first position of target. Position starts from 0.
	  */
	public static void main(String args[]){
		int[] nums ={1,2,3,3,4,5,10};
		int index= binarySearch1(nums, 3);
		System.out.println(index);
		
	}
	 //version 1: with jiuzhang template
	 public static int binarySearch1(int[] nums, int target) {
	     if (nums == null || nums.length == 0) {
	         return -1;
	     }
	     
	     int start = 0, end = nums.length - 1;
	     //1. 退出时，是相邻两个元素。 要判断 start, end
	     //2. 查找last时，[2,2] 会死循环
	     while (start+1  < end) {
	         int mid = start + (end - start) / 2;
	         if (nums[mid] == target) {
	             end = mid;
	         } else if (nums[mid] < target) {
	             start = mid;
	             // or start = mid + 1
	         } else {
	             end = mid;
	             // or end = mid - 1
	         }
	     }
	     
	     if (nums[start] == target) {
	         return start;
	     }
	     if (nums[end] == target) {
	         return end;
	     }
	     return -1;
	 }
	 
	 /**
	  * @param nums: The integer array.
	  * @param target: Target to find.
	  * @return: The first position of target. Position starts from 0.
	  */
	//version 2: without jiuzhang template
	 public int binarySearch2(int[] nums, int target) {
	     if (nums == null || nums.length == 0) {
	         return -1;
	     }
	     
	     int start = 0, end = nums.length - 1;
	     while (start < end) {
	         int mid = start + (end - start) / 2;
	         if (nums[mid] == target) {
	             end = mid;
	         } else if (nums[mid] < target) {
	             start = mid + 1;
	         } else {
	             end = mid - 1;
	         }
	     }
	     
	     if (nums[start] == target) {
	         return start;
	     }
	     
	     return -1;
	 }
}
