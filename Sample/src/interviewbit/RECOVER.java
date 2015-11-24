package interviewbit;

import java.util.ArrayList;
import java.util.Collections;


public class RECOVER {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  ArrayList<Integer> list = null;

  public ArrayList<Integer> recoverTree(TreeNode root) {
    list = new ArrayList<>();
    inorder(root);
    ArrayList<Integer> dup = new ArrayList<>(list);
    Collections.sort(dup);
    ArrayList<Integer> retList = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) != dup.get(i)) {
        retList.add(dup.get(i));
      }
    }
    return retList;


  }

  private void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    list.add(root.val);
    inorder(root.right);
  }

}
