package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class AllOoneDataStructure_432 {
	HashMap<String, Integer> dataMap = null;
	TreeMap<Integer, Set<String>> ascendingValueMap = null;

	/** Initialize your data structure here. */
	public AllOoneDataStructure_432() {
		dataMap = new HashMap<>();
		ascendingValueMap = new TreeMap<>();
	}

	/**
	 * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
	 */
	public void inc(String key) {
		Integer value = dataMap.get(key);
		if (dataMap.containsKey(key)) {
			value = dataMap.get(key);
		} else {
			value = 1;
		}
		int postInstruction = value + 1;
		instruct(key, value, postInstruction);
	}

	private void instruct(String key, int value, int postInstruction) {
		dataMap.put(key, postInstruction);
		Set<String> set = ascendingValueMap.get(value);

		if (set != null) {
			set.remove(key);
		}
		if (ascendingValueMap.containsKey(postInstruction)) {
			Set<String> set2 = ascendingValueMap.get(postInstruction);
			set2.add(key);
		} else {
			HashSet<String> set2 = new HashSet<>();
			set2.add(key);
			ascendingValueMap.put(postInstruction, set2);
		}
	}

	/**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the
	 * data structure.
	 */
	public void dec(String key) {
		Integer value = dataMap.get(key);
		if (dataMap.containsKey(key)) {
			value = dataMap.get(key);
		} else {
			return;
		}
		int postInstruction = value - 1;
		instruct(key, value, postInstruction);
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {

		return null;
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {

		Iterator<Entry<Integer, Set<String>>> iterator = ascendingValueMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, Set<String>> entry = iterator.next();
			if (entry.getValue().size() == 0) {
				iterator.remove();
			} else {
				Set<String> value = entry.getValue();
				Iterator<String> iterator2 = value.iterator();
				String retVal = iterator2.next();
				return retVal;
			}
		}
		return null;

	}

	public static void main(String[] args) {
		AllOoneDataStructure_432 obj = new AllOoneDataStructure_432();
		obj.inc("test");
		obj.inc("test");
		obj.inc("test");
		obj.inc("test");
		obj.inc("test");
		obj.inc("test1");

		obj.inc("test4");
		obj.inc("test1");
		obj.inc("test2");
		obj.inc("test2");
		obj.inc("test2");
		obj.inc("test2");
		System.out.println(obj.getMinKey());
		obj.dec("test4");
		obj.dec("test1");
		System.out.println(obj.getMinKey());
	}
}

/**
 * Your AllOne object will be instantiated and called as such: AllOne obj = new
 * AllOne(); obj.inc(key); obj.dec(key); String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
