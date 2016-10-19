package coursera;

import java.util.HashMap;
import java.util.Map;

public class CountingGroups {

	static int island = 2;

	static int[] countGroups(int[][] m, int[] t) {
		island = 2;
		int retVal[] = new int[t.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				identify(m, i, j);
			}
		}

		HashMap<Integer, Integer> IslandSizeMap = new HashMap<>();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] >= 2) {
					int tempIsland = m[i][j];
					if (IslandSizeMap.containsKey(tempIsland)) {
						IslandSizeMap.put(tempIsland, IslandSizeMap.get(tempIsland) + 1);
					} else {
						IslandSizeMap.put(tempIsland, 1);
					}
				}
			}
		}

		HashMap<Integer, Integer> sizeCountMap = new HashMap<>();

		for (Map.Entry<Integer, Integer> entry : IslandSizeMap.entrySet()) {
			int size = entry.getValue();
			if (sizeCountMap.containsKey(size)) {
				sizeCountMap.put(size, sizeCountMap.get(size) + 1);
			} else {
				sizeCountMap.put(size, 1);
			}
		}
		for (int i = 0; i < t.length; i++) {
			retVal[i] = sizeCountMap.get(t[i]) != null ? sizeCountMap.get(t[i]) : 0;
		}

		// display(m);

		return retVal;
	}

	private static void display(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}

	}

	private static void identify(int[][] m, int i, int j) {
		if (m[i][j] == 0) {
			return;
		}
		if (i - 1 > -1) {
			if (m[i - 1][j] > 1) {
				m[i][j] = m[i - 1][j];
				return;
			}
		}
		if (j - 1 > -1) {
			if (m[i][j - 1] > 1) {
				m[i][j] = m[i][j - 1];
				return;
			}
		}
		if (i + 1 < m.length) {
			if (m[i + 1][j] > 1) {
				m[i][j] = m[i + 1][j];
				return;
			}
		}
		if (j + 1 < m.length) {
			if (m[i][j + 1] > 1) {
				m[i][j] = m[i][j + 1];
				return;
			}
		}
		m[i][j] = island;
		island++;
	}

	public static void main(String[] args) {
		// int[][] m = { { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0
		// }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 } };
		// int[] t = { 1, 2, 3, 4, 5 };
		int m[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 0, 0, 1, 1, 1 }, { 1, 1, 0, 0, 1, 0, 0, 1, 1, 1 }, { 1, 0, 1, 0, 0, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },

		};

		int t[] = { 1, 10, 20, 2, 6 };
		System.out.println(countGroups(m, t));
	}
}
