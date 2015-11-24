package interviewbit;


public class KTHSMALLEST2 {

  int retVal = -1;

  int count = 0;


  public int kthsmallest(TreeNode root, int k) {
    count = k;
    inOrderTraversal(root);

    return retVal;
  }

  private void inOrderTraversal(TreeNode node) {
    if (node == null) {
      return;
    }

    inOrderTraversal(node.left);
    count--;
    if (count == 0) {
      retVal = node.val;
      return;
    }

    inOrderTraversal(node.right);
  }

  class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode next;
    int val;
  }
}
