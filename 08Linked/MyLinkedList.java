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
    public int get(n){};

    public void set(int index, int value){};

    public int size(){};    

    public remove(int index){};
    */

    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();
    }
}
