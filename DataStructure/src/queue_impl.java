

public class queue_impl {
	
	private Node front;
	private Node rear;
	
	public queue_impl() {
		this.front = null;
		this.rear = null;
	}

	private class Node{
		
		
		private Object data;
		private Node nextNode;
		
		private Node(Object data){
			this.data = data;
			this.nextNode = null;
		}
		
	}
	

	public boolean empty() {
		return (front == null);
	}
	
	public void insert(Object item) {
		Node n = new Node(item);
		n.nextNode = null;
		
		if(empty()) {
			rear = n;
			front = n;
		}
		else {
			rear.nextNode = n;
			rear = n;
		}
	}
	
	public Object peek() {
		if(empty()) throw new ArrayIndexOutOfBoundsException();
		return front.data;
	}
	
	public Object remove() {
		Object item = peek();
		front = front.nextNode;
		
		if(front == null) rear = null;
		
		return item;
	}
	
}
