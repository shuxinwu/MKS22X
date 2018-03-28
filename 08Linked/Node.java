public class Node{
    int data;
    Node next, prev;

    public Node getNext(){
	return next;
    }

    public void setNext(Node a){
	next = a;
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

    //    public String toString(){ };
}
