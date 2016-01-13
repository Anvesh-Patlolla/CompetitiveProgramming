package techGig;

public class WordSearchMatrix {
  public static void main(String[] args) {
    String[] matrix = {"E#D#E#E#E,D#I#S#K#E", "E#S#E#E#E", "E#C#E#E#E", "E#E#E#E#E"};
    String word = "DISK";
    System.out.println(word_count(5, matrix, word));
  }


  public static int word_count(int size, String[] matrix, String word) {
    int count = 0;
    count += horizontal(size, matrix, word);
    count += vertical(size, matrix, word);
    count += diagonal(size, matrix, word);
    return count;
  }

  private static int diagonal(int size, String[] matrix, String word) {
    return 0;
  }

  private static int vertical(int size, String[] matrix, String word) {
    int count = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (matrix[j].charAt(i) == word.charAt(0)) {
          count += matchVertical(size, matrix, word, i, j);
        }
      }
    }
    return count;
  }

  private static int matchVertical(int size, String[] matrix, String word, int i, int j) {
    int count = 0;
    int temp = 0;
    for (; temp < word.length() && j < size; j++, temp++) {
      if (matrix[j].charAt(i) != word.charAt(temp)) {
        return 0;
      }
    }
    if (temp == word.length()) {
      return 1;
    } else {
      return 0;
    }
  }


  private static int horizontal(int size, String[] matrix, String word) {
    int count = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.println("i " + i + " j " + j);
        if (matrix[i].charAt(j) == word.charAt(0)) {

          count += matchHorizontal(size, matrix, word, i, j);
        }
      }
    }
    return count;
  }


  private static int matchHorizontal(int size, String[] matrix, String word, int i, int j) {
    int temp = 0;
    for (temp = 0; j < size && temp < word.length(); j++, temp++) {
      if (matrix[i].charAt(j) != word.charAt(temp)) {
        return 0;
      }
    }
    if (temp == word.length()) {
      return 1;
    } else {
      return 0;
    }
  }
}
