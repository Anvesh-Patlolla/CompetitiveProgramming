package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_Sorted_Array_88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(2, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2) {
					return 1;
				} else if (o1 < o2) {
					return -1;
				}
				return 0;
			}
		});
		for (int i = 0; i < m; i++) {
			queue.add(nums1[i]);
		}
		for (int i = 0; i < n; i++) {
			queue.add(nums2[i]);
		}
		for (int i = 0; queue.isEmpty() == false; i++) {
			nums1[i] = queue.poll();
		}
	}
}
