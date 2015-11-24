package interviewbit;

import java.util.ArrayList;

public class FLATTEN {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  ArrayList<TreeNode> list = null;

  public TreeNode flatten(TreeNode root) {
    list = new ArrayList<>();
    inorder(root);

    root.left = null;
    TreeNode temp = root;
    for (int i = 1; i < list.size(); i++) {
      temp.left = null;
      temp.right = list.get(i);
      temp = temp.right;
      /*
       * if(temp!=null){ temp. }
       */
    }
    return root;

  }

  private void inorder(TreeNode a) {
    if (a == null) {
      return;
    }
    list.add(a);
    inorder(a.left);
    inorder(a.right);
  }
}
