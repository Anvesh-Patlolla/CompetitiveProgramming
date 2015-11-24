package interviewbit;


public class MAXDEPTH {
  int maxDepth(TreeNode root, TreeNode node) {
    if (node == null || node == root) {
      return 0;
    }
    int retVal = maxDepth(root, node, 0);
    return retVal;
  }

  private int maxDepth(TreeNode root, TreeNode node, int dept) {
    if (node == null) {
      return 0;
    }
    if (root == node) {
      return dept;
    }
    int l = maxDepth(root.left, node, dept + 1);
    int r = maxDepth(root.right, node, dept + 1);
    if (l != 0) {
      return l;
    } else {
      return r;
    }
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
