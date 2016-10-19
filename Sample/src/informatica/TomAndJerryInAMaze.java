package informatica;

public class TomAndJerryInAMaze {
	static int cheeseCount = 0;
	static int rows = 0, columns = 0;

	static int dp[][][] = null;

	static int minMoves(int[][] maze, int x, int y) {
		cheeseCount = 0;
		rows = maze.length;
		columns = maze[0].length;
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[i][j] == 2) {
					cheeseCount++;
					// boolean val = verifyPossible(maze, i, j);
					// if (val == false) {
					// return -1;
					// }
				}
			}
		}

		dp = new int[maze.length][maze[0].length][cheeseCount];
		// for (int i = 0; i < maze.length; i++) {
		// for (int j = 0; j < maze[0].length; j++) {
		// dp[i][j] = -10;
		// }
		// }
		int backtrack = backtrack(maze, 0, 0, x, y, 0, 0);
		if (backtrack == Integer.MAX_VALUE) {
			return -1;
		} else {
			return backtrack;
		}
	}

	private static boolean verifyPossible(int[][] maze, int x, int y) {
		boolean possible = false;

		if (x + 1 < rows) {
			if (maze[x + 1][y] == 0 || maze[x + 1][y] == 2) {
				possible |= true;
			}
		}
		if (y + 1 < columns) {
			if (maze[x][y + 1] == 0 || maze[x][y + 1] == 2) {
				possible |= true;
			}
		}
		if (x - 1 > -1) {
			if (maze[x - 1][y] == 0 || maze[x - 1][y] == 2) {
				possible |= true;
			}
		}
		if (y - 1 > -1) {
			if (maze[x][y - 1] == 0 || maze[x][y - 1] == 2) {
				possible |= true;
			}
		}
		return possible;
	}

	private static int backtrack(int[][] maze, int currentX, int currentY, int x, int y, int currentCheeseCount,
			int steps) {
		if (dp[currentX][currentY][currentCheeseCount] != 0) {

			return steps + dp[currentX][currentY][currentCheeseCount];
		}
		if (steps > 1000) {
			return Integer.MAX_VALUE;
		}
		if (currentX == x && currentY == y) {

			if (maze[currentX][currentY] == 2) {
				currentCheeseCount++;
			}

			if (cheeseCount == currentCheeseCount) {
				return steps;
			} else {
				return Integer.MAX_VALUE;
			}
		}

		if (maze[currentX][currentY] == 2) {
			currentCheeseCount++;
		}

		int cVal = maze[currentX][currentY];
		// maze[currentX][currentY] = 4;
		int retVal = Integer.MAX_VALUE;

		if (currentX + 1 < rows && (maze[currentX + 1][currentY] == 0 || maze[currentX + 1][currentY] == 2)
				&& maze[currentX + 1][currentY] != 4) {
			int temp = backtrack(maze, currentX + 1, currentY, x, y, currentCheeseCount, steps + 1);
			if (temp < retVal) {
				retVal = temp;
			}
		}
		if (currentX - 1 > -1 && (maze[currentX - 1][currentY] == 0 || maze[currentX - 1][currentY] == 2)
				&& maze[currentX - 1][currentY] != 4) {
			int temp = backtrack(maze, currentX - 1, currentY, x, y, currentCheeseCount, steps + 1);
			if (temp < retVal) {
				retVal = temp;
			}
		}
		if (currentY + 1 < columns && (maze[currentX][currentY + 1] == 0 || maze[currentX][currentY + 1] == 2)
				&& maze[currentX][currentY + 1] != 4) {
			int temp = backtrack(maze, currentX, currentY + 1, x, y, currentCheeseCount, steps + 1);
			if (temp < retVal) {
				retVal = temp;
			}
		}
		if (currentY - 1 > -1 && (maze[currentX][currentY - 1] == 0 || maze[currentX][currentY - 1] == 2)
				&& maze[currentX][currentY - 1] != 4) {
			int temp = backtrack(maze, currentX, currentY - 1, x, y, currentCheeseCount, steps + 1);
			if (temp < retVal) {
				retVal = temp;
			}
		}
		// maze[currentX][currentY] = cVal;
		dp[currentX][currentY][currentCheeseCount] = retVal;
		return retVal;
	}

	public static void main(String[] args) {
		int[][] maze = { { 0, 2, 0 }, { 1, 1, 2 }, { 1, 0, 0 } };
		System.out.println(minMoves(maze, 2, 1));
	}
}
