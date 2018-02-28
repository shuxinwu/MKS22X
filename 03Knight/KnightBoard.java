public class KnightBoard{
    private int[][] board;
    private int[][] count;
    private int r;
    private int c;
  int[][] moves = {
    {1, 2}, {1, -2}, {-1, 2}, {-1, -2},
    {2, 1}, {2, -1}, {-2, 1}, {-2, -1}
  };
    
  public KnightBoard(int startingRows, int startingCols){
    if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    count = new int[startingRows][startingCols];
    for (int a = 0; a < startingRows; a++){
	    for (int b = 0; b < startingCols; b++){
        board[a][b] = 0;
        count[a][b] = countMoves(a, b); 
	    }
    }
  }

  public String toString(){
    String ans = "";
    for (int a = 0; a < board.length; a++){
	    for (int b = 0; b < board[0].length; b++){
        if (board[a][b] == 0){
          ans += "_";
        }
        else{
          if (board[a][b] < 10){
            ans += " ";
          }
          ans += board[a][b];
        }
        ans += " ";
	    }
	    ans += "\n";
    }
    return ans;
  }
    
  public boolean solve(int startingRow, int startingCol){
    r = startingRow;
    c = startingCol;
    if (startingRow < 0 || startingCol < 0 ||
        startingCol > board[0].length || startingRow > board.length){
      throw new IllegalArgumentException();
    }
    for (int a = 0; a < board.length; a++){
	    for (int b = 0; b < board[0].length; b++){
        if (board[a][b] != 0){
          throw new IllegalStateException();
        }
	    }
    }
    board[r][c] = 1;
    return solveH(startingRow, startingCol, 1);
  }

  private boolean solveH(int row, int col, int level){
    // level is the # of the knight
    if (level == board.length * board[0].length){
	    return true;
    }
    /*
    int current = 0;
    int lowCount = 0;
    int lowBoard = 0;
    for (int i = 0; i < 8; i++){
      if (canMove(row, col, moves[i][0], moves[i][1])){
        if (i == 0){
          lowCount = count[row + moves[i][0]][col + moves[i][1]];
          lowBoard = board[row + moves[i][0]][col + moves[i][1]];
        }
        if (count[row + moves[i][0]][col + moves[i][1]] <= lowCount &&
            board[row + moves[i][0]][col + moves[i][1]] <= lowBoard){
          current = i;
          lowCount = count[row + moves[i][0]][col + moves[i][1]];
          lowBoard = board[row + moves[i][0]][col + moves[i][1]];
        }
      }
    }
   
    //  move(moves[current][0], moves[current][1]);
    // move. then
    //  System.out.println(current);
    if (canMove(row, col, moves[current][0], moves[current][1])){
     
     r += moves[current][0];
    c += moves[current][1];
    System.out.println(r);
     System.out.println(c);
    board[r][c] += 1;
    if (board[r][c] == 1){
      level++;
    }
    }
    //  System.out.println(getBoard());
    return solveH(r, c, level);
    */
    return false;
  }

  public boolean canMove(int row, int col, int x, int y){
    //   System.out.println("row + x" + row + x);
    //  System.out.println("col + y" + col + y);
    return (row + x < board.length && row + x >= 0 && col + y < board[0].length && col + y >= 0);
  }

  /*
  public void move(int x, int y){
      r += x;
      c += y;
      board[r][c] += 1;
  }
  */

  public int countMoves(int x, int y){
    int count = 0;
    for (int i = 0; i < 8; i++){
      if (canMove(x, y, moves[i][0], moves[i][1])){
        count++;
      }
    }
    return count;
  }

   
  public String getBoard(){
    String r = "";
    for (int a = 0; a < board.length; a++){
      for (int b = 0; b < board[0].length; b++){
        r += board[a][b];
        r += " ";
      }
      r += "\n";
    }
    return r;
  }

  public String getCount(){
    String r = "";
    for (int a = 0; a < count.length; a++){
      for (int b = 0; b < count[0].length; b++){
        r += count[a][b];
        r += " ";
      }
      r += "\n";
    }
    return r;
  }
 
 
  public int countSolutions(int startingRow, int startingCol){
    int z = 0;
    if (startingRow < 0 || startingCol < 0 ||
        startingCol > board[0].length || startingRow > board.length){
      throw new IllegalArgumentException();
    }
    for (int a = 0; a < board.length; a++){
	    for (int b = 0; b < board[0].length; b++){
        if (board[a][b] != 0){
          throw new IllegalStateException();
        }
	    }
    }
   
    return z;
  }
	
}
