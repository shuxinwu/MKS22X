public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private double distance;
    private int distanceSoFar;

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

    public double getDistance(){
	return distance;
    }

    public int getDistanceSoFar(){
	return distanceSoFar;
    }

    public int compareTo(Location a){
	return (int) (this.getDistance() - a.getDistance());
    }

    public static void main(String[] args){

    }
}
