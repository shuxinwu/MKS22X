import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class USACO{
  public static int bronze(String filename) throws FileNotFoundException{
    // read in file --> instructions, array
    int[][] squares;
    int[][] commands;
    int row = 0;
    int col = 0;
    int el = 0;
    int co = 0;
    int ans = 0;

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
      }
      if (i >= 4){
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
        commands[(i - (4 + row * col)) / 3][(i - (4 + row * col)) % 3]] = inf.nextInt();
      }
      i++;
    }

    // follow through w stomps, recalc nums
  for (int z = 0; z < co; z++){

    int highest = 0;
    for (int a = 0; a < 3; a++){
      for (int b = 0; b < 3; b++){
        if (squares[a + co[z][0]][b + co[z][1]] > highest){
          highest = squares[a + co[z][0]][b + co[z][1]];
        }
      }
    }
    for (int a = 0; a < 3; a++){
      for (int b = 0; b < 3; b++){
        if (squares[a + co[z][0]][b + co[z][1]] > highest - co[z][2]){
          squares[a + co[z][0]][b + co[z][1]] = highest - co[z][2];
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

  // public static int silver(String filename);
}
