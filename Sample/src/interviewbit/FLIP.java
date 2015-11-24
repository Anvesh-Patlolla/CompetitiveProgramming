package interviewbit;

import java.util.ArrayList;

public class FLIP {
  public ArrayList<Integer> flip(String A) {
    int max = 0, tempMax = 0;
    int tempStartIndex = 0, startIndex = 0, endIndex = -1;
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == '0') {
        tempMax++;
      } else {
        tempMax--;
      }
      if (tempMax < 0) {
        tempMax = 0;
        tempStartIndex = i + 1;
      }
      if (tempMax > max) {
        max = tempMax;
        endIndex = i;
        startIndex = tempStartIndex;
      }
    }
    ArrayList<Integer> retList = new ArrayList<>();

    if (max == 0) {
      return retList;
    } else {
      retList.add(startIndex + 1);
      retList.add(endIndex + 1);
      return retList;
    }
  }

  public static void main(String[] args) {
    FLIP obj = new FLIP();
    
    String A = "010";
    System.out.println(obj.flip(A));// 1 1
    
    // 1101
    System.out.println(obj.flip("1101"));// 3 3
    
    // 1101010001
    System.out.println(obj.flip("1101010001")); // 3 9
  }
}
