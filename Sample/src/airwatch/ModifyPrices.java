package airwatch;

import java.util.HashMap;

public class ModifyPrices {
	static int verifyItems(String[] origItems, float[] origPrices, String[] items, float[] prices) {
		HashMap<String, Float> map = new HashMap<>();
		for (int i = 0; i < origItems.length; i++) {
			map.put(origItems[i], origPrices[i]);
		}
		int retVal = 0;
		for (int i = 0; i < items.length; i++) {
			if (map.get(items[i]) != prices[i]) {
				retVal++;
			}
		}
		return retVal;
	}

	public static void main(String[] args) {
		String[] origItems = { "rice", "sugar", "wheat", "cheese" };
		float[] origPrices = { 16.89f, 56.92f, 20.89f, 345.99f };
		String[] items = { "rice", "wheat", "sugar" };
		float[] prices = { 16.99f, 20.89f, 55.92f };
		System.out.println(verifyItems(origItems, origPrices, items, prices));
	}
}
