package interviewbit;

public class SYMMETRY {
  public int isSymmetric(TreeNode a) {
    boolean retVal = checkMirror(a.left, a.right);
    return retVal ? 1 : 0;
  }

  private boolean checkMirror(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    boolean l = checkMirror(left.left, right.right);
    boolean r = checkMirror(left.right, right.left);

    return l && r;
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
