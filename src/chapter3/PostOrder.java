package chapter3;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		ArrayList<Integer> results= postorderTraversal(n1);
		for(Integer xx : results){
			System.out.print(xx);
		}
	}
	
	//Iterative
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode prev = null; // previously traversed node
	    TreeNode curr = root;

	    if (root == null) {
	        return result;
	    }

	    stack.push(root);
	    while (!stack.empty()) {
	        curr = stack.peek();
	        if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
	            if (curr.left != null) {
	                stack.push(curr.left);
	            } else if (curr.right != null) {
	                stack.push(curr.right);
	            }
	        } else if (curr.left == prev) { // traverse up the tree from the left
	            if (curr.right != null) {
	                stack.push(curr.right);
	            }
	        } else { // traverse up the tree from the right
	            result.add(curr.val);
	            stack.pop();
	        }
	        prev = curr;
	    }

	    return result;
	}
}
