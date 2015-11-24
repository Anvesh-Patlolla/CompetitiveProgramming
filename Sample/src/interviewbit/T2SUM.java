package interviewbit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class T2SUM {

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  HashMap<Integer, Integer> map = null;

  public int t2Sum(TreeNode A, int B) {
    map = new HashMap<>();
    inorder(A, map);
    boolean flag = false;
    // System.out.println(map.toString());

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();

      if (B % key == 0 && B / key == 2) {
        if (value == 2) {
          return 1;
        }
      } else {
        if (map.containsKey(B - key)) {
          return 1;
        }
      }

      /*
       * 
       * if (B % key == 0) { if (2 <= value) { return 1; } else if (map.containsKey(B - key)) {
       * return 1; }
       * 
       * } if (B % key != 0 && map.containsKey(B - key)) { return 1; }
       */
    }

    return 0;
  }

  private void inorder(TreeNode a, HashMap<Integer, Integer> map) {
    if (a == null) {
      return;
    }
    inorder(a.left, map);
    int key = a.val;
    if (map.containsKey(key)) {
      map.put(key, map.get(key) + 1);
    } else {
      map.put(key, 1);
    }
    inorder(a.right, map);

  }
}
