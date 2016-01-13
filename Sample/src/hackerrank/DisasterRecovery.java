package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// Solution
public class DisasterRecovery {

  static int N = 0;
  static int arr[] = null;
  static long dp[][] = null;
  static long counterDP[][] = null;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = (sc.nextInt());
    arr = new int[N];
    dp = new long[N][N];
    counterDP = new long[N][N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }
    // String costs = inputFromKeyboard();
    // int count = 0;
    // for (String s : costs.split(" ")) {
    // arr[count] = Integer.parseInt(s);
    // count++;
    // }
    long retVal = calculate();
    System.out.println(retVal);
  }

  private static long calculate() {
    int counter = 1;
    return dynamicCalculate(0, N - 1, counter);
  }

  private static long dynamicCalculate(int i, int j, int counter) {

    if (i == j) {
      dp[i][j] = counter * arr[i];
      counterDP[i][j] = counter;
      return dp[i][j];
    }

    if (dp[i][j] != 0) {
      return dp[i][j];
    }
    long left = arr[i] * counter + dynamicCalculate(i + 1, j, counter + 1);
    long right = arr[j] * counter + dynamicCalculate(i, j - 1, counter + 1);
    if (left > right) {
      dp[i][j] = right;
    } else {
      dp[i][j] = left;
    }
    counterDP[i][j] = counter;
    return dp[i][j];

  }

  public static String inputFromKeyboard() {
    InputStreamReader in = null;
    in = new InputStreamReader(System.in);

    BufferedReader br = new BufferedReader(in);
    String s = null;
    try {
      s = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
      try {
        br.close();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }
    return s;
  }

}
