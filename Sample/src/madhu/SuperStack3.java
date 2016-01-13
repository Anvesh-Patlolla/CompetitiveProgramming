package madhu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Solution
public class SuperStack3 {

  static StringBuilder pw = null;
  static long array[] = null;
  static int currentIndex = 0;

  public static void main(String[] args) throws NumberFormatException, IOException {
    int T;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //Scanner scanIn = new Scanner(System.in);
    pw = new StringBuilder();
    T = Integer.parseInt(br.readLine());
    String input = null;
    array = new long[T];
    for (int i = 0; i < T; i++) {
      input = br.readLine();
      calculate(input);
    }
    System.out.println(pw.toString());
  }

  final static String PUSH = "push";
  final static String POP = "pop";
  final static String INC = "inc";

  private static void calculate(String input) {
    if (input.contains(PUSH)) {
      push(input);
    } else if (input.contains(POP)) {
      pop(input);
    } else {
      increment(input);
    }
  }

  private static void increment(String input) {
    String str[] = input.split(" ");
    int len = Integer.parseInt(str[1]);
    int inc = Integer.parseInt(str[2]);
    for (int i = 0; i < len; i++) {
      array[i] += inc;
    }
    pw.append( array[currentIndex - 1]).append("\n");
  }

  static final String EMPTY = "EMPTY\n";

  private static void pop(String input) {
    currentIndex--;
    if (currentIndex == 0) {
      pw.append(EMPTY);
      return;
    }
    pw.append(array[currentIndex - 1]).append("\n");
  }

  private static void push(String input) {
    String str[] = input.split(" ");
    int temp = Integer.parseInt(str[1]);
    array[currentIndex] = temp;
    pw.append(array[currentIndex]).append("\n");
    currentIndex++;
  }
}
