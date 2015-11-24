package interviewbit;

public class PATH {

  public int hasPathSum(TreeNode a, int b) {
    if (a == null) {
      return 0;
    }
    boolean retVal = hasPath(a, b);
    return retVal ? 1 : 0;
  }

  private boolean hasPath(TreeNode node, int sum) {
    if (node.val == sum && node.left == null && node.right == null) {
      return true;
    }
    int temp = sum - node.val;
    boolean right = false;
    if (node.right != null) {
      right = hasPath(node.right, temp);
    }
    boolean left = false;
    if (node.left != null) {
      left = hasPath(node.left, temp);
    }
    return right || left;
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
