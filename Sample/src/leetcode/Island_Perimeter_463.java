package leetcode;

public class Island_Perimeter_463 {
	public int islandPerimeter(int[][] grid) {
		int neighbours = 0;
		int totalIslands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] != 0) {
					totalIslands++;
					if (i + 1 < grid.length && grid[i + 1][j] == 1) {
						neighbours++;
					}
					if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
						neighbours++;
					}

				}
			}
		}
		return totalIslands * 4 - neighbours * 2;
	}

	public static void main(String[] args) {
		Island_Perimeter_463 obj = new Island_Perimeter_463();
		int array[][] = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(obj.islandPerimeter(array));
	}
}
