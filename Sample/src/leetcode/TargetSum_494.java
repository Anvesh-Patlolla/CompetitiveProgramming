package leetcode;

public class TargetSum_494 {
	int counter = 0;

	public int findTargetSumWays(int[] nums, int S) {
		counter = 0;
		findTargetSumWays(nums, S, 0, 0);
		return counter;
	}

	private void findTargetSumWays(int[] nums, int s, int index, int sum) {
		if (nums.length == index) {
			if (s == sum) {
				counter++;
			}
			return;
		}
		findTargetSumWays(nums, s, index + 1, sum + nums[index]);
		findTargetSumWays(nums, s, index + 1, sum + -1 * nums[index]);

	}

}
