public class thing<T>{
    T value;

    //inner classes can use T
    private class whatever{
	T y;
    }
    public thing(){
	//no <T> in the declaration of the constructor
 
    }
    public thing(T data){
	//no <T> in the declaration of the constructor
	value = data;
    }
    public T get(){
	return value;}
    public void set(T newValue){
	value = newValue;
    }


    public static void main(String[]args){
	thing<String> x;
	x = new thing<String>();
	//using the constructor requires a <T>
	//to be a specific type
	thing<Integer> y = new thing<>();
	x.set("Fish");
	System.out.println(x.get());

 

	//inner iterator class > can have nodes in it
	for (String s : n){
     
	}
     
    }

    /*

    //phase 1 make it work with generics
    MyLinkedListImproved<String> n = new MyLinkedListImproved<>();
    n.add("fish");
    System.out.println(n);
    MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
    n.add(new Integer(0));
    System.out.println(m);

    //make your class Iterable
    //implements Iterable<T>  //use the existing T to substitute into iterable
    Example:   
    public class fru<T> implements interfaceThatHas<T>{}

    */
    

}
    
