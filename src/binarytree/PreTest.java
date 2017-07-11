package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreTest {
	public List<Integer> method1(TreeNode root){
		List<Integer> list =new ArrayList<Integer>();
		Stack<TreeNode> stack =new Stack<TreeNode>();
		
		if(root == null){
			return list;
		}
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node =stack.pop();
			list.add(node.val);
			if(node.right!=null){
				stack.push(node.right);
			}
			if(node.left!=null){
				stack.push(node.left);
			}
		}
		
		return list;
	}
	
	public List<Integer> method2 (TreeNode root){
		List<Integer> list =new ArrayList<Integer>();
		
		traverse(root, list);
		
		return list;
	}
	
	public void traverse(TreeNode root, List<Integer> list){
		if(root == null){
			return;
		}
		
		list.add(root.val);
		traverse(root.left, list);
		traverse(root.right, list);
	}
	
	public List<Integer> method3 (TreeNode root){
		List<Integer> list =new ArrayList<Integer>();
		
		if(root == null){
			return list;
		}
		
		List<Integer> left= method3(root.left);
		List<Integer> right= method3(root.right);
		
		list.add(root.val);
		list.addAll(left);
		list.addAll(right);
		return list;
	}
}
