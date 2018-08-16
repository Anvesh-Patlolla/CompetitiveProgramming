package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Frog_Jump_403 {
	public static void main(String[] args) {
		Frog_Jump_403 obj = new Frog_Jump_403();
		int[] stones = { 0, 1, 2, 3, 4, 8, 9, 11 };
		System.out.println(obj.canCross(stones));
	}

	private static Map<Integer, Set<Integer>> failedSteps;

	private static HashMap<Integer, Integer> stonePositions;

	public boolean canCross(int[] stones) {
		failedSteps = new HashMap<>();
		stonePositions = new HashMap<>();
		for (int i = 0; i < stones.length; i++) {
			stonePositions.put(stones[i], i);
		}
		return calculate(0, 0, stones);

	}

	private boolean calculate(int currentStoneIndex, int previousJumpLength, int[] stones) {
		if (currentStoneIndex == stones.length - 1) {
			return true;
		}
		// System.out.println(String.format("currentStoneIndex %s,
		// currentPosition %s previousJumpLength %s ",
		// currentStoneIndex, stones[currentStoneIndex], previousJumpLength));
		int currentStonePosition = stones[currentStoneIndex];
		if (!failedSteps.containsKey(currentStonePosition)) {
			failedSteps.put(currentStonePosition, new HashSet<>());
		}
		Set<Integer> failed = failedSteps.get(currentStonePosition);

		boolean retVal = false;
		for (int i = -1; i < 2; i++) {
			int currentJumpLength = previousJumpLength + i;
			if (!failed.contains(previousJumpLength) && (currentJumpLength) > 0
					&& stonePositions.containsKey(currentStonePosition + currentJumpLength)) {
				retVal |= calculate(stonePositions.get(currentStonePosition + currentJumpLength), currentJumpLength,
						stones);
			}
			if (retVal) {
				return true;
			}
		}
		failed.add(previousJumpLength);

		return retVal;
	}
}
