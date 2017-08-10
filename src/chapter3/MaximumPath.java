package chapter3;

import java.util.ArrayList;

public class MaximumPath {

	public static void main(String[] args) {
		// http://www.lintcode.com/zh-cn/problem/maximum-depth-of-binary-tree/
		TreeNode n1 =new TreeNode(1);
		TreeNode n2 =new TreeNode(2);
		TreeNode n3 =new TreeNode(3);
		TreeNode n4 =new TreeNode(4);
		TreeNode n5 =new TreeNode(5);
		
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		int results= dc(n1);
	
		System.out.print(results);
		
	}
	
	//divide && conquer
	public static int dc(TreeNode root){
		
		if(root == null){
			return 0;
		}	
		int left = dc(root.left);
		int right = dc(root.right);		
		return Math.max(left, right)+1;
	}
	
	//traverse
	int depth;
	public int max(TreeNode root){
		depth=0;
		traverse(root, 1);
		return depth;
	}
	
	public void traverse(TreeNode root, int curDepth){
		if(root == null){
			return;
		}
		
		if(curDepth > depth){
			depth = curDepth;
		}
		traverse(root.left, curDepth+1);
		traverse(root.right, curDepth+1);
	}
}
