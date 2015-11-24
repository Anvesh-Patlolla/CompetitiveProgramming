package interviewbit;

import java.util.ArrayList;

public class PATH2 {

  public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    retList = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<>();
    hasPath(root, sum, list);
    return retList;
  }

  ArrayList<ArrayList<Integer>> retList = null;

  private boolean hasPath(TreeNode node, int sum, ArrayList<Integer> list) {
    list.add(node.val);
    ArrayList<Integer> list2 = new ArrayList<>(list);

    if (node.val == sum && node.left == null && node.right == null) {
      retList.add(list);
      return true;
    }
    int temp = sum - node.val;
    boolean right = false;
    if (node.right != null) {
      right = hasPath(node.right, temp, list);
    }
    boolean left = false;
    if (node.left != null) {
      left = hasPath(node.left, temp, list2);
    }
    return right || left;
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
