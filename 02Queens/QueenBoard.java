public class QueenBoard{
  private int[][] board;
  private int s;
  private int q;

  public QueenBoard(int size){
    board = new int[size][size];
    s = size;
    for (int a = 0; a < s; a++){
	    for (int b = 0; b < s; b++){
        board[a][b] = 0;
	    }
    }
  }

  private boolean addQueen(int r, int c){
    int o = board[r][c];
    if (!edit(r, c, 1, 1, 1) ||
        !edit(r, c, 1, -1, 1) ||
        !edit(r, c, -1, 1, 1) ||
        !edit(r, c, -1, -1, 1) ){
      removeQueen(r, c, o);
      return false;
    }
    board[r][c] = -1;
    q++;
    return true;
  }
  
  private void removeQueen(int r, int c, int o){
    edit(r, c, 1, 1, -1);
    edit(r, c, 1, -1, -1);
    edit(r, c, -1, -1, -1);
    edit(r, c, -1, 1, -1);
    board[r][c] = o;
  }

  // same row, same col, awful diagon alleys
  public boolean edit(int r, int c, int x, int y, int z){
    int a = r + x;
    int b = c + y;
    for (int i = 0; i < s; i++){
      if (board[r][i] == -1 || board[i][c] == -1){
        return false;
      }
      else{
        board[r][i] += 1;
        board[i][c] += 1;
      }
    }
    while (a < s && a > -1 && b < s && b > -1){
      if (board[a][b] == -1){
        return false;
      }
      else{
        board[a][b] += z;
      }
      a += x;
      b += y;
    }
    return true;
  }
  
  public String toString(){
    String ans = "";
    for (int a = 0; a < s; a++){
	    for (int b = 0; b < s; b++){
        //    System.out.println(board[a][b]);
        if (!solve()){
          ans += "0";
        }
        else{
          if (board[a][b] == -1){
            ans = ans + "Q";
          }
          else{
            ans += "_";
          }
        }
        ans += " ";
	    }
	    ans += "\n";
    }
    return ans;
  }

  public boolean solve(){
    for (int r = 0; r < s; r++){
      for (int c = 0; c < s; c++){
        if (board[r][c] == 0){
          addQueen(r, c);
        }
      }
    }
    return q > 0;
  }
  
  //  public int countSolutions(){}

}
