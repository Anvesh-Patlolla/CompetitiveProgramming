package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Find_All_Numbers_Disappeared_in_an_Array_448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<Integer>();
		}
		List<Integer> retList = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		for (int i = 1; i <= nums.length; i++) {
			if (!set.contains(i)) {
				retList.add(i);
			}
		}
		return retList;
	}

	public static void main(String[] args) {
		Find_All_Numbers_Disappeared_in_an_Array_448 obj = new Find_All_Numbers_Disappeared_in_an_Array_448();
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(obj.findDisappearedNumbers(nums));
	}
}
