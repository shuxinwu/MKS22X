public class MyDeque<E>{
    private E[] data;
    private int start, end, size;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[])new Object[initialCapacity];
    }

    public int size(){
	return size;
    }

    // incomplete
    public void addFirst(E a){
	if (a == null){
	    throw new NullPointerException();
	}
	if (start == 0){
	    data[data.length - 1] = a;
	}
	else{
	    data[start - 1] = a;
	}
    }

    public void addLast(E a){
	if (a == null){
	    throw new NullPointerException();
	}
	if (end == data.length - 1){
	    data[0] = a;
	}
	else{
	    data[end + 1] = a;
	}
    }

    public static void main(String[] args){
	MyDeque a = new MyDeque();
	MyDeque b = new MyDeque(20);
    }
}
