

import java.util.ArrayDeque;
import java.util.Deque;

public class deque {
public static void main(String[] args) {
	
	Deque<Integer> deque = new ArrayDeque<>();
	
	deque.addFirst(1);
	deque.addFirst(4);
	deque.offer(3);
	deque.add(5);
	deque.add(2);
	deque.addLast(6);
	
	System.out.println(deque);
	System.out.println(deque.poll());
	System.out.println(deque.pollFirst());
	System.out.println(deque.pollLast());
	
	System.out.println(deque);
	System.out.println(deque.peekFirst());
	System.out.println(deque.peekLast());
	System.out.println(deque);
	
	
	

}
}
