package chapter3;

import java.util.ArrayList;
import java.util.Stack;

public class InOrder {

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
		ArrayList<Integer> results= nonRecursion(n1);
		for(Integer xx : results){
			System.out.print(xx);
		}
				
	}
	
	public static ArrayList<Integer> nonRecursion(TreeNode root){
		ArrayList<Integer> results = new ArrayList<Integer>();
		Stack<TreeNode> stack =new Stack<TreeNode>();
		//不用新变量也可以
		TreeNode node =root;
		
		while(node !=null || !stack.isEmpty()){
			while(node!=null){
				stack.push(node);
				node= node.left;
			}
			node= stack.pop();
			results.add(node.val);
			node=node.right;
		}
		return results;
	}
}
