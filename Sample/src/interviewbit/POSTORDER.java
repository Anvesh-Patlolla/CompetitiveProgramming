package interviewbit;

import java.util.ArrayList;

public class POSTORDER {


  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  ArrayList<Integer> retList = null;

  public ArrayList<Integer> postorderTraversal(TreeNode a) {
    retList = new ArrayList<>();
    postOrder(a);
    return retList;
  }

  private void postOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    postOrder(root.left);
    postOrder(root.right);
    retList.add(root.val);
  }

  public static void main(String[] args) {

  }
}
