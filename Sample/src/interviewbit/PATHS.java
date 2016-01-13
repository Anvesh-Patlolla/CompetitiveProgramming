package interviewbit;

public class PATHS {
  int dp[][] = null;

  public int uniquePaths(int a, int b) {
    dp = new int[a][b];
    for (int i = 0; i < a; i++) {
      for (int j = 0; j < b; j++) {
        dp[i][j] = -1;
      }
    }
    return calculate(a - 1, b - 1);
  }

  private int calculate(int a, int b) {
    if (a == 0 && b == 0) {
      return 1;
    }
    if (a < 0 || b < 0) {
      return 0;
    }
    if (dp[a][b] != -1) {
      return dp[a][b];
    }
    int l = calculate(a - 1, b);
    int r = calculate(a, b - 1);
    dp[a][b] = l + r;
    return dp[a][b];

  }

  public static void main(String[] args) {
    PATHS obj = new PATHS();
    System.out.println(obj.uniquePaths(3, 2));
  }
}
