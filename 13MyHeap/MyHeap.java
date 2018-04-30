import java.io.*;
import java.util.*;

public class MyHeap{
    private String[] data;
    private int size;
    
    public MyHeap(){
	data = new String[10];
	size = 0;
    }

    //  true: construct empty max heap, false: construct empty min heap
    //  public MyHeap(boolean a){};

    public void add(String S){ 
	int a = (size - 1) / 2;
	int b = size;
	String temp;
	data[b] = S;
	while (data[b].compareTo(data[a]) > 0){
	    temp = data[a];
	    data[a] = data[b];
	    data[b] = temp;
	    b = a;
	    a = (a - 1) / 2;
	}
	size++;
    }

    //  public String remove(){};

    //  public String peek(){};

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
    }
}
