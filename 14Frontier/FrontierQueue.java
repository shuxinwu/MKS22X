import java.util.*;

public class FrontierQueue implements Frontier{
    private ArrayList<Location> queue;

    public FrontierQueue(){
	queue = new ArrayList<Location>;
    }

    public Location next(){
	return queue.remove(0);;
    }

    public void add(Location a){
	queue.add(a);
    }

    public boolean hasNext(){
	return queue.size() != 0; 
    }
}
