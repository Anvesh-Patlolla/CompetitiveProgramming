package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class KillProcess_582 {

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		ArrayList<Integer> list = new ArrayList<>();

		HashMap<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < pid.size(); i++) {
			if (map.containsKey(ppid.get(i))) {
				List<Integer> li = map.get(ppid.get(i));
				li.add(pid.get(i));
			} else {
				List<Integer> li = new ArrayList<Integer>();
				li.add(pid.get(i));
				map.put(ppid.get(i), li);
			}
		}

		Queue<Integer> queue = new LinkedBlockingQueue<>();
		queue.add(kill);
		while (!queue.isEmpty()) {
			int process = queue.poll();
			list.add(process);
			List<Integer> processList = map.get(process);
			for (int i = 0; processList != null && i < processList.size(); i++) {
				queue.add(processList.get(i));
			}
		}
		return list;
	}

	public static void main(String[] args) {
		KillProcess_582 obj = new KillProcess_582();
		Integer[] pid1 = new Integer[] { 1, 3, 10, 5 };
		Integer[] ppid1 = new Integer[] { 3, 0, 5, 3 };

		List<Integer> pid = Arrays.asList(pid1);

		List<Integer> ppid = Arrays.asList(ppid1);
		obj.killProcess(pid, ppid, 5);
	}
}
