package leetcode;

public class Move_Zeroes_283 {
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		/*
		 * int zeros = 0; for (int i = 0; i < nums.length; i++) { if (nums[i] ==
		 * 0) { zeros++; } }
		 */ int zerosEncountered = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zerosEncountered++;
			} else {
				nums[i - zerosEncountered] = nums[i];
			}
		}
		for (int i = nums.length - zerosEncountered; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
