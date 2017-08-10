package chapter3;

public class MinimumSubtree {

	public static void main(String[] args) {
		// http://www.lintcode.com/zh-cn/problem/minimum-subtree/
		TreeNode n1 =new TreeNode(1);
		TreeNode n2 =new TreeNode(-5);
		TreeNode n3 =new TreeNode(2);
		TreeNode n4 =new TreeNode(0);
		TreeNode n5 =new TreeNode(2);
		TreeNode n6 =new TreeNode(-4);
		TreeNode n7 =new TreeNode(-5);
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		n3.left=n6;
		n3.right=n7;
		
		MinimumSubtree clazz=new MinimumSubtree();
		TreeNode n= clazz.findSubtree(n1);
		System.out.println(n.val);
	}
	//divide && conquer + traverse
	TreeNode subtree;
	int maxSum= Integer.MAX_VALUE;
	public TreeNode findSubtree(TreeNode root){
		subtree =null;
		helper(root);
		return subtree;
	}
	
	public int helper(TreeNode root){
		if(root == null){
			return 0;
		}
		//divide && conquer
		int sum= helper(root.left)+ helper(root.right) + root.val;
		//traverse
		if(sum<maxSum){
			maxSum=sum;
			subtree=root;
		}
		return sum;
	}
}
