package hackerrank.wepay;

import java.io.*;
import java.util.*;

public class MyHashtable<K, V> {
  public static void main(String args[]) throws Exception {
    new TestHarness(new MyHashtable<String, String>()).run();
  }

  private int initialCapacity = 42; // Why 42? Because it is the answer to question of universe,
                                    // life, and everything.

  public MyHashtable(int initialCapacity) {
    this.initialCapacity = initialCapacity;
    // TODO: add loadfactor logic, if time permits.
    init();
  }

  LinkedList<Node<K, V>> table[] = null;

  class Node<T, U> {
    T key;
    U value;

    public Node(T key, U value) {
      this.key = key;
      this.value = value;
    }
  }

  @SuppressWarnings("unchecked")
  void init() {
    table = new LinkedList[initialCapacity];
  }

  public MyHashtable() {
    init();
  }

  public void put(K key, V value) {
    // TODO implement
    if (key == null || value == null) {
      if (key == null) {
        throw new IllegalArgumentException("Key parameter is NULL, it is not allowed");
      } else {
        throw new IllegalArgumentException("Value parameter is NULL, it is not allowed");
      }
    }
    int hashcode = key.hashCode();
    insertKey(key, value, hashcode);

  }

  private void insertKey(K key, V value, int hashcode) {
    int index = hashcode % initialCapacity;
    if (get(key) != null) {
      LinkedList<Node<K, V>> list = table[index];
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).key.equals(key)) {
          list.get(i).value = value;
          return;
        }
      }
    } else {
      if (table[index] == null) {
        table[index] = new LinkedList<>();
      }
      Node<K, V> node = new Node<>(key, value);
      LinkedList<Node<K, V>> list = table[index];
      list.add(node);
    }

  }

  public V get(K key) {
    if (key == null) {
      throw new IllegalArgumentException("Key parameter is NULL, it is not allowed");
    }
    int hashcode = key.hashCode();
    int index = hashcode % initialCapacity;
    LinkedList<Node<K, V>> list = table[index];
    if (list == null) {
      return null;
    }
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).key.equals(key)) {
        return list.get(i).value;
      }
    }

    return null;
  }


  /**
   * A helper class that tests MyHashtable by feeding it puts and gets from STDIN.
   */
  public static class TestHarness implements Runnable {

    final MyHashtable<String, String> hashtable;

    public TestHarness(MyHashtable<String, String> hashtable) {
      this.hashtable = hashtable;
    }

    public void run() {
      Scanner scanner = new Scanner(System.in);
      while (scanner.hasNext()) {
        String k = scanner.next();
        String v = null;
        if (k.contains("=")) {
          String[] split = k.split("\\=");
          k = split[0];
          if (split.length == 1) {
            v = null;
          } else {
            v = split[1];
          }
        }
        if (v == null) {
          System.out.println(hashtable.get(k));
        } else {
          hashtable.put(k, v);
        }
      }
    }
  }
}
