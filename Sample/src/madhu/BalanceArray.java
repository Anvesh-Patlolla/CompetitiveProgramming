package madhu;

public class BalanceArray {

  // static int array[] = null;

  static int sumBalance(int[] arr) {

    int left = arr[0];
    int right = getRight(2, arr.length, arr);
    if (left == right) {
      return 1;
    }
    for (int i = 1; i < arr.length - 2; i++) {
      left += arr[i];
      right -= arr[i + 1];
      if (left == right) {
        return 1;
      }
    }
    return 0;


  }

  private static int getRight(int start, int end, int arr[]) {

    int temp = 0;
    int i;
    for (i = start; i < end; i++) {
      temp += arr[i];
    }
    return temp;
  }

  public static void main(String[] args) {
    int array[] = {1, 2, 3, 3,3};
    System.out.println(sumBalance(array));
  }

}
