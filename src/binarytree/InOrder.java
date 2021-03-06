package binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class InOrder {
	
	
	
	
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;}
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode prev = null; // previously traversed node
	    TreeNode curr = root;
	    if (root == null) {
	        return result;}
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
	            stack.pop();}
	        prev = curr;
	    }
	    return result;
	}
}
