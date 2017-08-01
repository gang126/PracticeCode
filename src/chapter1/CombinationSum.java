package chapter1;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
/*	��Ŀ��

	Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

	The same repeated number may be chosen from C unlimited number of times.
	For example, given candidate set 2,3,6,7 and target 7, 
	A solution set is: 
	[7] 
	[2, 2, 3]
	*/
	
/*	题解：

	还是老问题，用DFS找解决方案，不同点是，这道题： The same repeated number may be chosen from C unlimited number of times.

	所以，每次跳进递归不用都往后挪一个，还可以利用当前的元素尝试。

	同时，这道题还要判断重复解。用我之前介绍的两个方法：

	 1.       if(i>0 && candidates[i] == candidates[i-1])//deal with dupicate
	                 continue; 

	 2.       if(!res.contains(item)) 
	                res.add(new ArrayList<Integer>(item));   

	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={2,3,6,7};
		int target =7;

		ArrayList<ArrayList<Integer>> res= combinationSum(nums, target);
		for(ArrayList<Integer> xx : res){
			System.out.println(xx);
		}
		
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] nums, int target){
		ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		if(nums ==null || nums.length==0){
			return res;
		}
		//��֤���Դ �� ����� ���ظ���
		Arrays.sort(nums);
		dfs(res, path, nums, target, 0);
		
		return res;
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int[] nums, int target, int index){
		if(target<0){
			return ;
		}
		if(target==0){
			if(!res.contains(path)){
				res.add(new ArrayList<Integer>(path));
				return;
			}
			
			
		}
		
		
		for(int i=index; i<nums.length; i++){
			//�����ظ�
			/*if(i!=0 && nums[i] == nums[i-1] && i>index){
				continue;
			}*/
			path.add(nums[i]);
			dfs(res, path, nums, target-nums[i], i);
			path.remove(path.size()-1);
		}
	}
}
