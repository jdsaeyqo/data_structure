

import java.util.ArrayList;
import java.util.PriorityQueue;

public class min_heap{

	public static class minHeap{
		
		private ArrayList<Integer> heap;
		
		public minHeap() {
			heap = new ArrayList<>();
			heap.add(0); // 0 ä��� : 1���� �����ϱ� ���ؼ�
			
		}
		
		//����
		public void insert(int data) {
			heap.add(data);
			
			int a = heap.size()-1;
			
			//���� ũ�� -1 �� 1���� �۾��� �� ���� �ݺ� -> root�� ����
			
			while(a > 1 && heap.get(a/2) > heap.get(a)) {
//				System.out.println("��ü");
				
				//�θ𺸴� �ڽ� ��尡 ������ ��ü�ؾ� �Ѵ�. �ּ����� ����� ����
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
				
				int min = heap.get(idx*2);
				int minidx =idx*2;
				
				if(minidx+1 < heap.size() && min > heap.get(minidx+1)) {
					min = heap.get(minidx+1);
					minidx++;
				}
				
				if(heap.get(idx) < min) {
					break;
				}
				
				//�θ�� ��ȯ
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
