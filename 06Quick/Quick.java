import java.lang.Object;
import java.util.*;

public class Quick{

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

	System.out.println(Arrays.toString(data));
	
	while (small <= large){
	    if (data[small] < pivot){
		small++;
	    }	    	   	    
	    else{
		large--;
	    }
	
	    //	    System.out.println(Arrays.toString(data));
	}
	
	data[large] = pivot;
	return large;
    }

    public static void swap(int[] data, int a, int b){
	int x = data[a];
	int y = data[b];
	data[a] = y;
	data[b] = x;
    }
    
    /*
    public static int quickSelect(int[] data, int k){
	int i = partition(data, 0, data.length - 1);
        
	return partition(data, 0, i - 1);
	return partition(data, i + 1, data.length - 1);
	return i;
    }
    */
    public static void main(String[] args){
	int[] ary = {2, 10, 7, 8, 5, 2, 4, 9, 11, 6};
	System.out.println(Arrays.toString(ary));
	System.out.println(partition(ary, 2, 9));
    }
}
