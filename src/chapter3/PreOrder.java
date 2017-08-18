package chapter3;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 =new TreeNode(1);
		TreeNode n2 =new TreeNode(2);
		TreeNode n3 =new TreeNode(3);
		TreeNode n4 =new TreeNode(4);
		TreeNode n5 =new TreeNode(5);
		
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		ArrayList<Integer> results= divideConquer(n1);
		for(Integer xx : results){
			System.out.print(xx);
		}
		
	}

	
	
	public static ArrayList<Integer> preOrderTraverse(TreeNode root){
		ArrayList<Integer> results =new ArrayList<Integer>();
		traverse(root, results);
		return results;
	}
	/*递归的三要素：1. 递归的定义
	         2. 递归的拆解
	         3. return 结束条件
	 返回为void, 返回都在同一个结果results里，以参数形式存在        
	         */
	public static void traverse(TreeNode root, ArrayList<Integer> results){
		if(root == null){
			return ;
		}
		results.add(root.val);
		traverse(root.left,results);
		traverse(root.right,results);	
	}
	
	public static ArrayList<Integer> divideConquer(TreeNode root){
		ArrayList<Integer> results =new ArrayList<Integer>();
		if(root == null){
			return results;
		}
		
		//divide
		ArrayList<Integer> left= divideConquer(root.left);
		ArrayList<Integer> right= divideConquer(root.right);
		
		//conquer && merge
		results.add(root.val);
		results.addAll(left);
		results.addAll(right);
		
		return results;
	}
	
	public static ArrayList<Integer> nonRecursion(TreeNode root){
		ArrayList<Integer> results =new ArrayList<Integer>();
		Stack<TreeNode> stack =new Stack<TreeNode>();
		if(root == null){
			return results;
		}
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode node= stack.pop();
			results.add(node.val);
			//注意不是root
			if(node.right!=null){
				stack.push(node.right);
			}
			if(node.left!=null){
				stack.push(node.left);
			}
		}
		return results;
	}
}
