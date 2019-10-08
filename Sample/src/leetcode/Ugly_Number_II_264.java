package leetcode;

import java.util.ArrayList;

public class Ugly_Number_II_264 {
	public int nthUglyNumber(int n) {
		// 1, 2, 3, 4, 5, 6, 8, 9, 10, 12
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);

		if (list.size() >= n) {
			return list.get(n - 1);
		}
		Pair[] pairList = new Pair[3];

		pairList[0] = new Pair(2, 0, 1 * 2);
		pairList[1] = new Pair(3, 0, 1 * 3);
		pairList[2] = new Pair(5, 0, 1 * 5);
		for (int i = 0; list.size() <= n; i++) {
			int min = Integer.MAX_VALUE;
			int min_index = -1;
			for (int j = 0; j < 3; j++) {
				if (min > pairList[j].nextVal) {
					min = pairList[j].nextVal;
					min_index = j;
				}
			}
			if (pairList[min_index].nextVal != list.get(list.size() - 1)) {
				list.add(pairList[min_index].nextVal);
			}
			pairList[min_index].index++;
			pairList[min_index].nextVal = list.get(pairList[min_index].index)
					* pairList[min_index].multiplicativeFactor;

		}
		// System.out.println(list);
		return list.get(n - 1);
	}

	class Pair {
		int multiplicativeFactor;
		int index;
		int nextVal;

		Pair(int multiplicativeFactor, int index, int nextVal) {
			this.multiplicativeFactor = multiplicativeFactor;
			this.index = index;
			this.nextVal = nextVal;
		}
	}

	public static void main(String[] args) {
		Ugly_Number_II_264 obj = new Ugly_Number_II_264();
		System.out.println(obj.nthUglyNumber(10));
	}
}
