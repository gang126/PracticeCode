package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import chapter3.TreeNode;

public class BFS {

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
		ArrayList<ArrayList<Integer>> results= levelOrder(n1);
		for(ArrayList<Integer> xx : results){
			System.out.print(xx);
		}
	}
	
	 public static  ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	        ArrayList result = new ArrayList();

	        if (root == null) {
	            return result;
	        }

	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);

	        while (!queue.isEmpty()) {
	            ArrayList<Integer> level = new ArrayList<Integer>();
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                TreeNode head = queue.poll();
	                level.add(head.val);
	                if (head.left != null) {
	                    queue.offer(head.left);
	                }
	                if (head.right != null) {
	                    queue.offer(head.right);
	                }
	            }
	            result.add(level);
	        }

	        return result;
	    }

}
