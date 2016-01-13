package madhu.aerospike;

public class NoOfPaths {
  public static void main(String[] args) {
    int[][] arr = { {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
    int[][] arr2 = { {1, 1}, {0, 1}};
    System.out.println(numberOfPaths(arr2, 2, 2));
  }

  static int counter = 0;
  static int div = 1000000007;

  static int numberOfPaths(int[][] a, int M, int N) {
    countPaths(a, 0, 0, M, N);
    return counter;
  }

  private static void countPaths(int[][] a, int i, int j, int m, int n) {
    if (i >= m || j >= n || a[i][j] == 0) {
      return;
    }
    if (i == m - 1 && j == n - 1) {
      counter++;
      counter = counter % div;
      return;
    }
    countPaths(a, i + 1, j, m, n);
    countPaths(a, i, j + 1, m, n);
    return;
  }
}
