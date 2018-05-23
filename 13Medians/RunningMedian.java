import java.util.*;

public class RunningMedian{
    private MyHeap<Double> front;
    private MyHeap<Double> back;

    public RunningMedian(){
	front = new MyHeap<Double>();
      	back = new MyHeap<Double>(false);
    }

    public Double getMedian(){
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

    public void add(Double value){
	if (size() == 0){
	    front.add(value);
	}
	else{
	    if (value >= getMedian()){
		back.add(value);
		//		System.out.println("back: " + back);
	    }
	    else{
		front.add(value);
		//		System.out.println("front: " + front);
	    }
	    if (Math.abs(front.size() - back.size()) > 1){
		if (front.size() > back.size()){	    
		    Double a = front.peek();
		    back.add(a); 
		}
		if (front.size() < back.size()){
		    Double a = back.peek();
		    front.add(a);
		}
	    }
	}
    }


    public int size(){
	return front.size() + back.size();
    }

    public String toString(){
	String s = "";
	s += front.toString();
	s += "...";
	s += back.toString();
	return s;
    }

    public static void main(String[] args){
	/*
	RunningMedian a = new RunningMedian();
	a.add(4.4);
	a.add(91.2);
	a.add(76.2);
       	a.add(89.5);
	a.add(0.2);
	
	System.out.println(a);
	System.out.println(a.size());
	System.out.println(a.getMedian());
	*/
    }
}
