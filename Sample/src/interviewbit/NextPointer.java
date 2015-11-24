package interviewbit;

import java.util.ArrayList;

public class NextPointer {

  class TreeLinkNode {
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
  }

  public void connect(TreeLinkNode root) {
    ArrayList<TreeLinkNode> queue = new ArrayList<>();
    int pointer = 1;
    queue.add(root);
    while (queue.size() != 0) {
      pointer = queue.size();
      for (int i = 0; i < pointer; i++) {
        TreeLinkNode left = queue.get(i).left;
        TreeLinkNode right = queue.get(i).right;
        if (left != null) {
          queue.add(left);
        }
        if (right != null) {
          queue.add(right);
        }
      }
      for (int i = 0; i < pointer; i++) {
        queue.remove(0);
      }

      for (int i = 0; i < queue.size() - 1; i++) {

        queue.get(i).next = queue.get(i + 1);
      }

    }

  }
}
