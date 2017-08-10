package chapter3;

import java.util.ArrayList;
import java.util.List;

public class Paths {
	/*给一棵二叉树，找出从根节点到叶子节点的所有路径。
	 * http://www.lintcode.com/zh-cn/problem/binary-tree-paths/
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 =new TreeNode(1);
		TreeNode n2 =new TreeNode(2);
		TreeNode n3 =new TreeNode(3);
		
		/*TreeNode n4 =new TreeNode(4);
		TreeNode n5 =new TreeNode(5);*/
		
		n1.left=n2;
		n1.right=n3;
	
		/*n2.left=n4;
		n2.right=n5;*/
		
		ArrayList<String> results= traverse(n1);
		for(String xx : results){
			System.out.println(xx.toString());
		}
	}
	
	//divide && conquer
	public static ArrayList<String> binaryTreePaths(TreeNode root) {
		ArrayList<String> paths = new ArrayList<String>();
        if (root == null) {
            return paths;
        }
        
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }
        
       // root is a leaf
        //root.left == null || root.right==null
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }
        
        return paths;
    }

	//traverse
	public static  ArrayList<String> traverse(TreeNode root) {
		ArrayList<String> results =new ArrayList<String>();
		helper(root, String.valueOf(root.val), results);
		
		return results;
	}
	
	public static void helper(TreeNode root, String path,ArrayList<String> resutls){
		if(root == null){
			return;
		}
		if(root.left == null || root.right == null){
			resutls.add(path);
			return;
		}
		
		helper(root.left, path+"-->"+String.valueOf(root.left.val), resutls);
		helper(root.right, path+"-->"+String.valueOf(root.right.val), resutls);
	}
}
