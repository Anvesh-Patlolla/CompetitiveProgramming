package heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HeapSort {

  public static void main(String[] args) {
    HeapSort obj = new HeapSort();
    String input = obj.inputFromKeyboard();
    ArrayList<Integer> tempArray = new ArrayList<>();
    for (String s : input.split(" ")) {
      tempArray.add(Integer.parseInt(s));
    }

    int[] array = new int[tempArray.size()];
    for (int i = 0; i < tempArray.size(); i++) {
      array[i] = tempArray.get(i);
    }
    maxHeap(array);
  }

  private static void print(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();

  }

  private static void maxHeap(int[] array) {
    for (int i = (array.length - 2) / 2; i >= 0; i--) {
      heapify(array, i);
    }
    heapSort(array);
  }

  private static void heapSort(int[] array) {
    ArrayList<Integer> retList = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      retList.add(array[0]);
      System.out.println(array[0]);
      array[0] = array[array.length - i - 1];
      array[array.length - i - 1] = Integer.MIN_VALUE;
      heapify(array, 0);
    }
    print(retList);
  }

  private static void print(ArrayList<Integer> retList) {
    for (Integer i : retList) {
      System.out.print(i);
    }
    System.out.println();
  }

  private static void heapify(int[] array, int index) {
    int maxIndex = index;
    int size = array.length;
    int left = index * 2 + 1;
    int right = index * 2 + 2;
    if (left < size && array[maxIndex] < array[left]) {
      maxIndex = left;
    }
    if (right < size && array[maxIndex] < array[right]) {
      maxIndex = right;
    }
    if (maxIndex != index) {
      swap(array, maxIndex, index);
      heapify(array, maxIndex);
    }

  }

  private static void swap(int[] array, int maxIndex, int index) {
    int temp = array[maxIndex];
    array[maxIndex] = array[index];
    array[index] = temp;
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
    System.out.println(s);
    return s;
  }
}
