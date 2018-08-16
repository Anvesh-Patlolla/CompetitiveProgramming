package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Top_K_Frequent_Elements_347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}

		List<Pair> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Pair pair = new Pair(entry.getKey(), entry.getValue());
			list.add(pair);
		}
		list.sort(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.count < o2.count) {
					return 1;
				} else if (o1.count > o2.count) {
					return -1;
				} else
					return 0;
			}
		});
		List<Integer> retList = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			retList.add(list.get(i).key);
		}
		return retList;
	}

	private static class Pair {
		public Pair(Integer key2, Integer value) {
			key = key2;
			count = value;
		}

		public int key, count;
	}
}
