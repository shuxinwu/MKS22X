import java.util.*;

public class MyLinkedList{
    Node first, last;
    int length;

    public MyLinkedList(){
   
    }

    public boolean add(int value){
	Node a = new Node();
	a.setValue(value);
	last.setNext(a);
	return true;
    }

    public String toString(){
	String s = "";

	
	return s;
    }
    
    /*
// should all throw appropriate exceptions
    public int get(n){};

    public void set(int index, int value){};

    public int size(){};    

    public remove(int index){};
//IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
    */

    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();
    }
}
