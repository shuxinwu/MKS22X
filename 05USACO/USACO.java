import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class USACO{
  public static int bronze(String filename) throws FileNotFoundException{
    int[][] squares;
    int[][] commands;   
    int row = 0, col = 0, el = 0, co = 0, ans = 0;

    // read in file --> instructions, array
    File text = new File(filename);
    Scanner inf = new Scanner(text);
    int i = 0;
    int n;
    while(inf.hasNextInt() && i < 4 ){
      n = inf.nextInt();
      if (i == 0){
        row = n;
      }
      if (i == 1){
        col = n;
      }
      if (i == 2){
        el = n;
      }
      if (i == 3){
        co = n;
      }
      i++;
    }

    squares = new int[row][col];
    commands = new int[co][3];

    File txt = new File(filename);
    Scanner in = new Scanner(txt);
    i = 0;
    while(in.hasNextInt() && i < (4 + row * col + co * 3)){
	n = in.nextInt();
	if (i >= 4){
	    if (i < (row * col) + 4){
		squares[(i - 4) / col][(i - 4) % col] = n;
	    }
	    else{
		commands[(i - (4 + row * col)) / 3][(i - (4 + row * col)) % 3] = n;
	    }
	}
	i++;
    }
    
    // follow through w stomps, recalc nums
  for (int z = 0; z < co; z++){
    int highest = 0;
    for (int a = 0; a < 3; a++){
      for (int b = 0; b < 3; b++){
        if (squares[a + commands[z][0] - 1][b + commands[z][1] - 1] > highest){
          highest = squares[a + commands[z][0] - 1][b + commands[z][1] - 1];
        }
      }
    }
    for (int a = 0; a < 3; a++){
      for (int b = 0; b < 3; b++){
        if (squares[a + commands[z][0] - 1][b + commands[z][1] - 1] > highest - commands[z][2]){
          squares[a + commands[z][0] - 1][b + commands[z][1] - 1] = highest - commands[z][2];
        }
      }
    }

  }
    
  // find elevations
  for (int a = 0; a < row; a++){
    for (int b = 0; b < col; b++){
      squares[a][b] = el - squares[a][b];
      if (squares[a][b] > 0){
	  ans += squares[a][b];
      }
    }
  }

    // convert to inches
    return ans * 72 * 72;
  }

  public static int silver(String filename) throws FileNotFoundException{
    // read in file, assign stuff
    char[][] grid;
    int[][] curPath;
    int[][] oldPath;
    int r = 0, c = 0, t = 0, r1 = 0, c1 = 0, r2 = 0, c2 = 0;
    int[][] moves = { {0,1}, {1,0}, {-1,0}, {0,-1} };

    File text = new File(filename);
    Scanner inf = new Scanner(text);
    int i = 0;
    int w;
    while (inf.hasNextLine() && i < 1){
      String line = inf.nextLine();
      Scanner s = new Scanner(line);
      if (i == 0){
        int a = 0;
        while (s.hasNextInt()){
	    w = s.nextInt();
          if (a == 0){
	      r = w;
          }
          if (a == 1){
            c = w;
          }
          if (a == 2){
            t = w;
          }
	  a++;
        }
      }
      i++;
    }
    
    grid = new char[r][c];
    curPath = new int[r][c];
    oldPath = new int[r][c];
    
    File txt = new File(filename);
    Scanner in = new Scanner(txt);
    i = 0;
    
    while(in.hasNextLine()){
      String line = in.nextLine();
      Scanner s = new Scanner(line);
      if (i > r){
        int a = 0;
        while (s.hasNextInt()){
	    w = s.nextInt();
          if (a == 0){
            r1 = w;
          }
          if (a == 1){
            c1 = w;
          }
          if (a == 2){
            r2 = w;
          }
          if (a == 3){
            c2 = w;
          }
	  a++;
        }
      }
      else{
	  if (i > 0){
	      for (int a = 0; a < line.length(); a++){
		  grid[i - 1][a] = line.charAt(a);
	      }
	  }
      }
      i++;
    }
    
    // set up oldPath
    oldPath[r1 - 1][c1 - 1] = 0;
    for (int x = 0; x < 4; x++){
	try{
	    oldPath[r1 + moves[x][0] - 1][c1 + moves[x][1] - 1] = 1;
	}
	catch(ArrayIndexOutOfBoundsException e){
	}
    }
    for (int a = 0; a < r; a++){
      for (int b = 0; b < c; b++){
        if (oldPath[a][b] != 0 && oldPath[a][b] != 1){
          oldPath[a][b] = 0;
        }
        if (grid[a][b] == '*'){
          oldPath[a][b] = -1;
        }
      }
    }  
    
    // use oldPath values to det new paths, using sum of neighbors
    int sum;
    for (int z = 0; z < t; z++){
	for (int a = 0; a < r; a++){
	    for (int b = 0; b < c; b++){
		if (oldPath[a][b] != -1){
		    sum = 0;
		    for (int x = 0; x < 4; x++){
			try{
			    if (oldPath[a + moves[x][0]][b + moves[x][1]] != -1){
				sum += oldPath[a + moves[x][0]][b + moves[x][1]];
			    }
			}
			catch (ArrayIndexOutOfBoundsException e){
			}
		    }
		    curPath[a][b] = sum;
		}
		else{
		    curPath[a][b] = -1;
		}
	    }
	}
	/*
	String q = "";
    for(int a = 0; a < oldPath.length; a++){
      for (int b = 0; b < oldPath[0].length; b++){
        q += oldPath[a][b];
        q += " ";
      }
      q += "\n";
    }
    System.out.println("old \n" + q);
	
	String m = "";
    for(int a = 0; a < curPath.length; a++){
      for (int b = 0; b < curPath[0].length; b++){
        m += curPath[a][b];
        m += " ";
      }
      m += "\n";
    }
    System.out.println("current \n" + m);
	*/
    for (int a  = 0; a < r; a++){
	for (int b = 0; b < r; b++){
	    oldPath[a][b] = curPath[a][b];
	}
    }
    }
    
    return curPath[r2 - 1][c2 - 1];
    // return -1;
  }
  
  public static void main(String[] args){
    try{
        //  System.out.println(bronze("cowStomp.txt"));
	System.out.println(silver("input.txt"));         
    }
    catch(FileNotFoundException e){
      System.out.println("file ples");
    }
  }
    
}
