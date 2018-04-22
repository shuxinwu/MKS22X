import java.io.*;
import java.util.*;

public class MyDeque<E>{
    private E[] data;
    private int start, end, size;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
	size = 0;
	start = 0;
	end = 1;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[])new Object[initialCapacity];
	size = 0;
	start = 0;
	end = 1;
    }

    public int size(){
	return size;
    }
    
    public void addFirst(E a){
	if (a == null){
	    throw new NullPointerException();
	}
	if (size == data.length){
	    resize();
	}
	if (data[start] != null){	    
	    if (start == 0){
		start = data.length - 1;
	    }
	    else{
		start--;	   
	    }
	}
	data[start] = a;
	size++;
    }

    public void addLast(E a){
	if (a == null){
	    throw new NullPointerException();
	}
	if (size == data.length){
	    resize();
	}
	if (end == data.length - 1){
	    end = 0;
	}
	if (data[end] != null){
	    end++;
	}
	data[end] = a;
	size++;
    }

    // incomplete
    @SuppressWarnings("unchecked")
    private void resize(){
	E[] newData;
	newData = (E[])new Object[data.length * 2];
	int s = 0;
	// copy values over
	for (int i = 0; i < data.length; i++){
	    newData[i] = data[(start + i) % data.length];
	}
	int e = data.length - 1;
	data = newData;
	start = s;
	end = e;
    }

    public E removeFirst(){
	if (data[start] == null){
	    throw new NoSuchElementException();
	}
	E a = data[start];
	data[start] = null;
	if (start == data.length - 1){
	    start = 0;
	}
	else{
	    start++;
	}
	size--;
	return a;
    }

    public E removeLast(){
	if (data[start] == null){
	    throw new NoSuchElementException();
	}
	E a = data[end];
	data[end] = null;
	if (end == 0){
	    end = data.length - 1;
	}
	else{
	    end--;
	}
	size--;
	return a;
    }

    public E getFirst(){
	if (data[start] == null){
	    throw new NoSuchElementException();
	}
	return data[start];
    }

    public E getLast(){
	if (data[start] == null){
	    throw new NoSuchElementException();
	}
	return data[end];
    }

    public String toString(){
	return Arrays.toString(data);
    }

    public static void main(String[] args){
	MyDeque b = new MyDeque(2);
	b.addLast(3);
	b.addLast(4);
	System.out.println(b);
	b.addFirst(2);
	b.addFirst(1);
	System.out.println(b);
	System.out.println(b.removeFirst());
	System.out.println(b.removeLast());
	System.out.println(b);
    }
}
