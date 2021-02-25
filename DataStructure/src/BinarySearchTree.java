

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
	
	//검색
	public Node_ search(int data) {
		
		if(root == null) return null;
		
		Node_ curN = root;
		
		while(curN.getData() != data) {
			
			//현재 노드와 찾는 값이 같은 경우
			if(curN.getData() == data) return curN;
			
			//현재 노드가 찾는 값보다 큰 경우
			else if(curN.getData() > data) curN = curN.getLeft();
			
			//현재 노드가 찾는 값보다 작은 경우
			else curN = curN.getRight();
				
		}
		return curN;
	}
	
	//삽입
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
			
			//데이터가 현재 노드보다 작을 때
			if(data < cur_node.getData()){
				cur_node = cur_node.getLeft();
				//현재 노드의 왼쪽 노드가 비어있을 때 새로운 노드를 넣어준다
				if(cur_node == null) {
					parent_node.setLeft(newN);
					return;
				}
			//데이터가 현재 노드보다 클
			}else {
				cur_node = cur_node.getRight();
				//현재 노드의 오른쪽 노드가 비어있을 때 새로운 노드를 넣어준다
				if(cur_node == null) {
					parent_node.setRight(newN);
					return;
				}
			}
		}
	}
	
	//순회
	
	//중위
	public void inOrderTraverse(Node curN) {
	    if (curN != null) {
	        inOrderTraverse(curN.getLeft());
	        System.out.print(curN.getData() + " ");
	        inOrderTraverse(curN.getRight());
	    }
	}

	//전위
	public void preOrderTraverse(Node curN) {
	    if (curN != null) {
	        System.out.print(curN.getData() + " ");
	        preOrderTraverse(curN.getLeft());
	        preOrderTraverse(curN.getRight());
	    }
	}

	//후위
	public void postOrderTraverse(Node curN) {
	    if (curN != null) {
	        postOrderTraverse(curN.getLeft());
	        postOrderTraverse(curN.getRight());
	        System.out.print(curN.getData() + " ");
	    }
	}
	
	//삭제
	public boolean delete(int data) {
		
		
		Node_ parentN = root;
		Node_ curN = root;
		boolean isLeftChild = false;
		
		
		while(curN.getData() != data) {
			parentN = curN;
			
			//지울 노드가 왼쪽 노드일 때
			if(curN.getData() > data) {
				isLeftChild = true;
				curN = parentN.getLeft();
		    //지울 노드가 오른쪽 노드일 때
			}else {
				isLeftChild = false;
				curN = parentN.getRight();
			}
			//찾으려는 노드 없는 경우
			if(curN == null) return false;
		}
		
		//while문이 끝나면 curN은 삭제될 노드, parent는 삭제될 노드의 부모노드, isLeftChild는 삭제될 노드가 부모노드의
		//left인지 right인지 boolean값을 가진다.
		
		Node_ replaceN;
		
		//자식 노드가 없는 경우
		if(curN.getLeft() == null && curN.getRight() == null ) {
			//해당 노드가 root일 경우
			if(curN == root) {
				root = null;
			}
			//삭제할 노드가 부모노드의 왼쪽 자식노드일 경우
			else if(isLeftChild) {
				parentN.setLeft(null);
				
			//삭제할 노드가 부모노드의 오른쪽 자식노드일 경우
			}else {
				parentN.setRight(null);
			}
			
			//자식노드가 오른쪽 노드만 없을 경우
		}else if(curN.getRight() == null) {
			
			replaceN = curN.getLeft();
			
			if(curN == root) {
				root = replaceN;
				
			}else if(isLeftChild){
				parentN.setLeft(replaceN);
				
			}else {
				
				parentN.setRight(replaceN);
			}
			
			
			//자식노드가 왼쪽 노드만 없을 경우
		}else if(curN.getLeft() == null) {
			
			replaceN = curN.getRight();
			
			if(curN == root) {
				root = replaceN;
				
			}else if(isLeftChild){
				parentN.setLeft(curN.getRight());
				
			}else {
				parentN.setRight(curN.getLeft());
			}
			
			//자식노드가 두개인 경우
			//오른쪽 자식 노드의 subtree 에서 가장 작은 노드를 찾아서 지우려는 노드가 있던 자리에 위치시킨다
		}else {
			// 삭제될 노드의 오른쪽 sub tree 를 저장해둔다
			Node_ rightSubTree = curN.getRight();
			
			// 삭제될 노드 자리에 오게 될 새로운 노드 (오른쪽 sub tree에서 가장 작은 값을 가진 노드)
			// 이 노드는 왼쪽 child 가 없어야 한다.
			replaceN = rightMin(curN.getRight());
			
			if(curN == root) {
				root = replaceN;
			}else if(isLeftChild) {
				parentN.setLeft(replaceN);
			}else {
				parentN.setRight(replaceN);
			}
			
			replaceN.setRight(rightSubTree);
			
			//지우려눈 노드의 오른쪽 서브트리에 노드가 하나밖에 없는 경우
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

