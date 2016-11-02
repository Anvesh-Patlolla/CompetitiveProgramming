package hackerrank.twitter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class ApacheLogSuccessRate {
	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */

		calculate();
		// getDate("27/Sep/2016:05:22:00");
		// System.out.println(getUnixTimeStamp("27/Sep/2016:05:22:00"));
		// System.out.println(getUnixTimeStamp("27/Sep/2016:05:23:00"));
	}

	private static void calculate() {
		TreeMap<Node, Status> map = new TreeMap<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.utc > o2.utc) {
					return 1;
				} else if (o1.utc < o2.utc) {
					return -1;
				} else {
					return o1.endPoint.compareTo(o2.endPoint);
				}
			}
		});
		// HashMap<Node, Status> map = new HashMap<>();

		ArrayList<String> input = inputFromKeyboard();
		// System.out.println("\n" + input.toString());
		for (String line : input) {
			String[] split = line.split(" ");
			// System.out.print(split[3] + ":");
			// System.out.print(split[6]);
			int indexOfQ = split[6].indexOf('?') != -1 ? split[6].indexOf('?') : split[6].length();
			String endpoint = split[6].substring(0, indexOfQ);
			// System.out.print("::+" + split[8]);
			// System.out.println();
			String currentStatus = split[8];
			int currentIntStatus = Integer.parseInt(currentStatus);
			String date = split[3].substring(1);
			Node node = getNode(date, endpoint);
			if (map.containsKey(node)) {
				Status status = map.get(node);
				if (currentIntStatus >= 500 && currentIntStatus <= 599) {
					status.failure++;
				} else {
					status.success++;
				}
			} else {
				Status status = new Status();
				if (currentIntStatus >= 500 && currentIntStatus <= 599) {
					status.failure++;
				} else {
					status.success++;
				}
				map.put(node, status);
			}
		}
		for (Map.Entry<Node, Status> entry : map.entrySet()) {
			float fraction = entry.getValue().success / (float) (entry.getValue().failure + entry.getValue().success)
					* 100;
			// System.out.println(entry.getValue());
			System.out.println(String.format("%s %s %.2f", entry.getKey().date, entry.getKey().endPoint, fraction));
			// ystem.out.println(entry.getValue());
		}

	}

	private static Node getNode(String date, String endpoint) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss");
		Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long utc = parsedDate.getTime() / 60000;
		String newFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(parsedDate);
		newFormat = newFormat.replace(' ', 'T');
		Node node = new Node();
		node.date = newFormat;
		node.utc = utc;
		node.endPoint = endpoint;
		return node;
	}

	public static ArrayList<String> inputFromKeyboard() {
		ArrayList<String> list = new ArrayList<String>();
		InputStreamReader in = null;
		in = new InputStreamReader(System.in);

		BufferedReader br = new BufferedReader(in);
		String s = null;
		try {
			while ((s = br.readLine()) != null) {
				list.add(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}

	public static ArrayList<String> inputFromFile(String fileName) {

		FileReader in = null;
		try {
			in = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(in);
		String s = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			while ((s = br.readLine()) != null) {
				list.add(s);
			}
		} catch (IOException e) {
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return list;
	}

	static class Node {
		@Override
		public String toString() {
			return "Node [date=" + date + ", utc=" + utc + ", endPoint=" + endPoint + "]";
		}

		public String date;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((endPoint == null) ? 0 : endPoint.hashCode());
			result = prime * result + (int) (utc ^ (utc >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (endPoint == null) {
				if (other.endPoint != null)
					return false;
			} else if (!endPoint.equals(other.endPoint))
				return false;
			if (utc != other.utc)
				return false;
			return true;
		}

		public long utc = 0;
		public String endPoint;

	}

	static class Status {
		int success = 0;

		@Override
		public String toString() {
			return "Status [success=" + success + ", failure=" + failure + "]";
		}

		int failure = 0;
	}
}



//Enter your query here.
//
//select 
//   dept.dept_Name,
//   count(stu.student_id) as students
//   from Departments dept left join Students stu
//   on dept.dept_id = stu.dept_id
//   group by dept.dept_id order by students, dept.dept_Name 
