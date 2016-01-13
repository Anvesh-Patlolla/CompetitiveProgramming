package datastructures.btree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Spliterator;

public class BTREE<K extends Comparable<K>> {

  BTREE<K> nodes[] = null;
  boolean isLeaf;
  ArrayList<K> keys;
  int D = 0;

  BTREE(int d) {
    isLeaf = true;
    D = d;
    nodes = new BTREE[2 * d + 1];
    keys = new ArrayList<>(); // max 2*D size.
  }

  public void insert(K value, BTREE<K> parent) {
    if (isLeaf) {
      int index = 0;
      for (index = 0; index < keys.size(); index++) {
        if (keys.get(index) == null) {
          break;
        }
      }
      if (index < 2 * D - 1) {
        keys.add(value);
        Collections.sort(keys);
      } else {
        keys.add(value);
        Collections.sort(keys);
        splitLeaf(parent);
      }
    } else {
      
    }
    
  }

  private void splitLeaf(BTREE<K> parent) {
    
    
  }
}
