package madhu.aerospike;

public class NoOfLeaves {

  /*
   * Complete the function below.
   */

  public static void main(String[] args) {

    int arr[] = {2, 4, 5};
    System.out.println(countUneatenLeaves(10, arr));
  }

  static int countUneatenLeaves(int N, int[] A) {
    int sum = 0;
    P=N;
    for (int i = 1; i <= A.length; i++) {
      int ret = calculate(N, A, i);
      if (i % 2 == 1) {
        sum = sum + ret;
      } else {
        sum = sum - ret;
      }
    }
    return N-sum+1;
  }

  private static int calculate(int n, int[] a, int order) {

    /*
     * int sum = 0; int size = a.length; for (int i = 0; i < a.length; i++) { int temp = 1; for (int
     * j = i, k = 0; k < order && i <= a.length - order; k++, j++) { temp = temp * a[j%size]; } sum
     * = sum + n / temp; }
     */
    temp = 1;
    count =0;
    printCombination(a, a.length, order);
    //System.out.println("here =="+count);
    return count;
  }

  static int P =0;
  static int temp = 1;
  static int count =0;

  static void printCombination(int arr[], int n, int r) {
    // A temporary array to store all combination one by one
    int data[] = new int[r];

    // Print all combination using temprary array 'data[]'
    combinationUtil(arr, data, 0, n - 1, 0, r);
  }

  /*
   * arr[] ---> Input Array data[] ---> Temporary array to store current combination start & end
   * ---> Staring and Ending indexes in arr[] index ---> Current index in data[] r ---> Size of a
   * combination to be printed
   */
  static void combinationUtil(int arr[], int data[], int start, int end, int index, int r) {
    // Current combination is ready to be printed, print it
    if (index == r) {
      temp =1;
      for (int j = 0; j < r; j++) {
        temp*= data[j];
        //System.out.print(data[j]);
      }
      //System.out.println();
      count=count+P/temp;
      //System.out.println(count);
      return;
    }

    // replace index with all possible elements. The condition
    // "end-i+1 >= r-index" makes sure that including one element
    // at index will make a combination with remaining elements
    // at remaining positions
    for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
      data[index] = arr[i];
      combinationUtil(arr, data, i + 1, end, index + 1, r);
    }
  }
}
