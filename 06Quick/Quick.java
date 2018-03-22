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
	//      System.out.println(Arrays.toString(ary));
    } 

    /*

    //Sort testing code
    private static final int INCREASE = 0;
    private static final int DECREASE = 1;
    private static final int STANDARD = 2;
    private static final int SMALL_RANGE = 3;
    private static final int EMPTY = 4;

    private static String name(int i){
    if(i==0)return "Increassing";
    if(i==1)return "Decreassing";
    if(i==2)return "Normal Random";
    if(i==3)return "Random with Few Values";
    if(i==4)return "size 0 array";
    return "Error stat array";

    }

    private static int create(int min, int max){
    return min + (int)(Math.random()*(max-min));
    }

    private static int[]makeArray(int size,int type){
    int[]ans =new int[size];
    if(type == STANDARD){
    for(int i = 0; i < size; i++){
    ans[i]= create(-1000000,1000000);
    }
    }
    if(type == INCREASE){
    int current = -5 * size;
    for(int i = 0; i < size; i++){
    ans[i]= create(current,current + 10);
    current += 10;
    }
    }
    if(type == DECREASE){
    int current = 5 * size;
    for(int i = 0; i < size; i++){
    ans[i]= create(current,current + 10);
    current -= 10;
    }
    }
    if(type == SMALL_RANGE){
    for(int i = 0; i < size; i++){
    ans[i]= create(-5,5);
    }
    }
    if(type == EMPTY){
    ans = new int[0];
    }
    return ans;
    }

    public static void main(String[]args){
    if(args.length < 2)return;
    
    int size =  Integer.parseInt(args[0]);
    int type =   Integer.parseInt(args[1]);

    int [] start = makeArray(size,type);
    int [] result = Arrays.copyOf(start,start.length);
    Arrays.sort(result);
    
    long startTime = System.currentTimeMillis();
    // Test your sort here!
    
    long elapsedTime = System.currentTimeMillis() - startTime;
    if(Arrays.equals(start,result)){
    System.out.println("PASS Case "+name(type)+" array, size:"+size+" "+elapsedTime/1000.0+"sec ");
    }else{
    System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
    }
    }
    */
    
  
}
