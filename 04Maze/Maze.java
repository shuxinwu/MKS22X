import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{
    private char[][] maze;
    private boolean animate;
    private int x;
    private int y;
    int[][] moves = {
      {0,1}, {1,0}, {-1,0}, {0,-1}
    };

  //constructor
    public Maze(String filename) throws FileNotFoundException{
      File text = new File(filename);
      Scanner inf = new Scanner(text);
      int row = 0;
      int col = 0;
        while(inf.hasNextLine()){
          row++;
          String l = inf.nextLine();
          col = l.length();
        }
        maze = new char[row][col];
        File txt = new File(filename);
      Scanner in = new Scanner(txt);
      for (int i = 0; i < row; i++){
        String line = in.nextLine();
        maze[i] = line.toCharArray();
      }
      
        int c = 0;
	int d = 0;
	for (int a = 0; a < row; a++){
	    for (int b = 0; b < col; b++){
		if (maze[a][b] == 'S'){
		    c++;
		    x = a;
		    y = b;
		}
		if (maze[a][b] == 'E'){
		    d++;
		}
	    }
	}
	if (c != 1 || d != 1){
	    throw new IllegalStateException();
	}
	setAnimate(animate);
    }

  public String getMaze(){
    String m = "";
    for(int a = 0; a < maze.length; a++){
        for (int b = 0; b < maze[0].length; b++){
          m += maze[a][b];
        }
        m += "\n";
      }
    return m;
  }
  
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
 

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

  //wrapper solve
     public int solve(){	
	maze[x][y] = ' ';
	return solve(x, y, 0, 0);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
  
  private int solve(int row, int col, int count, int current){ //you can add more parameters since this is private
        //automatic animation! You are welcome.
  if(animate){
    clearTerminal();
    System.out.println(this);
    wait(20);
  }
 
  if (maze[row][col] == 'E'){
    return count;
  }
	// continue current path
  if (maze[row + moves[current][0]][col + moves[current][1]] == ' '){
    maze[row][col] = '@';
    count++;
    //   return solve(row + moves[current][0], col + moves[current][1], count, current);
  }
  // other direction
  else{
   
	for (int i = 0; i < 4; i++){
    if (maze[row + moves[i][0]][col + moves[i][1]] == 'E'){
        count++;
        return count;
      }
	    if (maze[row + moves[i][0]][col + moves[i][1]] == ' '){
        current = i;
        count++;
        maze[row][col] = '@';
        return solve(row + moves[current][0], col + moves[current][1], count, current);
	    }
	}
    //go back
  if (maze[row - moves[current][0]][col - moves[current][1]] == '@'){
    maze[row][col] = '.';
	count--;
  return solve(row - moves[current][0], col - moves[current][1], count, current);
  }
  else{
    for (int i = 0; i < 4; i++){
      if (maze[row - moves[i][0]][col - moves[i][1]] == '@'){
    maze[row][col] = '.';
	count--;
  return solve(row - moves[i][0], col - moves[i][1], count, i);
    }
  }
  }
  }
  return -1;
  // return solve(row + moves[current][0], col + moves[current][1], count, current);
  }
}
