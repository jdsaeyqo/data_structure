

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class queue {
public static void main(String[] args) {
	
Queue<Integer> queue = new LinkedList<>();
	
	queue.add(1);
	queue.offer(7);
	queue.add(6);
	queue.offer(9);
	queue.remove();
	queue.offer(11);
	queue.offer(4);
	queue.poll();
	
	System.out.println(queue.peek());
	
	while(!queue.isEmpty()) {
		System.out.print(queue.poll()+" ");
	}
	System.out.println();
	
Queue<Integer> q = new PriorityQueue<>();
	
	q.offer(3);
	q.offer(1);
	q.offer(5);
	q.offer(2);
	q.offer(4);
	System.out.println(q);
}
}
