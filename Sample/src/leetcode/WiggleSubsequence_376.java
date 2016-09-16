package leetcode;

public class WiggleSubsequence_376 {

	public int wiggleMaxLength(int[] nums) {
		// [1,17,5,10,13,15,10,5,16,8]
		nums = wrapper(nums);
		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}

		int count = 1;

		int previous = nums[0];

		boolean nextGreater = nums[1] > previous;

		for (int i = 1; i < nums.length; i++) {
			if (nextGreater) {
				if (nums[i] > previous) {
					count++;
					nextGreater = false;
				}
			} else {
				if (nums[i] < previous) {
					count++;
					nextGreater = true;
				}
			}
			previous = nums[i];
		}
		return count;
	}

	int[] wrapper(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		if (nums[0] != nums[1]) {
			return nums;
		}
		int i = 0;
		for (; i < nums.length; i++) {
			if (nums[i] != nums[i + 1]) {
				break;
			}

		}
		int retArray[] = new int[nums.length - i];
		for (int j = 0; j < retArray.length; j++, i++) {
			retArray[j] = nums[i];
		}
		return retArray;
	}

	public static void main(String[] args) {
		WiggleSubsequence_376 obj = new WiggleSubsequence_376();
		int[] nums = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		System.out.println(obj.wiggleMaxLength(nums));// 7
		int nums2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(obj.wiggleMaxLength(nums2));// 2
		int nums3[] = { 1, 7, 4, 9, 2, 5 };
		System.out.println(obj.wiggleMaxLength(nums3));// 6

		int nums4[] = { 1, 1, 7, 4, 9, 2, 5 };
		System.out.println(obj.wiggleMaxLength(nums4));// 6
	}
}
