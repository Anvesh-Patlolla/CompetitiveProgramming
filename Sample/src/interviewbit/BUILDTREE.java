package interviewbit;

public class BUILDTREE {
  // Add to A
  public int cntMatrix(TreeNode A, TreeNode B) {
    int retVal = postOrder(A, B);

    return retVal;

  }

  private int postOrder(TreeNode a, TreeNode b) {
    if (a == null && b == null) {
      return 0;
    }
    if (a == null || b == null) {
      if (a == null) {
        return calculateNodes(b);
      } else {
        return -1;
      }
    }
    int left = postOrder(a.left, b.left);
    int right = postOrder(a.right, b.right);
    if (left == -1 || right == -1) {
      return -1;
    } else {
      return left + right;
    }
  }

  private int calculateNodes(TreeNode b) {
    if (b == null) {
      return 0;
    }
    int right = calculateNodes(b.right);
    int left = calculateNodes(b.left);

    return right + left + 1;
  }
  public static void main(String[] args) {
    
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
