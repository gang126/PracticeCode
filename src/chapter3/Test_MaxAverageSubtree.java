package chapter3;

public class Test_MaxAverageSubtree {

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
		
	
		MaxAverageSubtree test=new MaxAverageSubtree();
		TreeNode subtree=test.findSubtree2(n1);
		System.out.println(subtree.val);
	}
}

