package hackerrank;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeoneering {
  static ArrayList<Integer> input = new ArrayList<>();

  public static void main(String[] args) {
    getInput();
    resolve();
  }

  private static void resolve() {
    if (input.size() == 0) {
      System.out.println("out");
      return;
    }
    int noOfJumps[] = new int[input.size()];
    int previousIndex[] = new int[input.size()];

    for (int i = input.size() - 1; i > -1; i--) {
      int jumps = input.get(i);
      if (jumps == 0) {
        noOfJumps[i] = Integer.MAX_VALUE;
        previousIndex[i] = -1;
        continue;
      }
      if (i + jumps >= input.size()) {
        noOfJumps[i] = 1;
        previousIndex[i] = -222;
        continue;
      } else {
        int maxJumps = Integer.MAX_VALUE;
        int previous = -1;
        for (int j = i + jumps; j > i; j--) {
          if (noOfJumps[j] != Integer.MAX_VALUE) {
            if (maxJumps > noOfJumps[j]) {
              maxJumps = noOfJumps[j];
              previous = j;
            }
          }
          if (maxJumps != Integer.MAX_VALUE) {
            noOfJumps[i] = maxJumps + 1;
            previousIndex[i] = previous;
          } else {
            noOfJumps[i] = maxJumps;
            previousIndex[i] = previous;
          }
        }
      }

    }
    // display(noOfJumps);
    // display(previousIndex);
    // int minJumps = Integer.MAX_VALUE;
    // int minIndex = -1;
    // for (int i = 0; i < input.size(); i++) {
    // if (noOfJumps[i] < minJumps) {
    // minJumps = noOfJumps[i];
    // minIndex = i;
    // }
    // }
    if (input.size() <= 0 || noOfJumps[0] == Integer.MAX_VALUE) {
      System.out.println("failure");
      return;
    }
    // System.out.println();
    for (int i = 0;;) {
      System.out.print(i + ", ");
      if (i + input.get(i) >= input.size()) {
        System.out.println("out");
        return;
      }
      i = previousIndex[i];
    }


  }

  private static void display(int[] noOfJumps) {
    for (int i = 0; i < noOfJumps.length; i++) {
      System.out.print(noOfJumps[i] + "  ");
    }
    System.out.println();

  }

  private static void getInput() {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      try {
        input.add(sc.nextInt());
      } catch (InputMismatchException e) {

      }
    }

    // int array[] = {5, 6, 0, 4, 2, 4, 1, 0, 0, 4};
    // for (int i = 0; i < array.length; i++) {
    // input.add(array[i]);
    // }
  }

}
