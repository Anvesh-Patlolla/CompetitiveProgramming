package leetcode;

public class Move_Zeros283 {
	public void moveZeroes(int[] nums) {
		int firstPointer = 0;
		int secondPointer = 0;
		for (; secondPointer < nums.length; secondPointer++) {
			if (nums[secondPointer] != 0) {
				nums[firstPointer] = nums[secondPointer];
				firstPointer++;
			}
		}
		for (; firstPointer < nums.length; firstPointer++) {
			nums[firstPointer] = 0;
		}
	}
}
