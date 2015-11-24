package interviewbit;

public class SearchSortedRotatedArray {

  int search(int array[], int k) {
    return search(array, 0, array.length - 1, k);
  }

  private int search(int[] array, int left, int right, int key) {
    if (left > right) {
      return -1;
    }
    if (left == right) {
      return left;
    }
    int mid = left + (right - left) / 2;
    if (array[mid] == key) {
      return mid;
    }
    // left sub array is sorted.
    if (array[left] < array[mid]) {
      if (key >= array[left] && key <= array[mid]) {
        return search(array, left, mid - 1, key);
      } else {
        return search(array, mid + 1, right, key);
      }
    } else {// right sub array is sorted.
      if (key >= array[mid] && key <= array[right]) {
        return search(array, mid + 1, right, key);
      } else {
        return search(array, left, mid - 1, key);
      }
    }
  }

  public static void main(String[] args) {
    SearchSortedRotatedArray obj = new SearchSortedRotatedArray();
    int array[] = {7, 1, 2, 3, 4, 5, 6};
    System.out.println(obj.search(array, 5));
  }
}
