package chapter1;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
/*	题目：

	Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

	Each number in C may only be used once in the combination.
	For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
	A solution set is: 
	[1, 7] 
	[1, 2, 5] 
	[2, 6] 
	
	[1, 1, 6]
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={2,3,6,7};
		int target =7;
		
		int[] nums2={10,1,2,7,6,1,5};
		int target2=8;
		ArrayList<ArrayList<Integer>> res= combinationSum(nums, target);
		ArrayList<ArrayList<Integer>> res2= combinationSum(nums2, target2);
		for(ArrayList<Integer> xx : res2){
			System.out.println(xx);
		}
		
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] nums, int target){
		ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		if(nums ==null || nums.length==0){
			return res;
		}
		//保证数据源 是 有序的 不重复？
		Arrays.sort(nums);
		boolean [] visited = new boolean[nums.length];
		dfs(res, path, nums, target, 0,visited);
		
		return res;
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int[] nums, int target, int index, boolean[] visited){
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
			//处理重复
			/*if(i!=0 && nums[i] == nums[i-1] && i>index && visited[i-1]==false){
				continue;
			}*/
			
			if(!visited[i]){
				path.add(nums[i]);
				visited[i]=true;
				dfs(res, path, nums, target-nums[i], i, visited);
				visited[i]=false;
				path.remove(path.size()-1);
			}
			
		}
	}
}
