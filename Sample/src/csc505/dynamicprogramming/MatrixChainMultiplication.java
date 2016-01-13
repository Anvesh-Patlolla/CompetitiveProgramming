package csc505.dynamicprogramming;

// Algo is same as the one taught in class - lecture 10.
public class MatrixChainMultiplication {

  int[][] dp = null;
  int[][] kVal = null;

  long noOfRecursions = 0;
  long noOfMemoizedRecursions = 0;

  public static void main(String[] args) {
    MatrixChainMultiplication matMul = new MatrixChainMultiplication();
    // int[] inputDimensions = {5, 2, 4, 3, 7, 9, 7, 8, 6, 1, 3, 7, 6, 5};
    // int[] inputDimensions = {1, 2, 3, 4};
    // int[] inputDimensions =
    // {5, 2, 4, 3, 7, 9, 7, 8, 6, 1, 3, 7, 6, 5, 5, 2, 4, 3, 7, 9, 7, 8, 6, 1, 3, 7, 6, 5, 5, 2,
    // 4, 3, 7, 9, 7, 8, 6, 1, 3, 7, 6, 5};
    int[] inputDimensions = {5, 2, 4, 3, 7, 9, 7, 8, 6, 1, 3, 7, 6, 5/*
                                                                      * , 5, 2, 4, 3, 7, 9, 7, 8, 6,
                                                                      * 1, 3, 7, 6, 5
                                                                      */};
    // int[] inputDimensions =
    // {5,1,15,8,4};
    System.out.println(matMul.minimumMultiplicationsDp(inputDimensions));
    matMul.display(inputDimensions.length);
    // System.out.println(matMul.minimumMultiplicationsMemoization(inputDimensions)
    // + "\n No of memoized recursions:" + matMul.noOfMemoizedRecursions);
    // System.out.println(matMul.minimumMultiplicationsRecursive(inputDimensions)
    // + "\n No of recursions: " + matMul.noOfRecursions);
    System.out.println("Naive implementation: "+matMul.naiveImpl(inputDimensions));
  }

  private int naiveImpl(int[] inputDimensions) {
    int retVal = 0;

    int first = 0, second = first + 1, third = second + 1;
    for (; third < inputDimensions.length;) {
      retVal += inputDimensions[first] * inputDimensions[second] * inputDimensions[third];
      second = third;
      third = third + 1;
    }
    return retVal;
  }

  private void display(int size) {
    for (int i = 0; i <= size; i++) {
      for (int j = 0; j <= size; j++) {
        System.out.print(dp[i][j] + "\t");
      }
      System.out.println("");
    }
    System.out.println("=====================================");
    System.out.println("=====================================");
    for (int i = 0; i <= size; i++) {
      for (int j = 0; j <= size; j++) {
        System.out.print(kVal[i][j] + "\t");
      }
      System.out.println("");
    }
  }

  int minimumMultiplicationsDp(int[] inputDimensions) {
    long startTime = System.currentTimeMillis();
    int size = inputDimensions.length;
    dp = new int[size + 1][size + 1];
    kVal = new int[size + 1][size + 1];
    for (int i = 0; i <= size; i++) {
      dp[i][i] = 0;
    }

    for (int i = size - 1; i > 0; i--) {
      for (int j = i + 1; j < size; j++) {
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
          int q =
              dp[i][k] + dp[k + 1][j] + inputDimensions[i - 1] * inputDimensions[k]
                  * inputDimensions[j];
          if (q < dp[i][j]) {
            dp[i][j] = q;
            kVal[i][j] = k;
          }

        }
      }
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Total Time taken to execute minimumMultiplicationsDp : "
        + (endTime - startTime));
    return dp[1][size - 1];
  }



  int minimumMultiplicationsMemoization(int[] inputDimensions) {
    noOfMemoizedRecursions = 0;
    long startTime = System.currentTimeMillis();
    int size = inputDimensions.length;
    dp = new int[size + 1][size + 1];
    kVal = new int[size + 1][size + 1];
    for (int i = 0; i <= size; i++) {
      for (int j = 0; j <= size; j++) {
        if (i == j) {
          dp[i][i] = 0;
        } else {
          dp[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    int retVal = minimumMultiplicationsMemoization(inputDimensions, 1, size - 1);
    long endTime = System.currentTimeMillis();
    System.out.println("Total Time taken to execute minimumMultiplicationsMemoization: "
        + (endTime - startTime));
    return retVal;
  }

  private int minimumMultiplicationsMemoization(int[] inputDimensions, int i, int j) {
    noOfMemoizedRecursions++;
    if (dp[i][j] != Integer.MAX_VALUE) {
      return dp[i][j];
    }

    for (int k = i; k <= j - 1; k++) {
      int q =
          minimumMultiplicationsMemoization(inputDimensions, i, k)
              + minimumMultiplicationsMemoization(inputDimensions, k + 1, j)
              + inputDimensions[i - 1] * inputDimensions[k] * inputDimensions[j];
      if (q < dp[i][j]) {
        dp[i][j] = q;
        kVal[i][j] = k;
      }

    }
    return dp[i][j];
  }

  int minimumMultiplicationsRecursive(int[] inputDimensions) {

    long startTime = System.currentTimeMillis();

    noOfRecursions = 0;
    int size = inputDimensions.length;
    dp = new int[size + 1][size + 1];
    kVal = new int[size + 1][size + 1];
    for (int i = 0; i <= size; i++) {
      for (int j = 0; j <= size; j++) {
        if (i == j) {
          dp[i][i] = 0;
        } else {
          dp[i][j] = Integer.MAX_VALUE;
        }
      }
    }


    int retVal = minimumMultiplicationsRecursive(inputDimensions, 1, size - 1);
    long endTime = System.currentTimeMillis();
    System.out.println("Total Time taken to execute minimumMultiplicationsRecursive: "
        + (endTime - startTime));

    return retVal;
  }

  private int minimumMultiplicationsRecursive(int[] inputDimensions, int i, int j) {

    noOfRecursions++;
    for (int k = i; k <= j - 1; k++) {
      int q =
          minimumMultiplicationsRecursive(inputDimensions, i, k)
              + minimumMultiplicationsRecursive(inputDimensions, k + 1, j) + inputDimensions[i - 1]
              * inputDimensions[k] * inputDimensions[j];
      if (q < dp[i][j]) {
        dp[i][j] = q;
        kVal[i][j] = k;
      }

    }
    return dp[i][j];
  }
}
