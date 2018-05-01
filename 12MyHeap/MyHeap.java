import java.io.*;
import java.util.*;

public class MyHeap{
    private String[] data;
    private int size;
    private boolean isMax;
    
    public MyHeap(){
	data = new String[10];
	size = 0;
	isMax = true;
    }

    //  true: construct empty max heap, false: construct empty min heap
    public MyHeap(boolean a){
	data = new String[10];
	size = 0;
	isMax = a;
    }

    public void add(String S){ 
	int a = (size - 1) / 2;
	int b = size;
	String temp;
	data[b] = S;
	if (isMax){
	    while (data[b].compareTo(data[a]) > 0){
		temp = data[a];
		data[a] = data[b];
		data[b] = temp;
		b = a;
		a = (a - 1) / 2;
	    }
	}
	else{
	    while (data[b].compareTo(data[a]) < 0){
		temp = data[a];
		data[a] = data[b];
		data[b] = temp;
		b = a;
		a = (a - 1) / 2;
	    }
	}
	size++;
    }

    public String remove(){
	String old = data[size - 1];
	data[size - 1] = null;
	size--;
	return old;
    }

    public String peek(){
	return data[0];
    }

    public int size(){
	return size;
    }

    public String toString(){
        return Arrays.toString(data);
    }

    public static void main(String[] args){
	MyHeap a = new MyHeap();

	a.add("bed");
	a.add("sick");
	a.add("head");
	a.add("chest?");
	a.add("and");
	a.add("taking");
	a.add("ctrl");
	System.out.println(a);
	System.out.println(a.size());
	a.remove();
	System.out.println(a);
	System.out.println(a.size());
	System.out.println(a.peek());
    }
}
