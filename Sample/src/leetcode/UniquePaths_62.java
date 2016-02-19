package leetcode;

public class UniquePaths_62 {
  int[][] dp = null;

  public int uniquePaths(int m, int n) {

    dp = new int[m][n];
    int retVal = calculate(m, n);
    return retVal;
  }

  private int calculate(int m, int n) {
    if (m == 0 && n == 0) {
      return 0;
    }
    if (m == 0 || n == 0) {
      return 1;
    }
    if (dp[m][n] != 0) {
      return dp[m][n];
    }
    int retVal = calculate(m - 1, n) + calculate(m - 1, n - 1) + calculate(m, n - 1);
    dp[m][n] = retVal;
    return retVal;
  }

  public static void main(String[] args) {

  }
}
