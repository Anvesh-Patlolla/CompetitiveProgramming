package heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MergeSort {

  public static void main(String[] args) {
    MergeSort obj = new MergeSort();
    String input = obj.inputFromKeyboard();
    ArrayList<Integer> tempList = new ArrayList<>();
    for (String s : input.split(" ")) {
      tempList.add(Integer.parseInt(s));
    }
    int array[] = new int[tempList.size()];
    for (int i = 0; i < tempList.size(); i++) {
      array[i] = tempList.get(i);
    }

    obj.mergeSort(array);

  }

  private void mergeSort(int[] array) {
    mergeSort(array, 0, array.length);

  }

  private void mergeSort(int[] array, int l, int r) {
    if (r > l) {
      int mid = (r + l) / 2;
      mergeSort(array, l, mid);
      mergeSort(array, mid + 1, r);
      merge(array, l, mid, r);
    }

  }

  private void merge(int[] array, int l, int mid, int r) {

  }

  public String inputFromKeyboard() {
    InputStreamReader in = null;
    in = new InputStreamReader(System.in);

    BufferedReader br = new BufferedReader(in);
    String s = null;
    try {
      s = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
      try {
        br.close();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }
    return s;
  }

}
