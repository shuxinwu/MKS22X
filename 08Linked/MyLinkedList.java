import java.util.*;

public class MyLinkedList{
    private Node first, last;
    private int length;

    public MyLinkedList(){
	length = 0;
    }

    public boolean add(Integer newData){
	Node a = new Node(newData);
      
	if (length == 0){
	    first = new Node(newData);
	    last = first;
	}
	else{
	    last.setNext(a);
	    last = last.getNext();
	}
	length++;
	return true;
    }

    public String toString(){
	if (length == 0){
	    return "empty";
	}
	String s = "";
	Node current = first;
	while (current != null){
	    s += current;
	    s += ", ";
	    current = current.getNext();
	}
	return s;
    }

    public int size(){
	return length;
    }

    // should all throw appropriate exceptions
    public Integer get(int index){ // exceptions
	int i = 0;
	Node current = first;
	while (i < index){
	    current = current.getNext();
	    i++;
	}
	return current.getValue();
    }

    public Integer set(int index, Integer value){ // exceptions
	Integer i = 0;
	Node current = first;
	while (i < index){
	    current = current.getNext();
	    i++;
	}
	i = current.getValue();
	current.setValue(value);
	return i;
    }
    //    private Node getNode(int index){};
    
    /*

    public void clear();

    public int indexOf(Integer value);

    public void add(int index, Integer value); // exceptions

    public boolean remove(Integer value);

    public remove(int index){};
//IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())


    */

    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();
	a.add(4);
	a.add(19);
	a.add(900);
	a.add(22);
	a.add(89);
	System.out.println(a);
	System.out.println(a.get(4));
	a.set(3, 1);
	System.out.println(a);
    }
}
