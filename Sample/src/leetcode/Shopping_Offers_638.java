package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/*
 * In LeetCode Store, there are some kinds of items to sell. Each item has a price.

However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

You are given the each item's price, a set of special offers, and the number we need to buy for each item. The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.

Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer, other numbers represents how many specific items you could get if you buy this offer.

You could use any of special offers as many times as you want.
 */
public class Shopping_Offers_638 {
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		Map<List<Integer>, Integer> map = new HashMap<>();
		int current[] = new int[price.size()];
		calculate(map, price, special, needs, current);
		return 0;
	}

	private Integer calculate(Map<List<Integer>, Integer> map, List<Integer> price, List<List<Integer>> special,
			List<Integer> needs, int[] current) {
		if (map.containsKey(needs)) {
			return map.get(needs);
		}
		List<List<Integer>> validOffers = containsOffers(current, special);
		if (!validOffers.isEmpty()) {
			
		}

		return 0;
	}

	private List<List<Integer>> containsOffers(int[] current, List<List<Integer>> special) {
		List<List<Integer>> validOffers = new ArrayList<>();
		for (List<Integer> offer : special) {
			boolean isValidOffer = true;
			for (int i = 0; i < offer.size(); i++) {
				if (current[i] - offer.get(i) < 0) {
					isValidOffer = false;
					break;
				}
			}
			if (isValidOffer) {
				validOffers.add(offer);
			}
		}
		return validOffers;
	}
}
