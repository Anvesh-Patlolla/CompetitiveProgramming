package codility;

public class ConcatinateIntegers {
  public static void main(String[] args) {
    ConcatinateIntegers obj = new ConcatinateIntegers();
    System.out.println(obj.solution(1000, 2000));
    System.out.println(obj.solution(1000, 2004575660));
    System.out.println(obj.solution(1, 2));
    System.out.println(obj.solution(0, 2000));
    System.out.println(obj.solution(1000, 000));
    System.out.println(obj.solution(1000, 0));
  }

  public int solution(int A, int B) {
    String s1 = Integer.toString(A);
    String s2 = Integer.toString(B);
    StringBuilder builder = new StringBuilder();
    int k = 0, i = 0, j = 0;
    for (i = 0, j = 0, k = 0; i < s1.length() && j < s2.length(); k++) {
      if (k % 2 == 0) {
        builder.append(s1.charAt(i));
        i++;
      } else {
        builder.append(s2.charAt(j));
        j++;
      }
    }
    if (i == s1.length()) {
      for (int l = j; l < s2.length(); l++) {
        builder.append(s2.charAt(l));
      }
    } else {
      for (int l = i; l < s1.length(); l++) {
        builder.append(s1.charAt(l));
      }
    }
    String retVal = builder.toString();
    if (retVal.length() >= 9) {
      return -1;
    }
    return Integer.parseInt(retVal);
  }
}
