

import java.util.LinkedList;

public class linkedList {
public static void main(String[] args) {
	
	LinkedList<Integer> list = new LinkedList<Integer>();
	
	//첫번째에 데이터 추가
	list.addFirst(1);
	//마지막에 데이터 추가
	list.addLast(5);
	//add는 마지막에 데이터 추가
	list.add(3);
	list.add(6);
	list.add(9);
	list.add(7);
	//add(idx,data)는 해당 idx에 data 추가
	list.add(1,4);
	
	System.out.println(list);
	
	//peek은 데이터 지우지 않고 반환
	System.out.println(list.peekFirst());
	System.out.println(list.peekLast());
	
	//첫번째 데이터 제거
	list.removeFirst();
	//두번째 데이터 제거
	list.removeLast();
	//remove()는 0번째 idx제거
	list.remove();
	//remove(idx)는 해당 인덱스 제거
	list.remove(2);
	System.out.println(list);
	//리스트 크기
	System.out.println(list.size());
	//get(idx) 해당 인덱스 값 추출
	System.out.println(list.get(2));
	//contains(data) 리스트에 data 있는지 확인후 boolean형태로 반환
	System.out.println(list.contains(5));
	//indexOf(data) 해당 데이터의 인덱스를 반환
	System.out.println(list.indexOf(5));
	
}
}
