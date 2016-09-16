package leetcode;

import java.util.ArrayList;

public class TwoAdjacentDigitsReplaceWithSmallNumber {

	public int solution(int X) {
		ArrayList<Integer> list = new ArrayList<>();
		list = populate(X, list);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size() - 1; i++) {
			int val = generateNumber(list, i);
			if (min > val) {
				min = val;
			}
		}
		return min;
	}

	private int generateNumber(ArrayList<Integer> list, int index) {
		int retVal = 0;
		for (int i = 0; i < list.size(); i++) {

			if (i == index) {
				int max = Math.max(list.get(i), list.get(i + 1));
				retVal = retVal * 10 + max;
			} else if (i == index + 1) {
				continue;
			} else {
				retVal = retVal * 10 + list.get(i);
			}

		}
		return retVal;
	}

	private ArrayList<Integer> populate(int x, ArrayList<Integer> list) {
		while (x != 0) {
			list.add(x % 10);
			x /= 10;
		}
		ArrayList<Integer> list2 = new ArrayList<>();
		for (int i = list.size() - 1; i > -1; i--) {
			list2.add(list.get(i));
		}

		return list2;

	}

	public static void main(String[] args) {
		TwoAdjacentDigitsReplaceWithSmallNumber adj = new TwoAdjacentDigitsReplaceWithSmallNumber();
		System.out.println(adj.solution(233614));
	}
}
