import java.util.*;

public class Merge{

    // sort the array from least to greatest value. This is a wrapper function that calls msort()
    public static void mergesort(int[]data){
	int[] temp = int[data.length];
	msort(data, temp, 0, data.length - 1);
    }

    // Suggestions - have your msort take both the data and temp arrays. Pre-allocate a temp array in your mergesort method
    private static void msort(int[]data, int[]temp, int lo, int hi){	
	if (lo >= hi){
	    //   copy   data[ lo ] through data[hi]    into    temp[lo] through temp[hi]
	    for (int i = lo; i < hi; i++){
		int a = data[i];
		temp[i] = a;
	    }
	    // get mid
	    int mid = (lo + hi) / 2;
	    //  call msort() on each half, but switch the temp and data!
	    msort(temp, data, lo, mid);
	    msort(temp, data, mid + 1, hi);
	    //  call merge...
	    merge(data, temp, lo, mid, hi);
	}
	
 
    }

    // copy from temp back to data
    public static void merge(int[] data, int[] temp, int lo, int mid, int hi){
	int m = mid + 1;
	for (int i = lo; i < hi; i++){
	    
	}
    }

    public static void main(String[] args){};

}
