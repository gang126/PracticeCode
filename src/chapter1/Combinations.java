package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> results =combination(4,2);
		for(List<Integer> xx : results){		
			System.out.print(xx);			
		}

	}
/*	题目：
	Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	For example,
	If n = 4 and k = 2, a solution is:
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
	 题解：	 这道题就是用DFS(参考Work BreakII)的循环递归处理子问题的方法解决。n为循环的次数，k为每次尝试的不同数字。用到了回溯*/
	public static ArrayList<ArrayList<Integer>> combination(int n, int k){
		ArrayList<ArrayList<Integer>> res =new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		if(n<=0 || n<k ){
			return res;
		}
		DFS( n, k,1, new ArrayList<Integer>(),res);
		//dfs(n,k,1,item, res);
		
		return res;
	}
	
	public static void DFS(int n,  int k,int start,ArrayList<Integer> item,ArrayList<ArrayList<Integer>> res){
		
		if(item.size()==k){
			res.add(new ArrayList<Integer>(item));
			return;
		}
		
		for(int i=start; i<=n; i++){
			item.add(i);
			//i+1  不是start+1
			DFS( n, k,i+1,item,res);
			item.remove(item.size()-1);
			
		}
		
	}

}
