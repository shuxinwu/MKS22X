import java.util.*;
import java.lang.*;

public class MyLinkedListImproved<T> extends Comparable<T> implements Iterable<T>{
    T value;
    private Node first, last;
    private int length;

    public MyLinkedListImproved(){
	length = 0;
    }

    public MyLinkedListImproved(T data){
	value = data;
    }

    public T get(){
	return value;
    }

    public void set(T newValue){
	value = newValue;
    }

    
    public boolean add(T newData){
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

    public T get(int index){ // exceptions
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
        return getNode(index).getValue();
    }

    public T set(int index, T value){ // exceptions
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	T i;
	i = getNode(index).getValue();
        getNode(index).setValue(value);
	return i;
    }

    public Integer indexOf(T value){
	Node current = first;
	for (Integer i = 0; i < length; i++){
	    if (current.getValue() == value){
		return i;
	    }
	    current = current.getNext();
	}
	return -1;
    }

    public void add(int index, T value){ // exceptions
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

    public void clear(){
	int l = length;
	for (int i = 0; i < l; i++){
	    remove(i);
	}
    }

    public boolean remove(T value){
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

    public T remove(int index){
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	T v = getNode(index).getValue();
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

    private Node getNode(Integer index){
	Node a = first;
	for (int i = 0; i < index; i++){
	    a = a.getNext();
	}
	return a;
    }    

    //phase 1 make it work with generics
    public static void main(String[] args){
	MyLinkedListImproved<String> n = new MyLinkedListImproved<>();
	n.add("fish");
	System.out.println(n);
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
	m.add(new Integer(0));
	System.out.println(m);
    }

   
    //make your class Iterable
    //use the existing T to substitute into iterable
    //  Example:   
    //  public class fru<T> implements interfaceThatHas<T>{}    
    
    //inner iterator class > can have nodes in it
    private class Iterator{
	private MyLinkedListImproved a;
	private Node current = first;
	
	public boolean hasNext(){
	    return current.getNext() == null;
	}

	public T next(){
	    if (hasNext()){
		current = current.getNext();
	    }
	    else{
		System.exit(0);
	    }
	    return current.getValue();
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    

    public int compareTo(T value){
	if (this < value){
	    return -1;
	}
	if (this.equals(value)){
	    return 0;
	}
	else{
	    return 1;
	}
    }
    
    public int max(){
    //-> return the index of the largest value, or -1 if the list is empty
	if (this.size() == 0){
	    return -1;
	}
	int index = 0;
	T value = first.getValue();
	for (int i = 0; i < this.size(); i++){
	    if (this.get(i).compareTo(value) > 0){
		value = this.get(i);
		index = i;
	    }
	}
	return index;
    }
    public int min(){
    //-> return the index of the largest value, or -1 if the list is empty
    	if (this.size() == 0){
	    return -1;
	}
	int index = 0;
	T value = first.getValue();
	for (int i = 0; i < this.size(); i++){
	    if (this.get(i).compareTo(value) < 0){
		value = this.get(i);
		index = i;
	    }
	}
	return index;
    }
   

    private class Node{
	private T data;
	private Node next, prev;

	public Node(T value){
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

	public T getValue(){
	    return data;
	}

	public void setValue(T value){
	    data = value;
	}

	public String toString(){
	    String s = " ";
	    return s + data;
	}
    }
}
