package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
	
	public List<Integer> preOrderTraversal1(TreeNode node){
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack =new Stack<TreeNode>();
		
		if(node ==null){
			return result;
		}
		stack.push(node);
		while(!stack.isEmpty()){
			TreeNode nodes= stack.pop();
			result.add(nodes.val);
			if(nodes.right!=null){
				stack.push(nodes.right);
			}
			if(nodes.left!=null){
				stack.push(nodes.left);
			}
		}
		return result;
	}
	
	//Version 1: Traverse
	 public ArrayList<Integer> preorderTraversal2(TreeNode root) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        traverse(root, result);
	        return result;
	    }
	    // 把root为跟的preorder加入result里面
	    private void traverse(TreeNode root, ArrayList<Integer> result) {
	        if (root == null) {
	            return;
	        }

	        result.add(root.val);
	        traverse(root.left, result);
	        traverse(root.right, result);
	    }

	    
	 public static ArrayList<Integer> preorderTraversal3(TreeNode root) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        // null or leaf
	        if (root == null) {
	            return result;
	        }

	        // Divide
	        ArrayList<Integer> left = preorderTraversal3(root.left);
	        ArrayList<Integer> right = preorderTraversal3(root.right);

	        // Conquer
	        result.add(root.val);
	        result.addAll(left);
	        result.addAll(right);
	        return result;
	    }
	 public static void main(String args[]){
		 TreeNode root= new TreeNode(5);
		 TreeNode left= new TreeNode(3);
		 TreeNode right= new TreeNode(8);
		 root.left=left;
		 root.right=right;
		 preorderTraversal3(root);
	 }
}


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int x){
		this.val=x;
	}
}


