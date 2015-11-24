package interviewbit;

public class INVERT {

  public TreeNode invertTree(TreeNode root) {
    TreeNode r = invert(root);
    return r;
  }

  private TreeNode invert(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode l = invert(root.left);
    TreeNode r = invert(root.right);
    root.left = r;
    root.right = l;

    return root;


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
