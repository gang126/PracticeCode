package chapter3;

public class MaxAverageSubtree {

	private class ResultType {
        public int sum, size;
        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }
    
    private TreeNode subtree = null;
    private ResultType subtreeResult = null;
    
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return subtree;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType result = new ResultType(
            left.sum + right.sum + root.val,
            left.size + right.size + 1
        );
        
        if (subtree == null ||
            subtreeResult.sum * result.size < result.sum * subtreeResult.size
        ) {
            subtree = root;
            subtreeResult = result;
        }
        return result;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 =new TreeNode(1);
		TreeNode n2 =new TreeNode(-5);
		TreeNode n3 =new TreeNode(11);
		TreeNode n4 =new TreeNode(1);
		TreeNode n5 =new TreeNode(2);
		TreeNode n6 =new TreeNode(4);
		TreeNode n7 =new TreeNode(-2);
		
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		n3.left=n6;
		n3.right=n7;
		
	
		System.out.print("");
	}
}

