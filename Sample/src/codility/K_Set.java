package codility;

public class K_Set {
  int solution(int A[]) {
    if (A == null || A.length <= 0) {
      return 0;
    }
    int maxSetSize = 1;
    for (int i = 0; i < A.length; i++) {
      int temp = i;
      int currentSize = 0;
      int j = 0;
      while (A[temp] >= 0) {
        j = A[temp];
        currentSize++;
        A[temp] = -1;
        temp = j;
      }
      if (currentSize > maxSetSize) {
        maxSetSize = currentSize;
      }
    }
    return maxSetSize;
  }

  public static void main(String[] args) {
    K_Set obj = new K_Set();
    int[] A = {5, 4, 0, 3, 1, 6, 2};
    System.out.println(obj.solution(A));
    int[] B = {1, 2, 3, 4, 5, 0};
    System.out.println(obj.solution(B));
    int[] C = {2, 5, 4, 3, 7, 8, 11, 9, 1, 10, 6, 0};

    System.out.println(obj.solution(C));
    int[] D = {4, 3, 1, 5, 0, 2};

    System.out.println(obj.solution(D));
    int[] E = {0, 1, 2, 5, 3, 4};

    System.out.println(obj.solution(E));
  }
}
