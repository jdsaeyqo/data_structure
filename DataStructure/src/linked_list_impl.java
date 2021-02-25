

public class linked_list_impl{

	private Node head;
	private Node tail;
	private int size = 0;
	private class Node{
		
		private Object data;
		private Node next;
		public Node(Object data) {
			this.data = data;
			this.next = null;
		}
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		if(head == null){
	        return "[]";
	    }       
	    
	    Node tmp = head;
	    String str = "[";
	    // ���� ��尡 ���� ������ �ݺ����� �����մϴ�.
	    // ������ ���� ���� ��尡 ���� ������ �Ʒ��� ������ ������ ���� ���ܵ˴ϴ�.
	    while(tmp.next != null){
	        str += tmp.data + ",";
	        tmp = tmp.next;
	    }
	    // ������ ��带 ��°���� ���Խ�ŵ�ϴ�.
	    str += tmp.data;
	    return str+"]";
	}
	
	public void addFirst(Object data) {
		
		Node newN = new Node(data);
		
		//���� ���� ����� ���� ��带 head�� ����.
		newN.next = head;
		//��忡 ���� ���� ��带 ����.
		head = newN;
		//����� �÷��ش�.
		size++;
		//ó�� ������ �� tail�� head�� ����.
		if(head.next == null) tail = head;
		
	}
	
	public void addLast(Object data) {
		
		Node newN = new Node(data);
		
		//����Ʈ�� ����ִٸ� addFirst�� ȣ���Ѵ�.
		if(size == 0) addFirst(data);
		else {
		//����Ʈ�� ������� ������ tail�� next�� ���θ��� ��带 ����
			tail.next = newN;
			// tail�� ���� ���� ��带 ����.
			tail = newN;
			
			size++;
		}

	}
	
	private Node node(int idx) {
		Node x = head;
		for (int i = 0; i < idx; i++) {
			x = x.next;
		}
		return x;
	}
	
	public void add(int idx, Object data) {
		
		// 0��° �ε����� ù��°�� �߰��ϴ� ���̹Ƿ� addFirst �޼��� ȣ��
		if(idx == 0) addFirst(data);
		else {
			//k-1��° ��带 tmp1�� ����
			Node tmp1 = node(idx-1);
			//k-1��° ���� ��带 tmp2�� ����
			Node tmp2 = tmp1.next;
			
			Node newN = new Node(data);
			//k-1��° ����� next�� ���� ���� ���� ����
			tmp1.next = newN;
			//���ο� ����� next�� tmp2�� ����
			newN.next = tmp2;
			size++;
			
			//���� ���� ����� next�� null�̸� tail�� newN���� ����
			if(newN.next == null) tail = newN;
		}
	}
	
	public Object removeFirst() {
		//head�� tmp�� ����
		Node tmp = head;
		//tmp�� next�� head�� ����
		head = tmp.next;
		
		//tmp�� data�� ��ȯ �����ͷ� ����
		Object returnData = tmp.data;
		tmp = null;
		size--;
		return returnData;
	}
	
	public Object remove(int idx) {
		if(idx == 0) {
			return removeFirst();
		}
		
		//idx-1��° �ش� ��带 tmp�� ����
		Node tmp = node(idx-1);
		//idx-1 ������ ���(���� ���)�� del�� ����
		Node del = tmp.next;
		//������ ��� ���� ��带 tmp�� next�� ����
		tmp.next = tmp.next.next;
		
		Object returnData = del.data;
		if(del == tail) tail = tmp;
		
		del = null;
		size--;
		return returnData;
		
		
	}
	
	public Object get(int idx) {
		Node tmp = node(idx);
		return tmp.data;
	}
}
