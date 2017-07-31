package binarytree;

public class MaxDepth {
	
	 public static void main(String args[]){
		 TreeNode root= new TreeNode(1);
		 TreeNode n2= new TreeNode(2);
		 TreeNode n3= new TreeNode(3);
		 TreeNode n4= new TreeNode(4);
		 TreeNode n5= new TreeNode(5);
		 root.left=n2;
		 root.right=n3;
		 n3.left=n4;
		 n3.right=n5;
		 
		 System.out.println(maxDepth2(root));
	 }
	 	private int depth;
	 // version 2: Traverse
	    public int maxDepth(TreeNode root) {
	        depth = 0;
	        helper(root, 1);
	        
	        return depth;
	    }
	    
	    private void helper(TreeNode node, int curtDepth) {
	        if (node == null) {
	            return;
	        }
	        
	        if (curtDepth > depth) {
	            depth = curtDepth;
	        }
	        
	        helper(node.left, curtDepth + 1);
	        helper(node.right, curtDepth + 1);
	    }
	 // Version 1: Divide Conquer
	    public static int maxDepth2(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }

	        int left = maxDepth2(root.left);
	        int right = maxDepth2(root.right);
	        return Math.max(left, right) + 1;
	    }


}
