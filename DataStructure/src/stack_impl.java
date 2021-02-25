

import java.util.EmptyStackException;

public class stack_impl {

	private static class Node{
		private int data;
		private Node next;
		private Node(int data) {
			this.data = data;
		}
	}
	
	
	private Node top;
	
	public boolean isEmpty() {
		
		return (top == null);
	}
	
	public int peek() {
		
		if(isEmpty()) throw new EmptyStackException();
		return top.data;
	}
	
	public void push(int data) {
		Node n = new Node(data);
		n.next = top;
		top = n;
	}
	public int pop() {
		if(isEmpty()) throw new EmptyStackException();
		
		int data = top.data;
		top = top.next;
		return data;
	}
}
