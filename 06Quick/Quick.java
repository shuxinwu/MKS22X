import java.lang.Object;
import java.util.*;

public class Quick{
    /*Choose a random pivot element, and modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding 
 *   element is designated the pivot element. 
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */

    public static int partition (int [] data, int start, int end){
 
	// setup
	int index = start + (int)(Math.random() * (end - start));
	int pivot = data[index];
	System.out.println(pivot);
	int old = data[start];
        data[start] = pivot;
	data[index] = old;
	// indices of nums to look at
	int small = start + 1;
	int large = end;

	// values of nums
	int s;
	int l;

	System.out.println(Arrays.toString(data));
	
	//	while (small < large){
	for (int i = 0; small <= large; i++){
	    s = data[small];
	    l = data[large];

	    if (s < pivot){
		small++;
		System.out.println(1);
		System.out.println("i: " + i);
		System.out.println("s: " + s);
		System.out.println("l: " + l);
		System.out.println(data[small]);
		System.out.println(data[large]);
		System.out.println("small: " + small);
		System.out.println("large: " + large);
		System.out.println(Arrays.toString(data));
	    }
	    
	    if (l > pivot){
		large--;
		System.out.println(2);
		System.out.println("i: " + i);
	        System.out.println("s: " + s);
		System.out.println("l: " + l);
		System.out.println(data[small]);
		System.out.println(data[large]);
		System.out.println("small: " + small);
		System.out.println("large: " + large);
		System.out.println(Arrays.toString(data));
	    }	    
	   	    
	    else{
		s = data[small];
		l = data[large];
		data[small] = l;
		data[large] = s;
		small++;
		large--;
		System.out.println(3);
		System.out.println("i: " + i);
	        System.out.println("s: " + s);
		System.out.println("l: " + l);
		System.out.println(data[small]);
		System.out.println(data[large]);
		System.out.println("small: " + small);
		System.out.println("large: " + large);
		System.out.println(Arrays.toString(data));
	    }
	
	    //	    System.out.println(Arrays.toString(data));
	}
	
	/*
	String m = "";
	for (int i = 0; i < data.length; i++){
	    m += data[i];
	    m += " ";
	}
	System.out.println(m);
	*/

	for (int i = start; i < large; i++){
	    int a = data[i + 1];
	    data[i] = a;
	}
	data[large] = pivot;

	System.out.println(Arrays.toString(data));
	
	try{
	    if (start != large && data[large] < data[large - 1]){
		int a = data[large - 1];
		data[large] = a;
		data[large - 1] = pivot;
		large--;
	    }
	    if (data[large] > data[large + 1]){
		int a = data[large + 1];
		data[large] = a;
		data[large + 1] = pivot;
		large++;
	    }
	}
	catch (ArrayIndexOutOfBoundsException e){
	}
	
	System.out.println(Arrays.toString(data));
	return large;
    }

    public static void main(String[] args){
	int[] ary = {2, 10, 7, 8, 5, 2, 4, 9, 11, 6};
	System.out.println(Arrays.toString(ary));
	System.out.println(partition(ary, 2, 9));
    }
}
