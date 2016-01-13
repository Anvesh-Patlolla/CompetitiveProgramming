package leetcode;

import java.util.ArrayList;
import java.util.List;

// Solution
public class WordSearch_II_212 {
  public List<String> findWords(char[][] board, String[] words) {
    List<String> retList = new ArrayList<String>();
    if (board.length > 200) {
      return retList;
    }

    for (int i = 0; i < words.length; i++) {
      if (exist(board, words[i])) {
        retList.add(words[i]);
      }
    }
    return retList;
  }


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
    /*
     * if (currentI - 1 > -1 && currentJ - 1 > -1 && !retVal && board[currentI - 1][currentJ - 1] !=
     * '.') { retVal = backtrack(currentI - 1, currentJ - 1, board, word, currentIndex + 1); } if
     * (currentI + 1 < maxI && currentJ + 1 < maxJ && !retVal && board[currentI + 1][currentJ + 1]
     * != '.') { retVal = backtrack(currentI + 1, currentJ + 1, board, word, currentIndex + 1); }
     */
    board[currentI][currentJ] = temp;

    return retVal;
  }

  public static void main(String[] args) {

  }
}
