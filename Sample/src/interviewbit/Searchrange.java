package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class Searchrange {
  public ArrayList<Integer> searchRange(final List<Integer> input, int b) {
    ArrayList<Integer> retList = null;
    retList = calculate(input, b);
    return retList;

  }

  int left = -1;
  int right = -1;

  private ArrayList<Integer> calculate(List<Integer> input, int key) {
    ArrayList<Integer> retList = new ArrayList<>();
    int index = binarySearch(input, key, 0, input.size() - 1);
    if (index == -1) {
      retList.add(-1);
      retList.add(-1);
      return retList;
    }
    left = leftBinarySearch(input, key, 0, index - 1);
    right = rightBinarySearch(input, key, index + 1, input.size() - 1);
    retList.add(left);
    retList.add(right);
    return retList;
  }

  private int rightBinarySearch(List<Integer> input, int key, int left, int right) {
    if (left >= input.size()) {
      return input.size() - 1;
    }
    if (left == input.size() - 1 || input.get(left) != key) {
      if (left == input.size() - 1 && input.get(left) == key) {
        return left;
      } else {
        return left - 1;
      }
    }
    if (left == right) {
      return left;
    }

    int mid = (left + right) / 2;
    if (input.get(mid) != key) {
      return rightBinarySearch(input, key, left + 1, mid);
    } else {
      return rightBinarySearch(input, key, mid + 1, right);
    }
  }

  private int leftBinarySearch(List<Integer> input, int key, int left, int right) {
    if (right < 0) {
      return 0;
    }
    if (right == 0 || input.get(right) != key) {
      if (right == 0 && input.get(right) == key) {
        return right;
      } else {
        return right + 1;
      }
    }

    if (left == right) {
      return right;
    }
    int mid = (left + right) / 2;
    if (input.get(mid) != key) {
      return leftBinarySearch(input, key, mid, right - 1);
    } else {
      return leftBinarySearch(input, key, left, mid - 1);
    }
  }

  private int binarySearch(List<Integer> input, int key, int left, int right) {
    if (left > right) {
      return -1;
    }
    if (input.get(left) == key) {
      return left;
    }
    if (input.get(right) == key) {
      return right;
    }
    int mid = (left + right) / 2;
    if (input.get(mid) == key) {
      return mid;
    } else if (input.get(mid) > key) {
      return binarySearch(input, key, left, mid - 1);
    } else {
      return binarySearch(input, key, mid + 1, right);
    }
  }

  public static void main(String[] args) {
    Searchrange obj = new Searchrange();
    List<Integer> input = new ArrayList<Integer>();

    int key = 2;
    int arr[] = {1, 2, 6, 9, 9};

    for (int i = 0; i < arr.length; i++) {
      input.add(arr[i]);
    }

    System.out.println(obj.searchRange(input, key));
  }
}
