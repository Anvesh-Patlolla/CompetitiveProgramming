package interviewbit;

import java.util.ArrayList;

public class TREEITERATOR {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  ArrayList<Integer> list = null;

  // Solution
  public TREEITERATOR(TreeNode root) {
    list = new ArrayList<>();
    inorder(root);
  }

  private void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    list.add(root.val);
    inorder(root.right);
  }

  /* @return whether we have a next smallest number */
  public boolean hasNext() {

    return list.size() == 0 ? false : true;
  }

  /* @return the next smallest number */
  public int next() {

    return list.remove(0);
  }
}
