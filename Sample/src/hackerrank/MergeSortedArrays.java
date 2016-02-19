package hackerrank;

public class MergeSortedArrays {
  static int[] mergeArrays(int[] a, int[] b) {
    if (a == null || a.length == 0) {
      return b;
    }
    if (b == null || b.length == 0) {
      return a;
    }
    int retArray[] = new int[a.length * 2];
    int i = 0, j = 0, k = 0;
    for (i = 0, j = 0, k = 0; i < a.length && j < a.length; k++) {
      if (a[i] > b[j]) {
        retArray[k] = b[j];
        j++;
      } else {
        retArray[k] = a[i];
        i++;
      }
    }
    if (i == a.length - 1) {
      for (int l = j; l < a.length; l++) {
        retArray[k] = b[l];
        k++;
      }
    } else {
      for (int l = i; l < a.length; l++) {
        retArray[k] = a[l];
        k++;
      }
    }
    return retArray;


  }
}
