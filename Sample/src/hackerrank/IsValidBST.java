package hackerrank;

import java.util.Scanner;

public class IsValidBST {

  public static void main(String[] args) {
    int N = 0, nodes = 0;
    int arr[] = null;
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    for (int T = 0; T < N; T++) {
      nodes = sc.nextInt();
      arr = new int[nodes];
      for (int i = 0; i < nodes; i++) {
        arr[i] = sc.nextInt();
      }
      boolean retVal = calculate(arr, 0, arr.length, Integer.MAX_VALUE, Integer.MIN_VALUE);
      if (retVal) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  private static boolean calculate(int[] arr, int start, int end, int maxValue, int minValue) {
    if (start >= end) {
      return true;
    }

    if (start == end - 1) {
      if (arr[start] > minValue && arr[start] < maxValue) {
        return true;
      } else {
        return false;
      }
    }
    int index = start;
    boolean flag = false;
    for (int i = start + 1; i < end; i++) {
      if (arr[i] > arr[start]) {
        index = i;
        flag = true;
        break;
      }
    }
    if (flag == false) {
      return calculate(arr, start + 1, end, arr[start], minValue);
    }

    return calculate(arr, start + 1, index, arr[start], minValue)
        && calculate(arr, index, end, maxValue, arr[start]);
  }
}
