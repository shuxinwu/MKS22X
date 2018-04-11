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
    public void add(int index, Integer value){ // exceptions
	Node current = first;
	int a = 0, b = 0;
	int i = 0;
        while (i <= length){
	    if (i == index && i != length){
		a = current.getValue();
		current.setValue(value);
		if (index == 0){
		    first = current;
		}
	    }
	    if (i > index && i < length){
		b = current.getValue();
		current.setValue(a);
		a = b;

	    }
	    if (i == length){
		Node f = new Node(a);
		current = f;
	    }
	    if (current != null){
		current = current.getNext();	    
	    }
	    i++;
	}
	last = current;
	length++;
    }
    
    //    private Node getNode(int index){};
    

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
	System.out.println(a.indexOf(1));
	a.add(3, 2);
	System.out.println(a);
    }
}
