package leetcode;

public class NumberofIslands_200 {

	int rows = 0;
	int columns = 0;
	private static final char VISITED = 'V';

	public int numIslands(char[][] grid) {
		if (grid == null || (grid.length == 0)) {
			return 0;
		}
		rows = grid.length;
		columns = grid[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] != '0' && grid[i][j] != VISITED) {
					dfs(grid, i, j);
					island++;
				}
			}
		}
		return island;
	}

	private void dfs(char[][] grid, int i, int j) {
		if (grid[i][j] == '0' || grid[i][j] == VISITED) {
			return;
		}
		grid[i][j] = VISITED;
		if (i + 1 < rows) {
			dfs(grid, i + 1, j);
		}
		if (i - 1 > -1) {
			dfs(grid, i - 1, j);
		}
		if (j + 1 < columns) {
			dfs(grid, i, j + 1);
		}
		if (j - 1 > -1) {
			dfs(grid, i, j - 1);
		}
	}

	int island = 0;

	public static void main(String[] args) {
		NumberofIslands_200 obj1 = new NumberofIslands_200();
		char[][] grid = { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1' } };
		System.out.println(obj1.numIslands(grid));
	}
}
