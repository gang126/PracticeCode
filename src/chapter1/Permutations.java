package chapter1;

import java.util.ArrayList;

/*题目：

Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

题解：
这道题就用循环递归解决子问题。
因为求所有组合，这就意味着不能重复使用元素，要用visited数组。
有因为是所有可能的组合，所以循环length次，就是这里面每位都有可能有length个可能性。
正因为如此，每一层递归就不需要传递一个start点，告诉他从哪开始（因为都是从头开始循环）。
*/
public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,2,3};
		ArrayList<ArrayList<Integer>> res = permutation(nums);
		for(ArrayList<Integer> xx : res){
			System.out.print(xx);
		}
	}
	
	public static ArrayList<ArrayList<Integer>> permutation(int [] nums){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		if(nums == null){
			return res;
		}
		boolean[] visited= new boolean[nums.length];
		DFS(res, path, nums,visited);
		
		return res;
	}
	
	public static void DFS(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int[] nums, boolean[] visited){
		if(path.size()==nums.length){
			res.add(new ArrayList<Integer>(path));
			return;
		}

		for(int i=0; i<nums.length; i++){
			if(!visited[i]){
				path.add(nums[i]);
				visited[i]=true;
				DFS(res, path, nums, visited);
				visited[i]=false;
				path.remove(path.size()-1);
			}
			
		}
	}
}
