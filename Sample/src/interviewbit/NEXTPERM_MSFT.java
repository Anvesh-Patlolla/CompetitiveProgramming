package interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class NEXTPERM_MSFT {
  // public void nextPermutation(ArrayList<Integer> input) {
  // int swapPos = input.size() - 1;
  // int size = input.size() - 1;
  // for (int i = input.size() - 1; i > -1; i--) {
  // if (input.get(i) < input.get(swapPos)) {
  // swapPos = i;
  // break;
  // }
  // }
  // if (swapPos == size) {
  // Collections.sort(input);
  // return;
  // }
  // int temp = input.get(swapPos);
  // input.set(swapPos, input.get(size));
  // input.set(size, temp);
  // sort(input, swapPos);
  // }
  //
  // private void sort(ArrayList<Integer> input, int swapPos) {
  // for (int i = swapPos + 1; i < input.size(); i++) {
  // for (int j = i + 1; j < input.size(); j++) {
  // if (input.get(i) > input.get(j)) {
  // // swap
  // int temp = input.get(i);
  // input.set(i, input.get(j));
  // input.set(j, temp);
  // }
  //
  // }
  // }
  //
  // }

  public void nextPermutation(ArrayList<Integer> A) {
    boolean status;
    status = nextPerm(A);
    if (!status)
      Collections.sort(A);
    return;
  }


  public boolean nextPerm(ArrayList<Integer> A) {

    int i = 0;
    int n = A.size();

    for (i = n - 2; i >= 0; i--) {
      if (A.get(i) < A.get(i + 1))
        break;
    }

    if (i == -1)
      return false;

    int j = n - 1;

    for (; j >= i; j--) {
      if (A.get(j) > A.get(i))
        break;
    }

    swap(A, i, j);

    i++;
    int steps = (n - i + 1) / 2;

    for (int k = 0; k < steps; k++) {
      swap(A, i + k, n - k - 1);
    }

    return true;
  }

  public void swap(ArrayList<Integer> A, int i, int j) {
    int temp = A.get(i);
    A.set(i, A.get(j));
    A.set(j, temp);
  }

  public static void main(String[] args) {
    NEXTPERM_MSFT obj = new NEXTPERM_MSFT();
    int arr[] = {20, 50, 113};
    ArrayList<Integer> input = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      input.add(arr[i]);
    }
    obj.nextPermutation(input);
    System.out.println(input.toString());
  }
}
