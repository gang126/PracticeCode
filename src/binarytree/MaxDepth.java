package binarytree;

public class MaxDepth {
	 	private int depth;
	    
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

}
