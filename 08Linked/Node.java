public class Node{
    int data;
    Node next, prev;

    public Node(int value){
	data = value;
    }
    
    public Node getNext(){
	return next;
    }

    public void setNext(int a){
	Node b = new Node(a);
	next = b;
    }

    public Node getPrev(){
	return prev;
    }

    public void setPrev(Node a){
	prev = a;
    }

    public int getValue(){
	return data;
    }

    public void setValue(int value){
	data = value;
    }

    public String toString(){
	String s = "";
	while (next != null){
	    s += getValue();
	    s += " ";
	}
	return s;
    }

    public static void main(String[] args){
	Node a = new Node(4);
	System.out.println(a);
	a.setNext(14);
	System.out.println(a);
    }
}
