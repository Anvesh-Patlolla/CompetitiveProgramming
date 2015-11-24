package interviewbit;

import java.util.ArrayList;

public class INORDER {
  public ArrayList<Integer> inorderTraversal(TreeNode a) {
    list = new ArrayList<>();
    inorder(a);
    return list;
  }

  private void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    list.add(root.val);
    inorder(root.right);

  }

  ArrayList<Integer> list = null;

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
