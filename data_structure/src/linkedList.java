

import java.util.LinkedList;

public class linkedList {
public static void main(String[] args) {
	
	LinkedList<Integer> list = new LinkedList<Integer>();
	
	//ù��°�� ������ �߰�
	list.addFirst(1);
	//�������� ������ �߰�
	list.addLast(5);
	//add�� �������� ������ �߰�
	list.add(3);
	list.add(6);
	list.add(9);
	list.add(7);
	//add(idx,data)�� �ش� idx�� data �߰�
	list.add(1,4);
	
	System.out.println(list);
	
	//peek�� ������ ������ �ʰ� ��ȯ
	System.out.println(list.peekFirst());
	System.out.println(list.peekLast());
	
	//ù��° ������ ����
	list.removeFirst();
	//�ι�° ������ ����
	list.removeLast();
	//remove()�� 0��° idx����
	list.remove();
	//remove(idx)�� �ش� �ε��� ����
	list.remove(2);
	System.out.println(list);
	//����Ʈ ũ��
	System.out.println(list.size());
	//get(idx) �ش� �ε��� �� ����
	System.out.println(list.get(2));
	//contains(data) ����Ʈ�� data �ִ��� Ȯ���� boolean���·� ��ȯ
	System.out.println(list.contains(5));
	//indexOf(data) �ش� �������� �ε����� ��ȯ
	System.out.println(list.indexOf(5));
	
}
}
