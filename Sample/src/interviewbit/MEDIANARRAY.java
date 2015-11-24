package interviewbit;

import java.util.List;

public class MEDIANARRAY {

  // DO NOT MODIFY BOTH THE LISTS
  public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
    if (a.size() == 0 || b.size() == 0) {
      if (a.size() == 0) {
        if (b.size() % 2 == 0) {
          return (b.get(b.size() / 2) + b.get(-1 + (b.size() / 2))) / 2.0;
        } else {
          return b.get(b.size() / 2);
        }
      } else {
        if (a.size() % 2 == 0) {
          return (a.get(a.size() / 2) + a.get(-1 + (a.size() / 2))) / 2.0;
        } else {
          return a.get(a.size() / 2);
        }


      }
    }
    int X[] = new int[a.size()];
    int Y[] = new int[b.size()];
    for (int i = 0; i < a.size(); i++) {
      X[i] = a.get(i);
    }
    for (int i = 0; i < b.size(); i++) {
      Y[i] = b.get(i);
    }
    return sortedMedian(X, Y, 0, X.length - 1, 0, Y.length - 1);
  }

  double sortedMedian(int[] X, int[] Y, int startX, int endX, int startY, int endY) {
    int median1 = X[(startX + endX) / 2];
    int median2 = Y[(startY + endY) / 2];
    if (median1 == median2) {
      return median1;
    }
    if ((endX - startX <= 2) && (endY - startY <= 2)) {
      // if there are only two elements in both lists.. then we need the middle two elements.
      int temp1 = 0, temp2 = 0;
      temp1 = X[startX] > Y[startY] ? X[startX] : Y[startY];// max(X[startX],Y[startY])
      temp2 = X[endX] > Y[endY] ? Y[endY] : X[endX]; // min(X[endX],Y[endY])

      return (temp1 + temp2) / 2.0;
    }
    if (median1 > median2) {
      // over all median must be in between (startX to median1) || (median2 to endY)
      return sortedMedian(X, Y, startX, (startX + endX) / 2, (startY + endY) / 2, endY);
    } else {
      // over all median must be in between (median1 to endX) || (startY to median2)
      return sortedMedian(X, Y, (startX + endX) / 2, endX, startY, (startY + endY) / 2);
    }
  }

  public static void main(String[] args) {
    MEDIANARRAY obj = new MEDIANARRAY();
    int[] X = {-50, -41, -40, -19, 5, 21, 28};
    int[] Y = {-50, -21, -10};
    System.out.println(obj.sortedMedian(X, Y, 0, X.length - 1, 0, Y.length - 1));

    int X1[] = {-40, -25, 5, 10, 14, 28, 29, 48};
    int Y1[] = {-48, -31, -15, -6, 1, 8};
    System.out.println(obj.sortedMedian(X1, Y1, 0, X1.length - 1, 0, Y1.length - 1));

  }
}
