package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindLargestValueinEachTreeRow_515 {
	public List<Integer> largestValues(TreeNode root) {
		HashMap<Integer, Integer> map = new HashMap<>();
		largestValues(root, map, 0);
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0;; i++) {
			if (!map.containsKey(i)) {
				break;
			}
			list.add(map.get(i));
		}
		return list;
	}

	private void largestValues(TreeNode root, HashMap<Integer, Integer> map, int level) {
		if (root == null) {
			return;
		}
		int value = root.val;
		if (map.containsKey(level)) {
			int max = map.get(level);
			if (max < value) {
				map.put(level, value);
			}
		} else {
			map.put(level, value);
		}

		largestValues(root.left, map, level + 1);
		largestValues(root.right, map, level + 1);

	}
}
