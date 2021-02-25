

import java.util.Stack;

public class stack {
	
public static void main(String[] args) {

	Stack<Integer> stack = new Stack<>();
	
	stack.push(3);
	stack.add(4);
	stack.push(12);
	stack.push(7);
	stack.pop();
	stack.add(9);
	stack.push(5);
	stack.pop();
	
	
	System.out.println(stack.isEmpty());
	System.out.println(stack.search(12));
	System.out.println(stack.peek());
	
	while(!stack.isEmpty()) {
		System.out.print(stack.pop()+" ");
	}
	
	System.out.println();

	
	
	
	
}
}
