

class Node_{
	
	public Node_ root;
	
	private int data;
	private Node_ Left;
	private Node_ Right;
	
	Node_(int data) {
		this.data = data;
		this.Left = null;
		this.Right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node_ getLeft() {
		return Left;
	}

	public void setLeft(Node_ left) {
		Left = left;
	}

	public Node_ getRight() {
		return Right;
	}

	public void setRight(Node_ right) {
		Right = right;
	}
	
	
	
	
}

public class BinarySearchTree {
	
	public Node_ root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	//�˻�
	public Node_ search(int data) {
		
		if(root == null) return null;
		
		Node_ curN = root;
		
		while(curN.getData() != data) {
			
			//���� ���� ã�� ���� ���� ���
			if(curN.getData() == data) return curN;
			
			//���� ��尡 ã�� ������ ū ���
			else if(curN.getData() > data) curN = curN.getLeft();
			
			//���� ��尡 ã�� ������ ���� ���
			else curN = curN.getRight();
				
		}
		return curN;
	}
	
	//����
	public void insert(int data) {
		Node_ newN = new Node_(data);
		
		if(root == null) {
			root = newN;
			return;
		}
		
		Node_ cur_node = root;
		Node_ parent_node = null;
		
		while(true) {
			parent_node = cur_node;
			
			//�����Ͱ� ���� ��庸�� ���� ��
			if(data < cur_node.getData()){
				cur_node = cur_node.getLeft();
				//���� ����� ���� ��尡 ������� �� ���ο� ��带 �־��ش�
				if(cur_node == null) {
					parent_node.setLeft(newN);
					return;
				}
			//�����Ͱ� ���� ��庸�� Ŭ
			}else {
				cur_node = cur_node.getRight();
				//���� ����� ������ ��尡 ������� �� ���ο� ��带 �־��ش�
				if(cur_node == null) {
					parent_node.setRight(newN);
					return;
				}
			}
		}
	}
	
	//��ȸ
	
	//����
	public void inOrderTraverse(Node curN) {
	    if (curN != null) {
	        inOrderTraverse(curN.getLeft());
	        System.out.print(curN.getData() + " ");
	        inOrderTraverse(curN.getRight());
	    }
	}

	//����
	public void preOrderTraverse(Node curN) {
	    if (curN != null) {
	        System.out.print(curN.getData() + " ");
	        preOrderTraverse(curN.getLeft());
	        preOrderTraverse(curN.getRight());
	    }
	}

	//����
	public void postOrderTraverse(Node curN) {
	    if (curN != null) {
	        postOrderTraverse(curN.getLeft());
	        postOrderTraverse(curN.getRight());
	        System.out.print(curN.getData() + " ");
	    }
	}
	
	//����
	public boolean delete(int data) {
		
		
		Node_ parentN = root;
		Node_ curN = root;
		boolean isLeftChild = false;
		
		
		while(curN.getData() != data) {
			parentN = curN;
			
			//���� ��尡 ���� ����� ��
			if(curN.getData() > data) {
				isLeftChild = true;
				curN = parentN.getLeft();
		    //���� ��尡 ������ ����� ��
			}else {
				isLeftChild = false;
				curN = parentN.getRight();
			}
			//ã������ ��� ���� ���
			if(curN == null) return false;
		}
		
		//while���� ������ curN�� ������ ���, parent�� ������ ����� �θ���, isLeftChild�� ������ ��尡 �θ�����
		//left���� right���� boolean���� ������.
		
		Node_ replaceN;
		
		//�ڽ� ��尡 ���� ���
		if(curN.getLeft() == null && curN.getRight() == null ) {
			//�ش� ��尡 root�� ���
			if(curN == root) {
				root = null;
			}
			//������ ��尡 �θ����� ���� �ڽĳ���� ���
			else if(isLeftChild) {
				parentN.setLeft(null);
				
			//������ ��尡 �θ����� ������ �ڽĳ���� ���
			}else {
				parentN.setRight(null);
			}
			
			//�ڽĳ�尡 ������ ��常 ���� ���
		}else if(curN.getRight() == null) {
			
			replaceN = curN.getLeft();
			
			if(curN == root) {
				root = replaceN;
				
			}else if(isLeftChild){
				parentN.setLeft(replaceN);
				
			}else {
				
				parentN.setRight(replaceN);
			}
			
			
			//�ڽĳ�尡 ���� ��常 ���� ���
		}else if(curN.getLeft() == null) {
			
			replaceN = curN.getRight();
			
			if(curN == root) {
				root = replaceN;
				
			}else if(isLeftChild){
				parentN.setLeft(curN.getRight());
				
			}else {
				parentN.setRight(curN.getLeft());
			}
			
			//�ڽĳ�尡 �ΰ��� ���
			//������ �ڽ� ����� subtree ���� ���� ���� ��带 ã�Ƽ� ������� ��尡 �ִ� �ڸ��� ��ġ��Ų��
		}else {
			// ������ ����� ������ sub tree �� �����صд�
			Node_ rightSubTree = curN.getRight();
			
			// ������ ��� �ڸ��� ���� �� ���ο� ��� (������ sub tree���� ���� ���� ���� ���� ���)
			// �� ���� ���� child �� ����� �Ѵ�.
			replaceN = rightMin(curN.getRight());
			
			if(curN == root) {
				root = replaceN;
			}else if(isLeftChild) {
				parentN.setLeft(replaceN);
			}else {
				parentN.setRight(replaceN);
			}
			
			replaceN.setRight(rightSubTree);
			
			//������� ����� ������ ����Ʈ���� ��尡 �ϳ��ۿ� ���� ���
			if(replaceN == rightSubTree) {
				replaceN.setRight(null);
			}
			
			replaceN.setLeft(curN.getLeft());
	    
			
		}
		return true;
			
	}

	private Node_ rightMin(Node_ rightChild) {
		
		Node_ parentN = rightChild;
		Node_ curN = rightChild;
		
		while(curN.getLeft() != null) {
			parentN = curN;
			curN = curN.getLeft();
		}
		
		parentN.setLeft(null);
		
		
		return curN;
	}

	public static void main(String[] args) {
		
		
		
	}
	}

