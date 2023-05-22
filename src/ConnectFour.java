import java.util.Arrays;

/**
 * @version 05/18/23
 * @author 26roederer
 * public class for conect 4 that implements boardgame
 * WORKED WITH PRESTON
 */
public class ConnectFour implements BoardGame {
    private int[] [] board;
    private int currentPlayer;
    public int winner;
    private Position[] winningPositions;

    /**
     * creates a new game
     */
    public ConnectFour()    {
        newGame();
    }

    /**
     * Prepares the board for a new game.
     */
    @Override
    public void newGame() {
        board= new int [6] [7];
        currentPlayer=1+(int)(Math.random()*2);
        winningPositions=new Position[4];
    }

    /**
     * boolean method for if the game is over
     * @return true if the game is over, false otherwise
     */
    @Override
    public boolean gameOver() {
        return checkRow() || checkCol() || checkLeftDiags()|| checkRightDiags();


    }

    /**
     * boolean method for checking the columns for a winner
     * @return true if there is a winner on a colum and false  otherwise
     */
    public boolean checkCol(){
        for(int j = 0; j <= 6; j++) {
            for(int i = 5; i >= 3; i--){
                if(board[i][j] == 0){
                    break;
                }
                else if(board[i][j] == board[i-1][j] && board[i-1][j] == board[i-2][j] && board[i-2][j] == board[i-3][j]){
                    winner = board[i][j];
                    winningPositions[0] = new Position(i, j);
                    winningPositions[1] = new Position(i-1, j);
                    winningPositions[2] = new Position(i-2, j);
                    winningPositions[3] = new Position(i-3, j);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * boolean method for checking the rows for a winner
     * @return true if there is a winner on a row and false  otherwise
     */
    public boolean checkRow(){
        for(int i = 5; i >= 0; i--){
            for(int j = 0; j <= 3; j++) {
                if(board[i][j] == 0){
                    break;
                }
                else if(board[i][j] == board[i][j+1] && board[i][j+1] == board[i][j+2] && board[i][j+2] == board[i][j+3]){
                    winner = board[i][j];
                    winningPositions[0] = new Position(i, j);
                    winningPositions[1] = new Position(i, j+1);
                    winningPositions[2] = new Position(i, j+2);
                    winningPositions[3] = new Position(i, j+3);
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * boolean method for checking the left diagonals for a winner
     * @return true if there is a winner on a left diagonal and false otherwise
     */
    public boolean checkLeftDiags() {
        for ( int j = 3; j >= 0; j--) {
            for(int i =2; i>=0;i--){
                if(board[i][j]==0){
                    break;
                }
                else if(board[i][j] == board[i+1][j+1] && board[i+1][j+1] == board[i+2][j+2] && board[i+2][j+2] == board[i+3][j+3]){
                     winner = board[i][j];
                     winningPositions[0] = new Position(i, j);
                    winningPositions[1] = new Position(i+1, j+1);
                    winningPositions[2] = new Position(i+2, j+2);
                    winningPositions[3] = new Position(i+3, j+3);
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * boolean method for checking the Right diagonals for a winner
     * @return true if there is a winner on a Right diagonal and false otherwise
     */
    public boolean checkRightDiags(){
        for( int j= 0; j <= 3; j++) {
            for(int i= 5; i >= 3; i-- ){
                if(board[i][j] == 0){
                    break;
                }
                else if(board[i][j] == board[i-1][j+1] && board[i-1][j+1] == board[i-2][j+2] && board[i-2][j+2] == board[i-3][j+3]){
                    winner = board[i][j];
                    winningPositions[0] = new Position(i, j);
                    winningPositions[1] = new Position(i-1, j+1);
                    winningPositions[2] = new Position(i-2, j+2);
                    winningPositions[3] = new Position(i-3, j+3);
                    return true;
                }
            }
        }
        return false;
    }
    /**
    * returns the int value of the winner
    * @return 0 if there is no winner, 1 if the first player is a winner, 2 if the second player is a winner.
     * */
     @Override
     public int getWinner () {
        return winner;
            }

     /**
     * gets the position of the win
      * @return the locations of the pieces that determine the game winner.
      */
     @Override
     public Position[] getWinningPositions () {
         return winningPositions;
     }

     /**
     * return if the column is full
     * @param column the column number
     * @return false if there is room for another move in the column, true if not.
      */
     @Override
     public boolean columnFull ( int column){
         return board[0][column] != 0;
     }

     /**
      * changes the color of the piece to the right color for that player
      * @param column the column number
      */
      @Override
      public void play ( int column){
           if (!columnFull(column)) {
               for (int r = 5; r >= 0; r--) {
                   if (board[r][column] == 0) {
                       board[r][column] = currentPlayer;
                       currentPlayer = (currentPlayer == 1 ? 2 : 1);
                       System.out.println(currentPlayer);
                            return;
                   }
               }
           }
      }

            /**
             * gets what is on the board right now
             * @return for each cell on the board grid:
             * 0 if it is not filled,
             * 1 if it is filled by the first player's piece,
             * 2 if it is filled by the second player's piece.
             */
            @Override
      public int[][] getBoard () {
          return board;
      }

    /**
     * gets the cur-rent player
     * @return the int value of the current player
     */
      public int getCurrentPlayer () {
          return currentPlayer;
      }

}