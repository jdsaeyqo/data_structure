

class Node{
	
	private int data;
	private Node Left;
	private Node Right;
	
	Node(Node left, int data, Node right) {
		
		this.data = data;
		this.Left = left;
		this.Right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return Left;
	}

	public void setLeft(Node left) {
		Left = left;
	}

	public Node getRight() {
		return Right;
	}

	public void setRight(Node right) {
		Right = right;
	}
	
		
}

public class Binary_Tree {
	
	
	public Node root;
	
	public void setRoot(Node n) {
		this.root = n;
	}
	public Node getRoot() {
		return root;
	}
	

	
	//중위 순위 Left -> Root -> Right
	public void inOrder(Node n) {
		if(n != null) {
			inOrder(n.getLeft());
			System.out.print(n.getData()+" ");
			inOrder(n.getRight());
		}
	}
	
	//전위 순위 Root -> Left -> Right
	public void preOrder(Node n) {
        if(n != null) {
            System.out.print(n.getData()+" ");
            preOrder(n.getLeft());
            preOrder(n.getRight());
        }
    }
	//후위 순위 Left -> Right -> Root
	public void postOrder(Node n) {
		if(n != null) {
			postOrder(n.getLeft());
			postOrder(n.getRight());
			System.out.print(n.getData()+" ");
		}
	}
	public static void main(String[] args) {
		
		Binary_Tree t = new Binary_Tree();
		Node n1 = new Node(null, 1, null);
		Node n2 = new Node(null, 2, null);
		Node n3 = new Node(n1, 3, n2);
		Node n4 = new Node(null, 4, null);
		Node n5 = new Node(n3, 5, n4);
		
		t.setRoot(n5);
		t.inOrder(t.getRoot());
		System.out.println();
		t.preOrder(t.getRoot());
		System.out.println();
		t.postOrder(t.getRoot());
	}

}
