

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class max_heap {
	
	public static class maxHeap{
		
		private ArrayList<Integer> heap;
		
		public maxHeap() {
			heap = new ArrayList<>();
			heap.add(1000000); // �ε��� 0 �ڸ� ä��� : 1���� �����ϱ� ���ؼ�
			
		}
		
		//����
		public void insert(int data) {
			heap.add(data);
			
			int a = heap.size()-1;
			
			//���� ũ�� -1 �� 1���� �۾��� �� ���� �ݺ� -> root�� ����
			//�ڽ� ��尡 �� ũ�� ��ü
			while(a > 1 && heap.get(a/2) < heap.get(a)) {

				//��ü
				int tmp = heap.get(a/2);
				heap.set(a/2, heap.get(a));
				heap.set(a, tmp);
				
				a = a/2;  // a �� a�� �θ� ��尪���� ����
			}
		}
		
		//����
		public int delete() {
			
			//���� ũ�� -1 �� 1���� ������ 0�� �����Ѵ�.
			if(heap.size()-1 < 1) {
				return 0;
			}
			
			//������ ���� ��Ʈ ���
			int del_data = heap.get(1);
			
			//root�� ���� ������ ���� �ְ� ������ ���� �����Ѵ�.
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
				
				//�θ�� ��ȯ
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