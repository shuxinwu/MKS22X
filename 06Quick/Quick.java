import java.lang.Object;
import java.util.*;

public class Quick{

    public static int partition (int [] data, int start, int end){
 
	// setup
	int index = start + (int)(Math.random() * (end - start));
	int pivot = data[index];
	swap(data, start, index);
	//	System.out.println(pivot);
	
	// indices of nums to look at
	int small = start + 1;
	int large = end;
	
	while (small <= large){
	    if (data[small] < pivot){
		small++;
	    }	    	   	    
	    else{
		swap(data, small, large);
		large--;
	    }
	}
	
	swap(data, large, start);
	// System.out.println(Arrays.toString(data));
	return large;
    }

    public static void swap(int[] data, int a, int b){
	int x = data[a];
	int y = data[b];
	data[a] = y;
	data[b] = x;
    }
    
    public static int quickselect(int[] data, int k){
	int i = partition(data, 0, data.length - 1);
        while (i != k){
	    if (k < i){
		i = partition(data, 0, i - 1);
	    }
	    if (k > i){
		i = partition(data, i + 1, data.length - 1);
	    }
	}
	return data[i];
    }
    
    public static void main(String[] args){
	int[] ary = {2, 10, 15, 23, 0, 5};
	System.out.println(quickselect(ary, 0));
	System.out.println(quickselect(ary, 1));
	System.out.println(quickselect(ary, 2));
	System.out.println(quickselect(ary, 3));
	System.out.println(quickselect(ary, 4));
	System.out.println(quickselect(ary, 5));
    }
}
