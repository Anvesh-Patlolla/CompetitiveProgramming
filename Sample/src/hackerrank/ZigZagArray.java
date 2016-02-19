package hackerrank;

import java.util.Arrays;

public class ZigZagArray {
  static int[] wiggleArrangeArray(int[] intArr) {
    Arrays.sort(intArr);
    int[] retList = new int[intArr.length];
    for (int i = 0, j = 0, k = intArr.length - 1; i < intArr.length; i++) {
      if (i % 2 == 0) {
        retList[i] = intArr[k];
        k--;
      } else {
        retList[i] = intArr[j];
        j++;
      }
    }

    return retList;
  }

  public static void main(String[] args) {
    ZigZagArray obj = new ZigZagArray();
    int[] intArr = {1, 3, 6, 9, -3};
    display(wiggleArrangeArray(intArr));
    int[] intArr1 = {5, 2, 7, 8, -2, 25, 25};

    display(wiggleArrangeArray(intArr1));
  }

  private static void display(int[] wiggleArrangeArray) {
    for (int i = 0; i < wiggleArrangeArray.length; i++) {
      System.out.print(wiggleArrangeArray[i] + " ");
    }
    System.out.println();

  }
}
