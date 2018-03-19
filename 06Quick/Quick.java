import java.lang.Object;
import java.util.*;

public class Quick{

    public static int partition(int[] data, int start, int end){
	// setup
	int index = start + (int)(Math.random() * (end - start));
	int pivot = data[index];
	//	System.out.println(index);
	swap(data, start, index);
	//  	System.out.println(pivot);
	
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
	/*
	// choose a starting point
	//	if (partition(data, 0, data.length - 1) == -1)
	int a = partition(data, 0, data.length - 1);
	if (a != -1){
	    quickselect(data, a);
	}
	// left
	quickHelp(data, 0, a);
	// right
	quickHelp(data, a + 1, data.length - 1);
	//	System.out.println(Arrays.toString(data));
	*/
	quickHelp(data, 0, data.length - 1, data.length / 2);
    }

    public static int quickHelp(int[] data, int start, int end, int sp){ 
	if (start == end){
	    return -1;
	}
	
	// left
	partition(data, start, sp);
		  //	quickHelp(data, start, sp);
	// right
		  //	quickHelp(data, sp + 1, end);
	partition(data, sp + 1, end);
	sp = partition(data, start, end);
	return quickHelp(data, start, end, sp);
    }
    
    
    public static void main(String[] args){
      	int[] ary = {2, 10, 15, 23, 0, 5, 1, 19, 22, 3, 2, 6, 5, 77, 12};
	//	int[] ary = {0, 1, 2, 1, 2, 1, 1, 0};
	System.out.println(Arrays.toString(ary));
	//	System.out.println(partition(ary, 0, 7));
	System.out.println(quickselect(ary, 3));
	System.out.println(Arrays.toString(ary));
	System.out.println(quickselect(ary, 4));
	System.out.println(Arrays.toString(ary));
	System.out.println(quickselect(ary, 5));
	System.out.println(Arrays.toString(ary));
	
	//    quicksort(ary);
	//	System.out.println(Arrays.toString(ary));
    }
}
