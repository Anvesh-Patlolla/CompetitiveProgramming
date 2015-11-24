package interviewbit;

import java.util.ArrayList;

public class NQUEENS_BACKTRACKING {
  ArrayList<ArrayList<String>> retList = null;

  public ArrayList<ArrayList<String>> solveNQueens(int n) {
    retList = new ArrayList<>();
    boolean[][] chess = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        chess[i][j] = false;
      }
    }
    calculate(n, n, chess, 0);
    return retList;
  }

  private void calculate(int remaining, int size, boolean[][] chess, int row) {
    if (remaining == 0) {
      display(chess, size);
      return;
    }
    for (int i = 0; i < size; i++) {
      chess[row][i] = true;
      if (check(chess, row, size)) {
        calculate(remaining - 1, size, chess, row + 1);
      }
      chess[row][i] = false;
    }

  }

  private void display(boolean[][] chess, int size) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (chess[i][j]) {
          System.out.print("Q");
        } else {
          System.out.print(".");
        }
      }
      System.out.println();
    }
    System.out.println("==================================");
  }

  private boolean check(boolean[][] chess, int row, int size) {
    for (int i = 0; i <= row; i++) {
      for (int j = 0; i < size; i++) {
        if (chess[i][j]) {
          if (checkQueen(chess, size, i, j) == false) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private boolean checkQueen(boolean[][] chess, int size, int i, int j) {

    for (int l = i + 1, m = j + 1; l < size && m < size; l++, m++) {
      //System.out.println(i + " " + j);
      if (chess[l][m]) {
        return false;
      }
    }

    for (int l = i - 1, m = j - 1; l > -1 && m > -1; l--, m--) {
      //System.out.println(i + " " + j);
      if (chess[l][m]) {
        return false;
      }
    }

    for (int l = i + 1, m = j - 1; l < size && m > -1; l++, m--) {
      //System.out.println(i + " " + j);
      if (chess[l][m]) {
        return false;
      }
    }

    for (int l = i - 1, m = j + 1; l > -1 && m < size; l--, m++) {
      //System.out.println(i + " " + j);
      if (chess[l][m]) {
        return false;
      }
    }

    // ===============================================================

    for (int l = i, m = j + 1; m < size; m++) {
      //System.out.println(i + " " + j);
      if (chess[l][m]) {
        return false;
      }
    }

    for (int l = i, m = j - 1; m > -1; m--) {
      //System.out.println(i + " " + j);
      if (chess[l][m]) {
        return false;
      }
    }

    for (int l = i + 1, m = j; l < size; l++) {
      //System.out.println(i + " " + j);
      if (chess[l][m]) {
        return false;
      }
    }

    for (int l = i - 1, m = j; l > -1; l--) {
      //System.out.println(i + " " + j);
      if (chess[l][m]) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    NQUEENS_BACKTRACKING obj = new NQUEENS_BACKTRACKING();
    obj.solveNQueens(4);
  }
}
