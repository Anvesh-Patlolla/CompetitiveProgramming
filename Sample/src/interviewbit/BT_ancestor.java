package interviewbit;

public class BT_ancestor {

  int retVal = 0;

  public int lca(TreeNode a, int val1, int val2) {

    /*
     * if (a.val == val1 || a.val == val2) { return a.val; }
     */
    if (a == null || isExist(a, val1) == false || isExist(a, val2) == false) {
      return -1;
    }
    TreeNode node = LCA(a, val1, val2);
    /*
     * if (val1 == val2) { order2(a, val1, val2); } else { order(a, val1, val2); }
     */
    if (node != null) {
      return node.val;
    } else {
      return -1;
    }
  }


  private TreeNode LCA(TreeNode a, int val1, int val2) {
    if (a == null) {
      return null;
    }
    if (a.val == val1 || a.val == val2) {
      return a;
    }
    TreeNode l = LCA(a.left, val1, val2);
    TreeNode r = LCA(a.right, val1, val2);
    if (l != null && r != null) {
      return a;
    }
    return r != null ? r : l;
  }


  private boolean isExist(TreeNode a, int val1) {
    if (a == null)
      return false;
    if (a.val == val1) {
      return true;
    }
    boolean l = isExist(a.left, val1);
    boolean r = isExist(a.right, val1);
    return l || r;
  }

  private boolean order2(TreeNode a, int val1, int val2) {
    if (a == null) {
      return false;
    }
    if (a.val == val1) {
      retVal = val1;
      return true;
    }
    boolean left = order2(a.left, val1, val2);

    boolean right = order2(a.right, val1, val2);
    if (left || right) {
      // retVal = a.val;
      return false;
    }
    return left || right;

  }


  private boolean order(TreeNode a, int val1, int val2) {
    if (a == null) {
      return false;
    }
    boolean left = order(a.left, val1, val2);
    boolean right = order(a.right, val1, val2);

    if (a.val == val1 || a.val == val2) {
      if (left || right) {
        retVal = a.val;
        return false;
      }
      return true;
    }

    if (left && right) {
      retVal = a.val;
      return false;
    }

    return left || right;
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
