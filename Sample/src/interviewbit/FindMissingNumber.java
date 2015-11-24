package interviewbit;

// Not INTERVIEW BIT
public class FindMissingNumber {

  int binarySearch(int startNum, int start, int end, int[] array) {
    if (start == end) {
      if (startNum + start != array[start]) {
        return array[start];
      } else {
        return -1;
      }
    }
    int middle = (start + end) / 2;
    if (array[middle] > startNum + middle) {
      return binarySearch(startNum, start, middle, array);
    } else {
      return binarySearch(startNum, middle + 1, end, array);
    }

  }

  int binarySearch(int[] array) {
    return binarySearch(array[0], 0, array.length, array) - 1;
  }

  public static void main(String[] args) {
    int[] array = {4, 5, 6, 8, 9, 10, 11};
    FindMissingNumber obj = new FindMissingNumber();
    System.out.println(obj.binarySearch(array));
  }
}
