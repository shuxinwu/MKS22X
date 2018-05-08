public class Location{
    private int x,y;
    private Location previous;

    public Location(int xc, int yc, Location prev){
	x = xc;
	y = yc;
	previous = prev;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public Location getPrev(){
	return previous;
    }
}
