package codility;

public class LocalMaximum {
  public int solution(int[] A) {
    if (A.length == 0) {
      return 0;
    } else if (allSame(A)) {
      return 1;
    } else if (A.length == 1) {
      return 1;
    }
    int max_count = 0;
    int current = A[0];

    int previous = Integer.MIN_VALUE;
    if (current > A[1]) {
      max_count++;
    }
    for (int i = 1; i < A.length - 1; i++) {
      current = A[i];

      if (A[i] > previous && A[i] > A[i + 1]) {
        max_count++;
      }
      if (A[i] != A[i + 1]) {
        previous = A[i];
      }
    }
    if (A[A.length - 1] > previous) {
      max_count++;
    }
    // --------------------

    int min_count = 0;
    if (A[0] < A[1]) {
      min_count++;
    }

    previous = Integer.MAX_VALUE;
    for (int i = 1; i < A.length - 1; i++) {
      // if (A[i] == A[i - 1]) {
      // continue;
      // }
      if (A[i] < previous && A[i] < A[i + 1]) {
        min_count++;
      }
      if (A[i + 1] != A[i]) {
        previous = A[i];
      }
    }
    if (A[A.length - 1] < previous) {
      min_count++;
    }

//    System.out.println("Max_count :" + max_count + " Min_count:" + min_count);
    return max_count + min_count;
  }

  private boolean allSame(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] != a[i + 1]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    LocalMaximum max = new LocalMaximum();
    int[] A = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};
    max.solution(A);
    int[] A1 = {2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2};
    max.solution(A1);
    int[] A2 = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    max.solution(A2);
  }

}
