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

    // incomplete
    public void addFirst(E a){
	if (a == null){
	    throw new NullPointerException();
	}
	if (size == data.length){
	    resize(data);
	}
	if (start == 0 && data[start] != null){
	    data[data.length - 1] = a;
	    start = data.length - 1;
	}
	else{
	    if (start == 0){
		data[0] = a;
		start = 0;
	    }
	    else{
		data[start - 1] = a;
		start--;
	    }
	}
	size++;
    }

    public void addLast(E a){
	if (a == null){
	    throw new NullPointerException();
	}
	if (size == data.length){
	    resize(data);
	}
	if (end == data.length - 1){
	    data[0] = a;
	    end = 0;
	}
	if (data[end] == null){
	    data[end] = a;
	}
	else{
	    data[end + 1] = a;
	    end++;
	}
	size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(E[] old){
	E[] newData;
	newData = (E[])new Object[old.length * 2];
	
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
	MyDeque a = new MyDeque();
	MyDeque b = new MyDeque(20);
	a.addFirst("hello");
	a.addFirst("we");
	a.addFirst("so");
	a.addLast("fried");
	b.addLast(1);
	b.addLast(2);
	b.addFirst(22);
	b.addFirst(23);
	System.out.println(a);
	System.out.println(b);
	System.out.println(a.removeFirst());
	System.out.println(a.removeLast());
	System.out.println(a);
	System.out.println(b);
    }
}
