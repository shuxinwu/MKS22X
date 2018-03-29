import java.util.*;

public class MyLinkedList{
    Node first, last;
    int length;

    public MyLinkedList(){
	length = 0;
    }

    public boolean add(Integer newData){
	Node a = new Node(newData);
	//	a.setValue(newData);
	if (length == 0){
	    first.setValue(newData);
	}
	last.setNext(a);
	System.out.println(a);
	return true;
    }

    public String toString(){
	if (length == 0){
	    return "empty";
	}
	String s = "";
	
	return s;
    }

    //    private Node getNode(int index){};
    
    /*
// should all throw appropriate exceptions
    public Integer get(int index){}; // exceptions

    public Integer set(int index, Integer value){}; // exceptions

    public int size(){};    

    public void clear();

    public int indexOf(Integer value);

    public void add(int index, Integer value); // exceptions

    public boolean remove(Integer value);

    public remove(int index){};
//IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())


    */

    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();
	System.out.println(a);
	a.add(14);
	a.add(19);
	System.out.println(a);
    }
}
