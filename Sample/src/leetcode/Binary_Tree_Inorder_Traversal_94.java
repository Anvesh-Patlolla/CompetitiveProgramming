package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal_94 {
	static List<Integer> retList = null;

	//
	// public List<Integer> inorderTraversal(TreeNode root) {
	// retList = new ArrayList<>();
	// inorder(root);
	// return retList;
	// }
	//
	// private void inorder(TreeNode root) {
	// if (root == null) {
	// return;
	// }
	// inorder(root.left);
	// retList.add(root.val);
	// inorder(root.right);
	//
	// }

	public List<Integer> inorderTraversal(TreeNode root) {

		retList = new ArrayList<>();
		if (root == null) {
			return retList;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			retList.add(current.val);
			current = current.right;

		}
		return retList;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
