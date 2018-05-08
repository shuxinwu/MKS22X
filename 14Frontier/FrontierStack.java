public class FrontierStack{
    private ArrayList<Location> stack;

    public FrontierStack(){
	stack = new ArrayList<Location>;
    }
    
    public Location next(){
	return stack.remove(stack.size() - 1);
    }

    public void add(Location n){
	stack.add(n);
    }

    public boolean hasNext(){
	return stack.size() != 0;
    }
}
