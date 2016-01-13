package Practise;

public class BST<T extends Comparable> {
  private final String LOG_TAG = BST.class.getSimpleName();

  BST() {
    left = null;
    right = null;
    data = null;
  }

  private BST left;
  private BST right;

  private static BST root = null;
  private T data;

  public void insert(T data) {
    root = insert(root, data);
  }

  private BST insert(BST node, T data) {
   Log.d(LOG_TAG, "inside insert "+node);
    if (node == null) {
      node = new BST();
      node.data = data;
      return node;
    } else {
      if (node.data.compareTo(data) < 0) {
        node.right = insert(node.right, data);
      } else {
        node.left = insert(node.left, data);
      }
      return node;
    }
  }

  public void display() {
    display(root);
  }

  private void display(BST node) {
    //Log.d(LOG_TAG,"inside display()");
    if (node == null) {
      return;
    }
    display(node.left);
    System.out.println("  " + node.data);
    display(node.right);
  }

  public boolean delete(BST node) {
    return true;
  }

  public static void main(String[] args) {
    // Driver method.
    BST<Integer> test = new BST<Integer>();
    test.insert(new Integer(1));
    test.insert(22);
    test.insert(3);
    test.insert(4);
    test.insert(5);
    test.insert(6);
    test.insert(7);
    test.display();
  }
}
