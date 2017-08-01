package chapter1;

import java.util.ArrayList;

/*题目：
Given a collection of numbers that might contain duplicates, return all possible unique permutations.
For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].

题解：
 这道题跟Permutaitons没啥大的区别，就是结果去重。
 我之前也有写过去重的两个方法:
 一个是在加入结果的时候用contains判断，一个是在找结果的时候看他是不是跟前一个元素相同。
 这道题还要考虑的是visited情况，前一个元素就算跟当前元素相同，如果visited==true也没关系。但是如果前面元素跟当前元素相同还没被visited，那么就要做去重处理了。
*/
public class Permutations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,1,2};
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
		/*if(path.size()==nums.length){
			if(!res.contains(path)){
				res.add(new ArrayList<Integer>(path));
				return;
			}	
		}*/
		if(path.size()==nums.length){
			res.add(new ArrayList<Integer>(path));
			return;
		}

		for(int i=0; i<nums.length; i++){
			if(i >0  && nums[i]== nums[i-1] && !visited[i-1]){
				continue;
			}
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
