package leetcode;

import java.util.HashMap;

public class Hand_of_Straights_846 {
	public boolean isNStraightHand(int[] hand, int W) {
		if (hand == null || hand.length == 0) {
			return false;
		}
		if (hand.length % W != 0) {
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : hand) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		// TODO:

		return hand.length % W == 0;
	}

	private static class Pair {
		int key;
		int frequency;
	}

}
