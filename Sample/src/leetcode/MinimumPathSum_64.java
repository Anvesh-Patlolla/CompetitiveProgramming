package leetcode;

public class MinimumPathSum_64 {
	public int minPathSum(int[][] grid) {
		if (grid == null) {
			return 0;
		}
		int sum[][] = new int[grid.length][grid[0].length];
		int rows = grid.length;
		int cols = grid[0].length;
		sum[0][0] = grid[0][0];
		for (int i = 1; i < rows; i++) {
			sum[i][0] = sum[i - 1][0] + grid[i][0];
		}
		for (int j = 1; j < cols; j++) {
			sum[0][j] = sum[0][j - 1] + grid[0][j];
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {

				int left = sum[i - 1][j];
				int top = sum[i][j - 1];
				int addition = left > top ? top : left;
				sum[i][j] = grid[i][j] + addition;

			}
		}
		return sum[rows - 1][cols - 1];
	}

	public static void main(String[] args) {
		MinimumPathSum_64 obj = new MinimumPathSum_64();
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(obj.minPathSum(grid));
	}
}
