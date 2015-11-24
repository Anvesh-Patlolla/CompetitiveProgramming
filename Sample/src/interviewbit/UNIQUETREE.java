package interviewbit;

import java.util.ArrayList;

public class UNIQUETREE {

  public ArrayList<TreeNode> generateTrees(int input) {
    ArrayList<TreeNode> retList = null;

    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 1; i <= input; i++) {
      list.add(i);
    }
    retList = new ArrayList<TreeNode>();
    // calculate(list, null);
    buildTree(list, null, retList);
    return retList;

  }


  private ArrayList<Integer> removeElementCreateList(ArrayList<Integer> list, int k) {
    ArrayList<Integer> retList = new ArrayList<Integer>();
    for (int i = 0; i < list.size(); i++) {
      if (i != k) {
        retList.add(list.get(i));
      }
    }
    return retList;
  }

  private void buildTree(ArrayList<Integer> list, TreeNode node, ArrayList<TreeNode> retList) {
    if (list.size() == 0) {
      retList.add(node);
      return;
    }
    for (int i = 0; i < list.size(); i++) {
      TreeNode temp = copyTree(node);
      temp = insert(temp, list.get(i));
      ArrayList<Integer> li = removeElementCreateList(list, i);
      buildTree(li, temp, retList);
    }


  }

  private TreeNode copyTree(TreeNode node) {
    if (node == null) {
      return null;
    }
    return copyTreeInorder(node);

  }


  TreeNode copyTreeInorder(TreeNode node) {
    if (node == null) {
      return null;
    }
    TreeNode constructTree = new TreeNode(node.val);
    constructTree.left = copyTreeInorder(node.left);
    constructTree.right = copyTreeInorder(node.right);
    return constructTree;
  }


  TreeNode insert(TreeNode node, int val) {
    if (node == null) {
      TreeNode temp = new TreeNode(val);
      return temp;
    }
    if (val > node.val) {
      node.left = insert(node.left, val);
      return node;
    } else {
      node.right = insert(node.right, val);
      return node;
    }

  }


  /**
   * Definition for binary tree
   */
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    UNIQUETREE obj = new UNIQUETREE();
    ArrayList<TreeNode> retVal = obj.generateTrees(3);
    obj.display(retVal);
  }


  private void display(ArrayList<TreeNode> retVal) {
    for (TreeNode node : retVal) {
      postOrderTraversal(node);
      System.out.println();
    }
  }


  private void postOrderTraversal(TreeNode node) {
    if (node == null) {
      return;
    }
    postOrderTraversal(node.left);
    postOrderTraversal(node.right);
    System.out.print(node.val + " ");
  }


}
