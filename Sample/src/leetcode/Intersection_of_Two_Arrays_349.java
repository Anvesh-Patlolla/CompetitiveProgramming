package leetcode;

import java.util.HashSet;

public class Intersection_of_Two_Arrays_349 {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		HashSet<Integer> retSet = new HashSet<>();
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				retSet.add(nums2[i]);
			}
		}
		int retArray[] = new int[retSet.size()];
		int index = 0;
		for (int i : retSet) {
			retArray[index] = i;
			index++;
		}

		return retArray;
	}
}
