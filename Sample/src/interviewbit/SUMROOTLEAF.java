package interviewbit;

import java.util.ArrayList;

public class SUMROOTLEAF {

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }



  public int sumNumbers(TreeNode a) {
    ArrayList<Integer> list = null;
    if (a == null) {
      return 0;
    }
    list = new ArrayList<>();
    calulate(a, 0, list);
    return sum(list);
  }

  private int sum(ArrayList<Integer> list2) {
    int sum = 0;
    for (int i : list2) {
      sum += i;
      sum %= 1003;
    }
    return sum;
  }

  private void calulate(TreeNode a, int val, ArrayList<Integer> list) {
    if (a.left == null & a.right == null) {
      list.add(val * 10 + a.val);
      return;
    }


    val = (val * 10 + a.val) % 1003;
    if (a.left != null) {
      calulate(a.left, val, list);
    }
    if (a.right != null) {
      calulate(a.right, val, list);
    }
  }
}
