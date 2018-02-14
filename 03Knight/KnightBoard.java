public class KnightBoard{
    private int[][] board;
    
    public KnightBoard(int startingRows, int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[startingRows][startingCols];
	for (int a = 0; a < startingRows; a++){
	    for (int b = 0; b < startingCols; b++){
	        board[a][b] = 0;
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
		ans += " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public void move(int r, int c, int x, int y){
	r += x;
	r += y;
	
    }

    
    public boolean solve(int startingRow, int startingCol){
	for (int a = 0; a < board.length; a++){
	    for (int b = 0; b < board[0].length; b++){
		if (board[a][b] == 0){
		  throw new IllegalStateException();
		}
	if (startingRow < 0 || startingCol < 0 || startingCol > || startingRow > ){
	    throw new IllegalArgumentException();
	}
	
    }

    /*
    public int countSolutions(int startingRow, int startingCol){}

    private boolean solveH(int row, int col, int level){}
    */
	
}
