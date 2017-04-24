package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindModeinBinarySearchTree_501 {
	HashMap<Integer, Integer> map = null;

	public int[] findMode(TreeNode root) {
		map = new HashMap<>();
		findModeTree(root);
		int currentMode = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int value = entry.getKey();
			int mode = entry.getValue();
			if (mode > currentMode) {
				list = new ArrayList<>();
				list.add(value);
				currentMode = mode;
			} else if (mode == currentMode) {
				list.add(value);
			}
		}
		int retVal[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			retVal[i] = list.get(i);
		}
		return retVal;
	}

	private void findModeTree(TreeNode root) {
		if (root == null) {
			return;
		}
		int val = root.val;
		if (map.containsKey(val)) {
			map.put(val, map.get(val) + 1);
		} else {
			map.put(val, 1);
		}
		findModeTree(root.right);
		findModeTree(root.left);
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
