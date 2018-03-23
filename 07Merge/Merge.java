import java.util.*;

public class Merge{

    // sort the array from least to greatest value. This is a wrapper function that calls msort()
    public static void mergesort(int[]data){
	int[] temp = new int[data.length];
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
	    //  call merge
	    merge(data, temp, lo, mid, hi);
	}
	
    }

    // copy from temp back to data
    public static void merge(int[] data, int[] temp, int lo, int mid, int hi){
	// ints to be used
	// a and b for elements
	// lo and m for indices
	int l = lo;
	int m = mid + 1;
	int a = temp[lo];
	int b = temp[m];
	int i = l;
	// comparison
	while (lo <= mid && m <= hi){
	    //	    System.out.println("i: " + i);
	    //	    System.out.println("a: " + a);
	    //	    System.out.println("b: " + b);
	    if (a < b){
		data[i] = a;
		lo++;
		a = temp[lo];
	    }
	    else{
		data[i] = b;
		m++;
		b = temp[m];
	    }
	    i++;
	    System.out.println("data:" + Arrays.toString(data));
	}
	if (lo > mid){
	    while (i < hi){
		data[i] = b;
		m++;
		b = temp[m];
		i++;
	    }
	}
	if (m > hi){
	    while (i < hi){
		data[i] = a;
		lo++;
		a = temp[lo];
		i++;
	    }	
	}
	
    }

    public static void main(String[] args){
	int[] ary = {3, 5, 7, 0, 4, 8, 14};
	int[] data = {14, 4, 7, 0, 8, 5, 3};
	//	int[] ary = {3, 4, 1, 0, 6, 6, 4, 88, 22, 100};
	//	int[] ary = {0, 1, 2, 1, 2, 1, 1, 0};
       	System.out.println("ary:" + Arrays.toString(ary));
	System.out.println("data:" + Arrays.toString(data));
      	//	System.out.println(ary.length);
        merge(data, ary, 0, 2, 6);
	//      mergesort(ary);
	System.out.println("ary:" + Arrays.toString(ary));
	System.out.println("data:" + Arrays.toString(data));
    }

}
