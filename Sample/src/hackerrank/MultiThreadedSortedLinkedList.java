package hackerrank;

public class MultiThreadedSortedLinkedList {

	private Node globalHead = null;
	private final Object LOCK = new Object();

	public void init() {
		globalHead = new Node(Integer.MIN_VALUE);
	}

	public void insert(int data) {
		Node temp = globalHead;
		Node node = new Node(data);
		while (temp.next != null && temp.next.data < data) {
			temp = temp.next;
		}
		synchronized (temp) {
			while (temp.next != null && temp.next.data < data) {
				temp = temp.next;
			}
			node.next = temp.next;
			temp.next = node;
		}

		return;
	}

	public static void main(String[] args) {
		MultiThreadedSortedLinkedList linkedList = new MultiThreadedSortedLinkedList();
		linkedList.init();
		linkedList.insert(1);
		linkedList.insert(10);
		linkedList.insert(9);
		linkedList.insert(7);
		linkedList.insert(3);
		linkedList.insert(200);
		linkedList.display();

	}

	public void display() {
		Node temp = globalHead;
		temp = temp.next;
		while (temp != null) {
			System.out.print("," + temp.data);
			temp = temp.next;
		}
	}

	public void validate() {
		Node temp = globalHead;
		int prev = temp.data;
		temp = temp.next;
		while (temp != null) {
			int current = temp.data;
			if (prev > current) {
				System.out.println("ERROR !!");
				return;
			}
			temp = temp.next;
		}
		display();
	}

	private static class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

}
