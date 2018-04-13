import java.util.*;
import java.lang.Object;

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
    public Integer get(int index){ // exceptions
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
        return getNode(index).getValue();
    }

    // tested
    public Integer set(int index, Integer value){ // exceptions
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	Integer i = 0;
	i = getNode(index).getValue();
        getNode(index).setValue(value);
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

    // tested
    public void add(int index, Integer value){ // exceptions
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
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
	last = getNode(length - 1);
    }

    // npe
    public void clear(){
	int l = length;
	for (int i = 0; i < l; i++){
	    remove(i);
	}
    }

    public boolean remove(Integer value){
	Integer i = indexOf(value);
	if (i == -1){
	    return false;
	}
	else{
	    if (i == 0){
		getNode(i + 1).setPrev(null);
		first = getNode(i + 1);
	    }
	    if (i == length -1){
		getNode(i - 1).setNext(null);
		last = getNode(i - 1);
	    }
	    else{
		getNode(i - 1).setNext(getNode(i + 1));
		getNode(i + 1).setPrev(getNode(i - 1));
	    }
	}	
	length--;
	    
	return true;
    }

    // tested
    public Integer remove(int index){
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	Integer v = getNode(index).getValue();
	if (index == 0){
	    getNode(index + 1).setPrev(null);
	    first = getNode(index + 1);
	}
	if (index == length - 1){
	    getNode(index - 1).setNext(null);
	    last = getNode(index -1);
	}
	else{
	    getNode(index - 1).setNext(getNode(index + 1));
	    getNode(index + 1).setPrev(getNode(index - 1));
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
	System.out.println(a.get(2));
	System.out.println(a.set(2, 99));
	a.add(1, 2);
	System.out.println(a);
	//    	a.clear();
       	a.remove(2);
       	a.remove(4);
	a.remove(0);
       	System.out.println(a);
    }
}
