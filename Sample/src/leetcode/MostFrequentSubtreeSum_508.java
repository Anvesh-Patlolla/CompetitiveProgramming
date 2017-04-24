package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubtreeSum_508 {
	HashMap<Integer, Integer> map = null;

	public int[] findFrequentTreeSum(TreeNode root) {
		map = new HashMap<>();
		subtreeSum(root, map);
		ArrayList<Integer> list = new ArrayList<>();
		int currentFrequency = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int frequency = entry.getValue();
			int key = entry.getKey();
			if (currentFrequency == frequency) {
				list.add(key);
			} else if (currentFrequency < frequency) {
				list = new ArrayList<>();
				list.add(key);
				currentFrequency = frequency;
			}

		}
		int retList[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			retList[i] = list.get(i);
		}
		return retList;
	}

	private int subtreeSum(TreeNode root, HashMap<Integer, Integer> map2) {
		if (root == null) {
			return 0;
		}
		int left = subtreeSum(root.left, map2);
		int right = subtreeSum(root.right, map2);
		int retVal = left + right + root.val;
		if (map2.containsKey(retVal)) {
			Integer value = map2.get(retVal);
			map2.put(retVal, value + 1);
		} else {
			map2.put(retVal, 1);
		}
		return retVal;

	}

}
