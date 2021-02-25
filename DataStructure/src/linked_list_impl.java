

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
	    // 다음 노드가 없을 때까지 반복문을 실행합니다.
	    // 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됩니다.
	    while(tmp.next != null){
	        str += tmp.data + ",";
	        tmp = tmp.next;
	    }
	    // 마지막 노드를 출력결과에 포함시킵니다.
	    str += tmp.data;
	    return str+"]";
	}
	
	public void addFirst(Object data) {
		
		Node newN = new Node(data);
		
		//새로 만든 노드의 다음 노드를 head로 지정.
		newN.next = head;
		//헤드에 새로 만든 노드를 지정.
		head = newN;
		//사이즈를 늘려준다.
		size++;
		//처음 들어왔을 시 tail도 head로 지정.
		if(head.next == null) tail = head;
		
	}
	
	public void addLast(Object data) {
		
		Node newN = new Node(data);
		
		//리스트가 비어있다면 addFirst를 호출한다.
		if(size == 0) addFirst(data);
		else {
		//리스트가 비어있지 않으면 tail의 next를 새로만든 노드를 지정
			tail.next = newN;
			// tail에 새로 만든 노드를 지정.
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
		
		// 0번째 인덱스는 첫번째에 추가하는 것이므로 addFirst 메서드 호출
		if(idx == 0) addFirst(data);
		else {
			//k-1번째 노드를 tmp1로 지정
			Node tmp1 = node(idx-1);
			//k-1번째 다음 노드를 tmp2로 지정
			Node tmp2 = tmp1.next;
			
			Node newN = new Node(data);
			//k-1번째 노드의 next를 새로 만든 노드로 지정
			tmp1.next = newN;
			//새로운 노드의 next를 tmp2로 지정
			newN.next = tmp2;
			size++;
			
			//새로 만든 노드의 next가 null이면 tail을 newN으로 지정
			if(newN.next == null) tail = newN;
		}
	}
	
	public Object removeFirst() {
		//head를 tmp로 지정
		Node tmp = head;
		//tmp의 next를 head로 지정
		head = tmp.next;
		
		//tmp의 data를 반환 데이터로 지정
		Object returnData = tmp.data;
		tmp = null;
		size--;
		return returnData;
	}
	
	public Object remove(int idx) {
		if(idx == 0) {
			return removeFirst();
		}
		
		//idx-1번째 해당 노드를 tmp로 지정
		Node tmp = node(idx-1);
		//idx-1 다음의 노드(지울 노드)를 del에 지정
		Node del = tmp.next;
		//삭제된 노드 다음 노드를 tmp의 next로 지정
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
