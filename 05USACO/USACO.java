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
    while(inf.hasNextInt()){
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
        i += 100000;
      }
      i++;
    }

    squares = new int[row][col];
    commands = new int[co][3];

    i = 4;
    while(inf.hasNextInt()){
      if (i < 4 + row * col){
        squares[(i - 4) / col][(i - 4) % col] = inf.nextInt();
      }
      else{
        commands[(i - (4 + row * col)) / 3][(i - (4 + row * col)) % 3] = inf.nextInt();
      }
      i++;
    }

    // follow through w stomps, recalc nums
  for (int z = 0; z < co; z++){

    int highest = 0;
    for (int a = 0; a < 3; a++){
      for (int b = 0; b < 3; b++){
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
        }
        m += "\n";
      }
    System.out.println(m);
  */

  public static int silver(String filename) throws FileNotFoundException{
    // read in file, assign stuff
    char[][] grid;
    int r = 0, c = 0, t = 0, r1 = 0, c1 = 0, r2 = 0, c2 = 0;

    File text = new File(filename);
    Scanner inf = new Scanner(text);
    int i = 0;
    while (inf.hasNextLine()){
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
      i += 100000;
    }
    grid = new char[r][c];
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

    // figure something out
    return -1;
  }
}
