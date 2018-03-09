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
    while(inf.hasNextInt() && i < 4 ){
      if (i == 0){
        row = inf.nextInt();
      }
      if (i == 1){
        col = inf.nextInt();
      }
      if (i == 2){
        el = inf.nextInt();
      }
      if (i == 3){
        co = inf.nextInt();
      }
      i++;
    }

    squares = new int[row][col];
    commands = new int[co][3];

    File txt = new File(filename);
    Scanner in = new Scanner(txt);
    i = 0;
    while(in.hasNextInt() && i < (4 + row * col + co * 3)){
	System.out.println(i + "s");
	System.out.println(in.nextInt() + "s");
	if (i >= 4){
	    if (i < (row * col) + 4){
		System.out.println(i);
		System.out.println(in.nextInt());
		squares[(i - 4) / col][(i - 4) % col] = in.nextInt();
		//   System.out.println(in.nextInt());
	    }
	    else{
          commands[(i - (4 + row * col)) / 3][(i - (4 + row * col)) % 3] = in.nextInt();
      }
	}
	i++;
    }
    
    // follow through w stomps, recalc nums
  for (int z = 0; z < co; z++){

    int highest = 0;
    for (int a = 0; a < 3; a++){
      for (int b = 0; b < 3; b++){
	  //    System.out.println(commands[z][0]);
        if (squares[a + commands[z][0]][b + commands[z][1]] > highest){
          highest = squares[a + commands[z][0]][b + commands[z][1]];
        }
      }
    }
    for (int a = 0; a < 3; a++){
      for (int b = 0; b < 3; b++){
        if (squares[a + commands[z][0]][b + commands[z][1]] > highest - commands[z][2]){
          squares[a + commands[z][0]][b + commands[z][1]] = highest - commands[z][2];
        }
      }
    }

  }
  // find elevations
  for (int a = 0; a < row; a++){
    for (int b = 0; b < col; b++){
      squares[a][b] -= el;
      ans += squares[a][b];
    }
  }

    // convert to inches
    return ans * 72 * 72;
  }
  /*
    String m = "";
    for(int a = 0; a < squares.length; a++){
      for (int b = 0; b < squares[0].length; b++){
        m += squares[a][b];
        m += " ";
      }
      m += "\n";
    }
    System.out.println(m);
  */

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
    while (inf.hasNextLine() && i < 1){
      String line = inf.nextLine();
      Scanner s = new Scanner(line);
      if (i == 0){
        int a = 0;
        while (s.hasNextInt()){
          if (a == 0){
            r = s.nextInt();
          }
          if (a == 1){
            c = s.nextInt();
          }
          if (a == 2){
            t = s.nextInt();
          }
        }
      }
    }
    grid = new char[r][c];
    curPath = new int[r][c];
    oldPath = new int[r][c];
    i = 1;
    while(inf.hasNextLine()){
      String line = inf.nextLine();
      Scanner s = new Scanner(line);
      if (i > r){
        int a = 0;
        while (s.hasNextInt()){
          if (a == 0){
            r1 = s.nextInt();
          }
          if (a == 1){
            c1 = s.nextInt();
          }
          if (a == 2){
            r2 = s.nextInt();
          }
          if (a == 3){
            c2 = s.nextInt();
          }
        }
      }
      else{
        for (int a = 0; a < line.length(); a++){
          grid[i - 1][a] = line.charAt(a);
        }
      }
      i++;
    }

    // set up oldPath
    System.out.println(r1);
      System.out.println(c1);
    oldPath[r1][c1] = 0;
    for (int x = 0; x < 4; x++){
      oldPath[r1 + moves[x][0]][c1 + moves[x][1]] = 1;
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
    for (int z = 0; z < t; z++){
      for (int a = 0; a < r; a++){
        for (int b = 0; b < c; b++){
          int sum = 0;
          for (int x = 0; x < 4; x++){
            sum += oldPath[a + moves[x][0]][b + moves[x][1]];
          }
          curPath[a][b] = sum;
        }
      }
      oldPath = curPath;
    }
   
    // figure something out
    return curPath[r2][c2];
    // return -1;
  }
  
  public static void main(String[] args){
    try{
      System.out.println(bronze("cowStomp.txt"));
      // System.out.println(silver("input.txt"));         
    }
    catch(FileNotFoundException e){
	//  System.out.println("c");
    }
  }
  
}
