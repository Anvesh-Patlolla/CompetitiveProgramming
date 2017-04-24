package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_107 {
	HashMap<Integer, List<Integer>> map = null;

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		map = new HashMap<>();
		int height = getHeight(root);
		levelOrderBottom(root, 0);
		List<List<Integer>> retList = new ArrayList<>();
		for (int i = height - 1; i >= 0; i--) {
			retList.add(map.get(i));
		}
		return retList;
	}

	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = getHeight(root.left);
		int right = getHeight(root.right);

		return left > right ? left + 1 : right + 1;
	}

	private void levelOrderBottom(TreeNode root, int depth) {
		if (root == null) {
			return;
		}
		if (map.containsKey(depth)) {
			List<Integer> list = map.get(depth);
			list.add(root.val);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			map.put(depth, list);
		}
		levelOrderBottom(root.left, depth + 1);
		levelOrderBottom(root.right, depth + 1);
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
