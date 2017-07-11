package binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrder {

	public static void main(String args[]){
		TreeNode n8= new TreeNode(8);
		TreeNode n5= new TreeNode(5);
		TreeNode n12= new TreeNode(12);
		TreeNode n3= new TreeNode(3);
		TreeNode n7= new TreeNode(7);
		TreeNode n2= new TreeNode(2);
		TreeNode n4= new TreeNode(4);
		TreeNode n9= new TreeNode(9);
		TreeNode n15= new TreeNode(15);
		TreeNode n14= new TreeNode(14);
		n8.left=n5;
		n8.right=n12;
		n5.left=n3;
		n5.right=n7;
		n3.left=n2;
		n3.right=n4;
		
		n12.left=n9;
		n12.right=n15;
		n15.left=n14;
		ArrayList<Integer> list = postorderTraversal(n8);
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
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
