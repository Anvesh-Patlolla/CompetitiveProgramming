package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> retList = new ArrayList<>();
		binaryTreePaths(root, "", retList);
		return retList;
	}

	private void binaryTreePaths(TreeNode root, String string, List<String> retList) {
		if (root == null) {
			return;
		}

		if (isLeaf(root)) {
			string = string + root.val;
			retList.add(string);
		} else {
			binaryTreePaths(root.left, string + root.val + "->", retList);
			binaryTreePaths(root.right, string + root.val + "->", retList);
		}

	}

	private boolean isLeaf(TreeNode root) {
		if (root.left == null && root.right == null) {
			return true;
		} else {
			return false;
		}
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
