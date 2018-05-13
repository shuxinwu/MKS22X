public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distanceToStart;

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

    public int getDistanceToStart(){
	return distanceToStart;
    }

    public int compareTo(Location a){
	return this.getDistanceToStart() - a.getDistanceToStart();
    }
}
