public class FrontierPriorityQueue implements Frontier{
    private MyHeap<Location> priorityQ;

    public FrontierPriorityQueue(){
	priorityQ = new MyHeap();
    }

    public Location next(){
	return priorityQ.remove();
    }

    public void add(Location a){
	priorityQ.add(a);
    }

    public boolean hasNext(){
	return priorityQ.size() != 0;
    }

}
					     
