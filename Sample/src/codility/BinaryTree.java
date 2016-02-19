package codility;

public class BinaryTree {
  public static void main(String[] args) {

  }

  int solution(Tree root) {
    if (root == null) {
      return 0;
    }
    int retVal = recursiveInorder(root, Integer.MIN_VALUE);
    return retVal;
  }

  private int recursiveInorder(Tree root, int minVal) {
    if (root == null) {
      return 0;
    }
    int retVal = 0;
    if (root.x >= minVal) {
      retVal++;
    }
    int max = root.x > minVal ? root.x : minVal;
    int left = recursiveInorder(root.l, max);
    int right = recursiveInorder(root.r, max);
    return retVal + left + right;
  }

  class Tree {
    Tree l;
    Tree r;
    int x;
  }
}
