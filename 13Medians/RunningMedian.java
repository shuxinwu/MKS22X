import java.util.*;

public class RunningMedian{
    private MyHeap front;
    private MyHeap back;
    
    public RunningMedian(){
	front = new MyHeap();
	back = new MyHeap(false);
	
    }

    public double getMedian(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	if (front.size() > back.size()){
	    return front.peek();
	}
	if (front.size() < back.size()){
	    return back.peek();
	}
	else{
	    return (front.peek() + back.peek()) / 2;
	}
    }

    public void add(double value){
	if (value < getMedian() || size() == 0){
	    front.add(value);
	}
	if (value >= getMedian()){
	    back.add(value);
	}
	if (Math.abs(front.size() - back.size()) > 1){
	    if (front.size() > back.size()){
		double a = front.peek();
	        back.add(a);
	    }
	    if (front.size() < back.size()){
		double a = back.peek();
	        front.add(a);
	    }
	    
	}
    }

    public int size(){
	return front.size() + back.size();
    }

    public static void main(String[] args){};
}
