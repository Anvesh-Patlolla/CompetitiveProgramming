package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {
	List<List<Integer>> retList = null;

	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		retList = new ArrayList<>();
		ArrayList<Integer> li = new ArrayList<>();
		calculate(nums, 0, li);
		return retList;
	}

	private void calculate(int[] nums, int i, ArrayList<Integer> li) {

		ArrayList<Integer> dup = new ArrayList<>(li);
		retList.add(dup);
		if (nums.length == i) {
			return;
		}
		for (int j = i; j < nums.length; j++) {
			li.add(nums[j]);
			calculate(nums, j + 1, li);
			li.remove(li.size() - 1);
		}

	}

	public static void main(String[] args) {
		Subsets_78 obj = new Subsets_78();
		int[] nums = { 1, 3, 4, 2 };
		List<List<Integer>> subsets = obj.subsets(nums);
		System.out.println(subsets);
	}
}
