import java.io.*;
import java.util.*;

public class MyHeap<T extends Comparable<T>>{
    private T[] data;
    private int size;
    private boolean isMax;

    @SuppressWarnings("unchecked")
    public MyHeap(){
	data = (T[])new Comparable[10];
	size = 0;
	isMax = true;
    }

    //  true: construct empty max heap, false: construct empty min heap
    @SuppressWarnings("unchecked")
    public MyHeap(boolean a){
	data = (T[])new Comparable[10];
	size = 0;
	isMax = a;
    }
    
    public void add(T S){ 
	int a = (size - 1) / 2;
	int b = size;
	T temp;
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

    public T remove(){
	T old = data[size - 1];
	data[size - 1] = null;
	size--;
	return old;
    }

    public T peek(){
	return data[0];
    }

    public int size(){
	return size;
    }

    public String toString(){
        return Arrays.toString(data);
    }

    public static void main(String[] args){
	/*	
	MyHeap a = new MyHeap(false);
	
	a.add(4.0);
	a.add(2.1);
	a.add(44.3);
	a.add(2.99);
	System.out.println(a);
	System.out.println(a.size());
	a.remove();
	System.out.println(a);
	System.out.println(a.size());
	System.out.println(a.peek());
	*/
    }
}
