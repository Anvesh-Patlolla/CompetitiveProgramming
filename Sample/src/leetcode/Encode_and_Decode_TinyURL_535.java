package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Encode_and_Decode_TinyURL_535 {

	AtomicLong counter = new AtomicLong();
	Map<Long, String> map = new HashMap<>();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		long currentCount = counter.incrementAndGet();
		map.put(currentCount, longUrl);

		return Long.toString(currentCount, 64);
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		Long index = Long.parseLong(shortUrl, 64);

		return map.get(index);
	}

	public static void main(String[] args) {
		System.out.println(Long.toString(1010, 32));
		System.out.println(Long.parseLong("vi", 32));

	}
}
