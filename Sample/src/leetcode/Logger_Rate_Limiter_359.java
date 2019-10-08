package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Logger_Rate_Limiter_359 {
	/** Initialize your data structure here. */
	Map<String, Integer> map;

	public Logger_Rate_Limiter_359() {
		map = new HashMap<>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. If this method returns false, the message will
	 * not be printed. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage2(int timestamp, String message) {
		if (!map.containsKey(message)) {
			map.put(message, timestamp);
			return true;
		}
		int lastTime = map.get(message);
		if (timestamp - lastTime >= 10) {
			map.put(message, timestamp);
			return true;
		}
		return false;

	}

	public void shouldPrintMessage(int timestamp, String message) {
		System.out.println(shouldPrintMessage2(timestamp, message));
	}

	public static void main(String[] args) {
		Logger_Rate_Limiter_359 obj = new Logger_Rate_Limiter_359();
		obj.shouldPrintMessage(1, "foo");
		obj.shouldPrintMessage(2, "bar");
		obj.shouldPrintMessage(3, "foo");

		obj.shouldPrintMessage(8, "bar");
		obj.shouldPrintMessage(10, "foo");
		obj.shouldPrintMessage(11, "foo");

	}
}
