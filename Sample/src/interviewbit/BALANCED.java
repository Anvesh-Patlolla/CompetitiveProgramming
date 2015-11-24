package interviewbit;

class BALANCED {
  public int isBalanced(TreeNode a) {
    int retVal = getHeight(a);
    return retVal == -1 ? 0 : 1;
  }

  private int getHeight(TreeNode a) {
    if (a == null) {
      return 0;
    }
    int l = getHeight(a.left);
    int r = getHeight(a.right);
    if (l == -1 || r == -1 || mod(l - r) > 1) {
      return -1;
    }

    return l > r ? l + 1 : r + 1;
  }

  private int mod(int i) {
    if (i > 0)
      return i;
    else
      return -1 * i;
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
