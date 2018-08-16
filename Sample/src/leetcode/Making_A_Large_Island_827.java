package leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Making_A_Large_Island_827 {

	int currentIslandId = 1;
	HashMap<Integer, Integer> islandSizeMap = null;
	HashSet<Pair> zeroCordinates = null;

	public int largestIsland(int[][] grid) {
		currentIslandId = 1;
		islandSizeMap = new HashMap<>();
		zeroCordinates = new HashSet<>();
		int retVal = markIslands(grid);
		return retVal != 0 ? retVal : grid.length * grid[0].length;

	}

	private int markIslands(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					zeroCordinates.add(new Pair(i, j));
				} else if (grid[i][j] == 1) {
					markNewIsland(grid, i, j);
				}
			}
		}
		int maxSum = 0;
		for (Pair zeroCordinate : zeroCordinates) {
			Set<Integer> neighboursIslandId = new HashSet<>();
			int x = zeroCordinate.x;
			int y = zeroCordinate.y;
			if (x - 1 > -1) {
				neighboursIslandId.add(grid[x - 1][y]);
			}
			if (y - 1 > -1) {
				neighboursIslandId.add(grid[x][y - 1]);
			}
			if (x + 1 < grid.length) {
				neighboursIslandId.add(grid[x + 1][y]);
			}
			if (y + 1 < grid[0].length) {
				neighboursIslandId.add(grid[x][y + 1]);
			}
			int sum = 1;
			for (Integer neighbour : neighboursIslandId) {
				sum += islandSizeMap.getOrDefault(neighbour, 0);
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}

	private void markNewIsland(int[][] grid, int x, int y) {
		currentIslandId++;
		int newIslandId = currentIslandId;
		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(x, y));
		while (!queue.isEmpty()) {
			Pair head = queue.poll();
			if (grid[head.x][head.y] == 1) {
				grid[head.x][head.y] = newIslandId;
				Integer size = islandSizeMap.getOrDefault(newIslandId, 0);
				islandSizeMap.put(newIslandId, size + 1);
			}
			if (head.x + 1 < grid.length && grid[head.x + 1][head.y] == 1) {
				queue.add(new Pair(head.x + 1, head.y));
			}
			if (head.y + 1 < grid[0].length && grid[head.x][head.y + 1] == 1) {
				queue.add(new Pair(head.x, head.y + 1));
			}
			if (head.x - 1 > -1 && grid[head.x - 1][head.y] == 1) {
				queue.add(new Pair(head.x - 1, head.y));
			}
			if (head.y - 1 > -1 && grid[head.x][head.y - 1] == 1) {
				queue.add(new Pair(head.x, head.y - 1));
			}
		}

	}

	private static class Pair {
		int x, y;

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Making_A_Large_Island_827 obj = new Making_A_Large_Island_827();
		int[][] grid = { { 1, 0, 0, 1, 1 }, { 1, 0, 0, 1, 0 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 1, 0 } };
		System.out.println(obj.largestIsland(grid));
	}
}
