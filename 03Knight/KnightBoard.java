public class KnightBoard{
    private int[][] board;
    private int[][] count;
    private int r;
    private int c;
    
    public KnightBoard(int startingRows, int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[startingRows][startingCols];
	count = new int[startingRows][startingCols];
	for (int a = 0; a < startingRows; a++){
	    for (int b = 0; b < startingCols; b++){
	        board[a][b] = 0;
		count[a][b] = 0;
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
	count[r][c] = 1;
	/*
	System.out.println(startingRow < 0);
	System.out.println(startingCol < 0);
	System.out.println(startingCol > board[0].length);
	System.out.println(startingRow > board.length);
	*/
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
	return solveH(startingRow, startingCol, 0);
    }

    private boolean solveH(int row, int col, int level){
    // level is the # of the knight
	if (level == board.length * board[0].length){
	    return true;
	}	
	return false;
    }

    public void move(int x, int y){
	r += x;
	c += y;	
    }
 
    // public int countSolutions(int startingRow, int startingCol){}
	
}
