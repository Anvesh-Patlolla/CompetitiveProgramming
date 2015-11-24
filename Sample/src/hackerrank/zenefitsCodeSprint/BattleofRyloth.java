package hackerrank.zenefitsCodeSprint;

import java.util.Scanner;

public class BattleofRyloth {
  static int N = 0;
  //static int[] diff = null;
  static BT[] btArray = null;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    //diff = new int[N];
    btArray = new BT[N];
    for (int i = 0; i < N; i++) {
      int p = sc.nextInt();
      int q = sc.nextInt();
      //diff[i] = p - q;
      btArray[i] = new BT();
      btArray[i].diff = p - q;
    }
    for (int i = 0; i < N - 1; i++) {
      int from = sc.nextInt();
      int to = sc.nextInt();
      if (btArray[from].left == null) {
        btArray[from].left = btArray[to];
      } else {
        btArray[from].right = btArray[to];
      }
    }

    cumulativeDiff(btArray[0]);
    count = 0;
    calculate(btArray[0]);

    System.out.println(count);
  }

  static long count = 0;


  private static void calculate(BT bt) {
    if (bt == null) {
      return;
    }
    long left = 0, right = 0;
    if (bt.left != null) {
      left = bt.left.cumulativeDiff;
    }
    if (bt.right != null) {
      right = bt.right.cumulativeDiff;
    }
    long root = bt.diff;
    if (root > 0) {
      count += root;
      if (left > 0) {
        count = count + 2 * left;
      } else if (right > 0) {
        count = count + 2 * right;
      }
    } else {
      // root <=0
      count = count + root * -1;
      if (right < 0) {
        count = count + (right * -2);
      } else if (left < 0) {
        count = count + (left * -2);
      }

    }
    if (bt.right != null) {
      bt.right.diff -= bt.right.cumulativeDiff;
    }
    if (bt.left != null) {
      bt.left.diff -= bt.left.cumulativeDiff;
    }

    calculate(bt.right);
    calculate(bt.left);
  }



  private static long cumulativeDiff(BT bt) {
    if (bt == null) {
      return 0;
    }
    long left = cumulativeDiff(bt.left);
    long right = cumulativeDiff(bt.right);

    bt.cumulativeDiff = left + right + bt.diff;
    return bt.cumulativeDiff;
  }



  static class BT {
    BT left = null;
    BT right = null;
    long diff = 0;
    long cumulativeDiff = 0;
  }
}


// 4
// 0 7
// 6 2
// 5 3
// 1 0
// 0 1
// 0 2
// 1 3
