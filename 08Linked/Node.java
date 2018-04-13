public class Node{
    private Integer data;
    private Node next, prev;

    public Node(Integer value){
	data = value;
    }
    
    public Node getNext(){
	if (next != null){
	    return next;
	}
	return null;
    }

    public void setNext(Node a){
	next = a;
    }
    
    public Node getPrev(){
	if (prev != null){
	    return prev;
	}
	return null;
    }

    public void setPrev(Node a){
	prev = a;
    }

    public Integer getValue(){
	return data;
    }

    public void setValue(Integer value){
	data = value;
    }

    public String toString(){
	String s = " ";
	return s + data;
    }

    public static void main(String[] args){
	Node a = new Node(4);
	System.out.println(a);
	a.setValue(14);
	System.out.println(a);
	System.out.println(a.getValue());
    }
}
