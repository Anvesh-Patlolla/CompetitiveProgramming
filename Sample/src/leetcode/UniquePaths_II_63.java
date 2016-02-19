package leetcode;

public class UniquePaths_II_63 {
  int[][] dp = null;

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    dp = new int[obstacleGrid.length][obstacleGrid[0].length];
    int retVal = calculate(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    return retVal;
  }

  private int calculate(int[][] obstacleGrid, int m, int n) {
    if (m < 0 || n < 0) {
      return 0;
    }
    if (obstacleGrid[m][n] == 1) {
      return 0;
    }

    if (m == 0 && n == 0) {
      return 1;
    }
    /*
     * if (m == 0 || n == 0) { return 1; }
     */
    if (dp[m][n] != 0) {
      return dp[m][n];
    }
    int retVal = 0;
    retVal = calculate(obstacleGrid, m - 1, n) + calculate(obstacleGrid, m, n - 1);
    dp[m][n] = retVal;
    return retVal;
  }

  public static void main(String[] args) {
    UniquePaths_II_63 obj = new UniquePaths_II_63();
    int[][] obstacleGrid = {{1, 0}};
    System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
  }
}
