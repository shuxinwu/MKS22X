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

    public void setPrev(int a){
	Node b = new Node(a);
	prev = b;
    }

    public int getValue(){
	return data;
    }

    public void setValue(int value){
	data = value;
    }

    public String toString(){
	String s = " ";
	Node c = next;
	//	int test = 0;
	while (c.getNext() != null){
	    s += c.getValue();
	    s += ", ";
	    c = next;
	    //	    test++;
	    //	    System.out.println(test);
	}
	return s;
    }

    public static void main(String[] args){
	Node a = new Node(4);
	//	System.out.println(a);
	a.setNext(14);
	System.out.println(a);
    }
}
