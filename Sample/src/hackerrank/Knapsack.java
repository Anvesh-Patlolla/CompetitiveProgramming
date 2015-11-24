package hackerrank;

import java.util.Scanner;

// Solution
public class Knapsack {

  public static void main(String[] args) {
    int[] list = null;
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      int N = sc.nextInt();
      int target = sc.nextInt();
      list = new int[N];
      for (int j = 0; j < N; j++) {
        list[j] = sc.nextInt();
      }
      int val = calculate(list, target);
      System.out.println(val);
    }
  }

  private static int calculate(int[] list, int target) {
    int size = list.length;
    int dp[] = new int[target + 1];
    dp[0] = 0;

    for (int i = 1; i < target + 1; i++) {
      int temp = 0, max = 0;
      for (int j = 0; j < size; j++) {

        if (i - list[j] >= 0) {
          temp = dp[i - list[j]] + list[j];
        }
        if (temp > max) {
          max = temp;
        }
      }
      dp[i] = max;
    }

    return dp[target];
  }
}
