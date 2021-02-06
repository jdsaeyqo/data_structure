

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class max_heap {
	
	public static class maxHeap{
		
		private ArrayList<Integer> heap;
		
		public maxHeap() {
			heap = new ArrayList<>();
			heap.add(1000000); // 인덱스 0 자리 채우기 : 1부터 시작하기 위해서
			
		}
		
		//삽입
		public void insert(int data) {
			heap.add(data);
			
			int a = heap.size()-1;
			
			//힙의 크기 -1 이 1보다 작아질 때 까지 반복 -> root에 도달
			//자식 노드가 더 크면 교체
			while(a > 1 && heap.get(a/2) < heap.get(a)) {

				//교체
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
				
				int max = heap.get(idx*2);
				int maxidx =idx*2;
				
				if(maxidx+1 < heap.size() && max < heap.get(maxidx+1)) {
					max = heap.get(maxidx+1);
					maxidx++;
				}
				
				if(heap.get(idx) > max) {
					break;
				}
				
				//부모와 교환
				int tmp = heap.get(idx);
				heap.set(idx, heap.get(maxidx));
				heap.set(maxidx, tmp);
				idx = maxidx;
			}
			return del_data;
		}
	
	}
	
public static void main(String[] args) {
		
	maxHeap maxHeap = new maxHeap();
	maxHeap.insert(3);
	maxHeap.insert(1);
	maxHeap.insert(7);
	maxHeap.insert(6);
	System.out.println(maxHeap.heap.get(1));
	
	PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>(Collections.reverseOrder());
	
	max_heap.add(1);
	max_heap.add(6);
	max_heap.add(3);
	max_heap.add(8);
	
	System.out.println(max_heap.poll());
		
	
	}
}