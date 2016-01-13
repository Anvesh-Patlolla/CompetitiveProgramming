package leetcode;

public class WordSearch_79 {

  public boolean exist(char[][] board, String word) {
    boolean retVal = calculate(board, word, 0);
    return retVal;

  }

  private boolean calculate(char[][] board, String word, int currentIndex) {
    // System.out.println("board.length " + board.length);
    // System.out.println("board[0].length " + board[0].length);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (word.charAt(0) == board[i][j]) {
          char temp = board[i][j];
          boolean retVal = backtrack(i, j, board, word, currentIndex);
          board[i][j] = temp;
          if (retVal) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean backtrack(int currentI, int currentJ, char[][] board, String word,
      int currentIndex) {
    if (currentIndex == word.length() - 1 && board[currentI][currentJ] == word.charAt(currentIndex)) {
      return true;
    }
    if (board[currentI][currentJ] != word.charAt(currentIndex)) {
      return false;
    }
    char temp = board[currentI][currentJ];
    board[currentI][currentJ] = '.';

    int maxI = board.length;
    int maxJ = board[0].length;
    boolean retVal = false;
    if (currentI + 1 < maxI && !retVal && board[currentI + 1][currentJ] != '.') {
      retVal = backtrack(currentI + 1, currentJ, board, word, currentIndex + 1);
    }
    if (currentJ + 1 < maxJ && !retVal && board[currentI][currentJ + 1] != '.') {
      retVal = backtrack(currentI, currentJ + 1, board, word, currentIndex + 1);
    }
    if (currentI - 1 > -1 && !retVal && board[currentI - 1][currentJ] != '.') {
      retVal = backtrack(currentI - 1, currentJ, board, word, currentIndex + 1);
    }
    if (currentJ - 1 > -1 && !retVal && board[currentI][currentJ - 1] != '.') {
      retVal = backtrack(currentI, currentJ - 1, board, word, currentIndex + 1);
    }
   /* if (currentI - 1 > -1 && currentJ - 1 > -1 && !retVal
        && board[currentI - 1][currentJ - 1] != '.') {
      retVal = backtrack(currentI - 1, currentJ - 1, board, word, currentIndex + 1);
    }
    if (currentI + 1 < maxI && currentJ + 1 < maxJ && !retVal
        && board[currentI + 1][currentJ + 1] != '.') {
      retVal = backtrack(currentI + 1, currentJ + 1, board, word, currentIndex + 1);
    }*/
    board[currentI][currentJ] = temp;

    return retVal;
  }

  public static void main(String[] args) {
    WordSearch_79 obj = new WordSearch_79();
    char[][] board = getCharBoard1();
    String word = "ABCCED";// , -> returns true,
    System.out.println(obj.exist(board, word));
    word = "SEE";// , -> returns true,
    System.out.println(obj.exist(board, word));

    word = "ABCB";// , -> returns false.
    System.out.println(obj.exist(board, word));

    board = getCharBoard();
    word = "aabaaaabbb";
    System.out.println(obj.exist(board, word));

  }

  private static char[][] getCharBoard() {
    char[][] retVal =
        { {'a', 'a', 'a'}, {'a', 'b', 'b'}, {'a', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'},
            {'a', 'a', 'a'}, {'b', 'b', 'b'}, {'a', 'b', 'b'}, {'a', 'a', 'b'}, {'a', 'b', 'a'}};
    // TODO Auto-generated method stub
    return retVal;
  }

  private static char[][] getCharBoard1() {
    char[][] ret = { {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    return ret;
  }
}
