package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class InsertDeleteGetRandom_380 {
	/** Initialize your data structure here. */
	HashMap<Integer, Integer> map;
	ArrayList<Integer> list;

	public void RandomizedSet() {
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		list.add(val);
		map.put(val, list.size() - 1);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int index = map.get(val);
		if (index + 1 == list.size()) {
			map.remove(val);
			list.remove(list.size() - 1);
		} else {
			int replaceVal = list.get(list.size() - 1);
			list.set(index, replaceVal);
			map.put(replaceVal, index);
			map.remove(val);
			list.remove(list.size() - 1);
		}
		return true;

	}

	/** Get a random element from the set. */
	public int getRandom() {
		int index = (int) (java.lang.Math.random() * list.size());
		return list.get(index);
	}

}
