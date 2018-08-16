package leetcode;

import java.util.Stack;

public class Binary_Search_Tree_Iterator_173 {
	TreeNode current = null;
	Stack<TreeNode> stack = null;

	public void BSTIterator(TreeNode root) {
		current = root;
		stack = new Stack<>();
	}

	private int inorder() {
		//hasNext = false;
		int retVal = 0;
		if (!stack.isEmpty() || current != null) {
			//hasNext = true;
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			retVal = current.val;
			current = current.right;
		}
		return retVal;
	}

	/*
	 * @return
	 * 
	 * whether we have a next smallest number
	 */

	public boolean hasNext() {
		return !stack.isEmpty() || current != null;
	}

	/*
	 * @return
	 * 
	 * the next smallest number
	 */

	public int next() {
		return inorder();
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
