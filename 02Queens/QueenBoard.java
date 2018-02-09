public class QueenBoard{
    private int[][] board;

    public QueenBoard(int size){
	int[][] board = new int[size][size];
	for (int a = 0; a < size; a++){
	    for (int b = 0; b < size; b++){
		board[a][b] = 0;
	    }
	}
    }

    /*
    private boolean addQueen(int r, int c){
	
    }
    
    private boolean removeQueen(int r, int c){}
    */
    public String toString(){
	String ans = "";
	for (int a = 0; a < size; a++){
	    for (int b = 0; b < size; b++){
		if (board[a][b] == -1){
		    ans += "Q";
		}
		else{
		    ans += "_";
		}
		ans += " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    /*
    public boolean solve(){}

    public int countSolutions(){}
    */
}
