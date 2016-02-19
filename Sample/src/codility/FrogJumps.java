package codility;

public class FrogJumps {

  int solution(int A[], int X, int distance) {
    int length = A.length;
    boolean dpLeaves[] = new boolean[length + 1];
    int cur = 0;
    for (int i = 0; i < length; i++) {
      dpLeaves[A[i]] = true;
      if (A[i] > cur && A[i] <= cur + distance) {
        cur = A[i];
        for (int j = 1; j <= distance; j++) {
          if (dpLeaves[cur + j]) {
            cur = cur + j;
            j = 1;
          }
          if (cur + distance >= X) {
            return i;
          }
        }
      }
      if (cur + distance >= X) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    FrogJumps jump = new FrogJumps();
    int[] A = {1, 3, 1, 4, 2, 5};
    int X = 7;
    int D = 3;
    System.out.println(jump.solution(A, X, D));
  }
}
