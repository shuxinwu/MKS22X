import java.util.*;

public class MyLinkedList{
    private Node first, last;
    private int length;

    public MyLinkedList(){
	length = 0;
    }

    // tested
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
	for (int i = 0; i < length; i++){
	    s += getNode(i);
	    s += " ";
	}
	return s;
    }

    public int size(){
	return length;
    }

    // tested
    public Integer get(int index){ // exceptions not done
	int i = 0;
	Node current = first;
	while (i < index){
	    current = current.getNext();
	    i++;
	}
	return current.getValue();
    }

    // tested
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

    // tested
    public Integer indexOf(Integer value){
	Node current = first;
	for (Integer i = 0; i < length; i++){
	    if (current.getValue() == value){
		return i;
	    }
	    current = current.getNext();
	}
	return -1;
    }

    // not added, or not printing
    public void add(int index, Integer value){ // exceptions not done
       	

	if (index == length){
	    add(value);
	}
	else{
	    length++;

	    Node a = getNode(index);
	    Node b = new Node(value);
	    getNode(index - 1).setNext(b);
	    b.setNext(a);
	    a.setPrev(b);
	    b.setPrev(getNode(index - 1));
	}
	    
    }

    public void clear(){
	Node current = first;
	Node next = current.getNext();
	for (int i = 0; i < length; i++){
	    next = current.getNext();
	    current = null;
	    next = current;
	}
    }

    public boolean remove(Integer value){
	int i = 0;
	Node current = first;
	while (i < length){
	    if (current.getValue() == value){
		current.setValue(current.getNext().getValue());
	    }
	    current = current.getNext();
	    i++;
	}
	length--;
	return true;
    }

    public int remove(int index){
	int i = 0;
	int v = 0;
	Node current = first;
	while (i < length){
	    if (i == index){
		v = current.getValue();
		current.setValue(current.getNext().getValue());
	    }

	    current = current.getNext();
	    i++;
	}
	length--;
	return v;
    }
//IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())

    // tested
    private Node getNode(Integer index){
	Node a = first;
	for (int i = 0; i < index; i++){
	    a = a.getNext();
	}
	return a;
    }

    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();
	a.add(4);
	a.add(19);
	a.add(900);
	a.add(22);
	a.add(89);
	System.out.println(a);
	System.out.println(a.getNode(2));
	a.add(1, 2);
	System.out.println(a);
    }
}
