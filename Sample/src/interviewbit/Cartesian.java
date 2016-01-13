package interviewbit;

import java.util.ArrayList;

public class Cartesian {
  public TreeNode buildTree(ArrayList<Integer> input) {
    TreeNode root = calculate(input, 0, input.size() - 1);
    return root;
  }

  private TreeNode calculate(ArrayList<Integer> input, int start, int end) {
    if (start > end) {
      return null;
    }
    if (start == end) {
      return new TreeNode(input.get(start));
    }
    int maxIndex = getMax(input, start, end);
    TreeNode root = new TreeNode(input.get(maxIndex));
    root.right = calculate(input, maxIndex + 1, end);
    root.left = calculate(input, start, maxIndex - 1);
    return root;
  }

  private int getMax(ArrayList<Integer> input, int start, int end) {
    int maxIndex = -1, max = Integer.MIN_VALUE;
    for (int i = start; i <= end; i++) {
      if (input.get(i) > max) {
        max = input.get(i);
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
