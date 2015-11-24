package hackerrank;

import java.util.Scanner;


public class CoinChangeProblem {

  public static void main(String[] args) {
    /*
     * Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be
     * named Solution.
     */
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int array[] = new int[M];
    for (int i = 0; i < M; i++) {
      array[i] = sc.nextInt();
    }
    int retArray[] = new int[N + 1];

    retArray[0] = 0;
    for (int i = 1; i <= N; i++) {
      int temp = 0;
      for (int j = 0; j < M; j++) {
        int index = i - array[j];
        if (index > -1) {
          if (index == 0) {
            temp++;
          } else {
            temp += retArray[index];
          }
        }
      }
      retArray[i] = temp;
    }
    
    System.out.println(retArray[N]);
  }
}
