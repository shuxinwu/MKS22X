import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Maze{
    private Location start,end;
    private char[][] board;
    private boolean AStar;
    int[][] moves = { {0,1}, {1,0}, {-1,0}, {0,-1} };

    public Maze(String mazeText) throws FileNotFoundException{
	File text = new File(mazeText);
	Scanner inf = new Scanner(mazeText);
	int row = 0;
	int col = 0;
	while(inf.hasNextLine()){
	    row++;
	    if (row == 1){
		String l = inf.nextLine();
		col = l.length();
	    }
	}
	board = new char[row][col];
	Scanner in = new Scanner(mazeText);
	for (int i = 0; i < row; i++){
	    String line = in.nextLine();
	    board[i] = line.toCharArray();
	}
	for (int a = 0; a < row; a++){
	    for (int b = 0; b < col; b++){
		if (board[a][b] == 'S'){
		    start = new Location(a, b, null);
		}
		if (board[a][b] == 'E'){
		    end = new Location(a, b, null);
		}
	    }
	}
    }

    // '#' - wall 
    // ' ' - open space
    // '?' - frontier space
    // '.' - visited space
    // 'E' - end space (do not replace this)
    // '@' - part of solution
    // 'S' - starting space (do not replace this)

    public String toString(){
	String s = "";
	for (int a = 0; a < board.length; a++){
	    for (int b = 0; b < board[0].length; b++){
		s += board[a][b];
	    }
	    s += "\n";
	}
	return s;
    }

    /*
    // Work on this method as a group! 
    public String toStringColor(){
    }
    */

    //return a list of Locations that are:
    // adjacent to n and not visited
    // all the Locations in this list should have their previous set to n.
    public Location[] getNeighbors(Location n){
	Location[] neighbors = new Location[4];
	//	int count = 0;
	for (int i = 0; i < 4; i++){
	    if (board[n.getX() + moves[i][0]][n.getY() + moves[i][1]] == ' '){
		neighbors[i] = new Location(n.getX() + moves[i][0], n.getY() + moves[i][1], n);
		//	count++;
	    }
	}
	/*
	if (count != 4){
	    Location[] nei = new Location[count];
	    int c = 0;
	    for (int i = 0; i < 4; i++){
		if (neighbors[i] != null){
		    nei[c] = neighbors[i];
		    c++;
		}
	    }
	    neighbors = nei;
	}
	*/
	return neighbors;
    }

    public Location getStart(){
	return start;
    }

    public Location getEnd(){
	return end;
    }

    public void setAStar(boolean a){
	AStar = a;
    }

    public static void main(String[] args){
	
    }
    
}
