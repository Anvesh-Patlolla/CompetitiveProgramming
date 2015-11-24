package interviewbit;

import java.util.ArrayList;

public class PREORDER {


  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  ArrayList<Integer> retList = null;

  public ArrayList<Integer> preorderTraversal(TreeNode a) {
    retList = new ArrayList<>();
    preOrder(a);
    return retList;
  }

  private void preOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    retList.add(root.val);
    preOrder(root.left);
    preOrder(root.right);

  }

}
