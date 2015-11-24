package hackerrank.zenefitsCodeSprint;

import java.util.ArrayList;
import java.util.Scanner;

// Solution
public class PrimeTargets {
  static int arr[] = null;
  static int N = 0;
  static ArrayList<Integer> primes = null;

  public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     N = in.nextInt();
     arr = new int[N];
     for (int i = 0; i < N; i++) {
     arr[i] = in.nextInt();
     }
    calculatePrimes(N);
    System.out.println(calculate());
  }


  private static int calculate() {
    int sum = 0;
    int size = primes.size();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < size && i + primes.get(j) < N; j++) {
          sum += arr[i + primes.get(j)] - arr[i];

      }
    }
    return sum;

  }

  private static void calculatePrimes(int max) {
    primes = new ArrayList<Integer>();

    for (int i = 2; i < max; i++) {
      boolean flag = true;
      for (int j = 2; j <= java.lang.Math.sqrt(i) && flag; j++) {
        if (i % j == 0) {
          flag = false;
        }
      }
      if (flag) {
        primes.add(i);
      }
    }

  }

}
