package interviewbit;

import java.util.LinkedHashMap;

public class LRU {

  LRUImpl<Integer,Integer> lru = null;

  // Solution
  public LRU(int capacity) {
    lru = new LRUImpl<Integer,Integer>(capacity);
  }

  public int get(int key) {

    return lru.get(key) != null ? lru.get(key) : -1;
  }

  public void set(int key, int value) {
    lru.put(key, value);
  }

  class LRUImpl<K, V> extends LinkedHashMap<K, V> {
    int capacity = 0;

    LRUImpl(int capcity) {
      super(capcity, 1.0f, true);
      this.capacity = capcity;

    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
      return size() > capacity;
    }
  }

  public static void main(String[] args) {
    int capacity = 2;
    LRU obj = new LRU(capacity);
    int key = -1;
    int value = -1;
    // for (int i = 0; i < 20; i++) {
    // key = i;
    // value = i;
    // obj.set(key, value);
    // System.out.println(obj.lru);
    // System.out.println(obj.get(1));
    // }

    // S 2 1 S 1 1 S 2 3 S 4 1 G 1 G 2
    obj.set(2, 1);
    System.out.println(obj.lru);
    obj.set(1, 1);

    System.out.println(obj.lru);
    obj.set(2, 3);

    System.out.println(obj.lru);
    obj.set(4, 1);

    System.out.println(obj.lru);
    System.out.println(obj.get(1));

    System.out.println(obj.lru);
    System.out.println(obj.get(2));
  }
}
