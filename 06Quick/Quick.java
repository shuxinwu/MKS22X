import java.lang.Object;
import java.util.*;

public class Quick{

    public static int partition(int[] data, int start, int end){
	// setup
	int index = start + (int)(Math.random() * (end - start));
	int pivot = data[index];
	//   	System.out.println("index: " + index);
	swap(data, start, index);
	//    	System.out.println("pivot: " + pivot);
	
	// indices of nums to look at
	int c = start + 1;
	int small = start;
	int large = end;
	
	while (c <= large){
	    if (data[c] == pivot){
		c++;
	    }	    	   	    
	    else{
		if (data[c] > pivot){
		    swap(data, c, large);
		    large--;
		}
		else{
		    swap(data, small, c);
		    small++;
		    c++;
		}
	    }
	    //	    System.out.println(Arrays.toString(data));
	}
	return small;
    }

    public static void swap(int[] data, int a, int b){
	int x = data[a];
	int y = data[b];
	data[a] = y;
	data[b] = x;
    }

    // kth smallest element
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

    public static void quicksort(int[] data){
	quickHelp(data, 0, data.length - 1);
    }

    public static void quickHelp(int[] data, int start, int end){
 
	if (start < end){
	    // starting point
	    int sp = partition(data, start, end);
	    // left
	    quickHelp(data, start, sp);
	    // right
	    quickHelp(data, sp + 1, end);
	}
    }   
    
    public static void main(String[] args){
	//	int[] ary = {3, 4, 1, 0, 6, 6, 4, 88, 22, 100};
	//	int[] ary = {0, 1, 2, 1, 2, 1, 1, 0};
	//	System.out.println(Arrays.toString(ary));
	//	System.out.println(ary.length);
	//	System.out.println(partition(ary, 0, 7));
	//      quicksort(ary);
	//	System.out.println(Arrays.toString(ary));
    }
}
