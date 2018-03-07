import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class USACO{
  public static int bronze(String filename) throws FileNotFoundException{
    // read in file --> instructions, array
    int[][] squares;
    int row = 0;
    int col = 0;
    int el = 0;
    int co = 0;

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

    i = 4;
    while(inf.hasNextInt()){
      squares[(i - 4) / col][(i - 4) % col] = inf.nextInt();
      i++;

    }


    // follow through w stomps, recalc nums

    // convert to inches

    return -1;

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
