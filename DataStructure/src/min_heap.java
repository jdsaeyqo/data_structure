

import java.util.ArrayList;
import java.util.PriorityQueue;

public class min_heap{

	public static class minHeap{
		
		private ArrayList<Integer> heap;
		
		public minHeap() {
			heap = new ArrayList<>();
			heap.add(0); // 0 채우기 : 1부터 시작하기 위해서
			
		}
		
		//삽입
		public void insert(int data) {
			heap.add(data);
			
			int a = heap.size()-1;
			
			//힙의 크기 -1 이 1보다 작아질 때 까지 반복 -> root에 도달
			
			while(a > 1 && heap.get(a/2) > heap.get(a)) {
//				System.out.println("교체");
				
				//부모보다 자식 노드가 작으면 교체해야 한다. 최소힙을 만들기 위해
				int tmp = heap.get(a/2);
				heap.set(a/2, heap.get(a));
				heap.set(a, tmp);
				
				a = a/2;  // a 는 a의 부모 노드값으로 변경
			}
		}
		
		//삭제
		public int delete() {
			
			//힙의 크기 -1 이 1보다 작으면 0을 리턴한다.
			if(heap.size()-1 < 1) {
				return 0;
			}
			
			//삭제할 노드는 루트 노드
			int del_data = heap.get(1);
			
			//root에 가장 마지막 값을 넣고 마지막 값을 삭제한다.
			heap.set(1, heap.get(heap.size()-1));
			heap.remove(heap.size()-1);
			
			int idx = 1;
			while( idx*2 < heap.size()) {
				
				int min = heap.get(idx*2);
				int minidx =idx*2;
				
				if(minidx+1 < heap.size() && min > heap.get(minidx+1)) {
					min = heap.get(minidx+1);
					minidx++;
				}
				
				if(heap.get(idx) < min) {
					break;
				}
				
				//부모와 교환
				int tmp = heap.get(idx);
				heap.set(idx, heap.get(minidx));
				heap.set(minidx, tmp);
				idx = minidx;
			}
			return del_data;
		}
	
	}
	
	public static void main(String[] args) {
		
		minHeap m = new minHeap();
		m.insert(11);
		m.insert(2);
		m.insert(8);
		System.out.println(m.heap.get(1));
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		minHeap.add(4);
		minHeap.add(1);
		minHeap.add(9);
		minHeap.add(8);
		
		System.out.println(minHeap.poll());
	}
}
