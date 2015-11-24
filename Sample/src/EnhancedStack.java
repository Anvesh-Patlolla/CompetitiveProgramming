import java.util.Scanner;
import java.util.Stack;

class EnhancedStack extends Stack<Integer> {
	Stack<Integer> minStack;

	public EnhancedStack() {
		minStack = new Stack<Integer>();
	}

	public void push(int value) {
		if (value < min()) {
			minStack.push(value);
		}
		super.push(value);
	}

	public int min() {
		if (minStack.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return minStack.peek();
	}

	public Integer pop() {
		if (super.peek() == minStack.peek()) {
			minStack.pop();
		}
		return super.pop();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String s1 = s.nextLine();
		System.out.println(s1);
		EnhancedStack es = new EnhancedStack();
		es.push(1);
		es.push(3);
		System.out.println(es.min());
		

	}

}