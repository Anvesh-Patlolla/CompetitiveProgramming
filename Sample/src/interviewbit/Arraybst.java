package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class Arraybst {

  public TreeNode sortedArrayToBST(final List<Integer> input) {
    TreeNode root = calculate(input, 0, input.size() - 1);

    return root;
  }

  private TreeNode calculate(List<Integer> input, int start, int end) {
    if (start > end) {
      return null;
    }
    if (start == end) {
      return new TreeNode(input.get(start));
    }
    int mid = (start + end) / 2;
    TreeNode root = new TreeNode(input.get(mid));
    root.left = calculate(input, start, mid - 1);
    root.right = calculate(input, mid + 1, end);
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

  public static void main(String[] args) {
    Arraybst obj = new Arraybst();
    List<Integer> input = new ArrayList<>();
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    for (int i = 0; i < arr.length; i++) {
      input.add(arr[i]);
    }
    TreeNode root = obj.sortedArrayToBST(input);

    System.out.println(root);
    obj.inorder(root);
  }

  private void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    System.out.println(root.val);
    inorder(root.right);

  }

}
