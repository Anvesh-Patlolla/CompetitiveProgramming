package interviewbit;

public class SAMETREE {

  public int isSameTree(TreeNode a, TreeNode b) {
    int retVal = postOrder(a, b);
    return retVal>0?1:0;
  }

  private int postOrder(TreeNode a, TreeNode b) {
    if (a == null && b == null) {
      return 1;
    }
    if (a == null || b == null) {
      return -1;
    }
    if (a.val != b.val) {
      return -1;
    }
    int l = postOrder(a.left, b.left);
    int r = postOrder(a.right, b.right);
    if( l == -1 || r == -1){
      return -1;
    }
    return 1;
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
