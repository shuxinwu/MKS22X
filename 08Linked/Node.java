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

    public void setValue(int value){
	data = value;
    }

    public String toString(){
	String s = "";
	while (next != null){
	    s += getNext();
	    s += " ";
	}
	return s;
    }

    public static void main(String[] args){

    }
}
