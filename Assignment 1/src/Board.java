// Name: Hamza Siddiqui
// UCID: 30183881
//Assignment 1
/**
 * @name: Hamza Siddiqui
 * @ucalgary email: hamza.siddiqui@ucalgary.ca
 * @UCID: 30183881
 * TUT 02
 * Date: 6 Oct 2023
 * */
public class Board {

    /**
     * No piece in board
     */
    public static final int EMPTY = Game.EMPTY;
    /**
     * Tic Tac Toe piece X
     */
    public static final int X = Game.X;
    /**
     * Tic Tac Toe piece O
     */
    public static final int O = Game.O;

    /*----------------------------------------------------------------------------------------------------------
     * STUDENT CODE
     * ---------------------------------------------------------------------------------------------------------- */

    //Put your code here
    //createBoard

    /**
     * Creates tic tac toe board with specified number of rows and columns with positive integer size according to user
     *
     * @param rows    the first dimension (number of rows) of the 2 Dimension array
     * @param columns the second dimension (number of columns) of the 2 Dimension array
     * @return 2D integer array of EMPTY rows and columns when created
     */

    public static int[][] createBoard(int rows, int columns) {

        int[][] board = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int x = 0; x < columns; x++) {

                board[i][x] = Board.EMPTY;
            }
            ;
        }
        ;
        return board;
    }

    ;

    public static void aFunc() {

    }
    //rowCount

    /**
     * returns the number of rows in the board/2D array
     *
     * @param board 2D integer array
     * @return integer length for number of rows
     */

    public static int rowCount(int[][] board) {

        return board.length;
    }

    ;
    //columnCount

    /**
     * returns the number of columns in the board/2D array
     *
     * @param board 2D integer array
     * @return integer length for number of columns in 2D array
     */

    public static int columnCount(int[][] board) {

        return board[0].length;
    }

    ;
    //canPlay

    /**
     * Is there an empty spot within the board/ 2D array
     *
     * @param board 2D integer array
     * @param row   the index of a certain row entered by user
     * @param col   the index of certain column entered by user
     * @return true if the certain row and column is EMPTY or 0 otherwise will return false
     */
    public static boolean canPlay(int[][] board, int row, int col) {

        if (board[row][col] == Board.EMPTY) {
            return true;
        } else {
            return false;
        }

    }

    //play

    /**
     * Assigns a piece within the board/2D array
     *
     * @param board 2D integer array
     * @param row   the index of a certain row entered by user
     * @param col   the index of certain column entered by user
     * @param piece the option between X==1 or O==2 entered by user
     * @return void
     */
    public static void play(int[][] board, int row, int col, int piece) {

        //int X = 1;
        //int O = 2;

        if (board[row][col] == Board.EMPTY) {
            board[row][col] = piece;
            if (piece == 1) {
                int X = 1;
            } else if (piece == 2) {
                int O = 2;
            }
        }
        ;

        return;
    }
    //full

    /**
     * Checks if there all the spots in the board/2D array are full or not
     *
     * @param board 2D integer array
     * @return true if all elements are not EMPTY(0). return false if some elements within the 2D array are EMPTY(0)
     */
    public static boolean full(int[][] board) {

        for (int row = 0; row <= board.length; row++) {
            for (int col = 0; col <= board[0].length; col++) {
                if (board[row][col] != Board.EMPTY) {

                    return true;
                } else {
                    return false;
                }
            }
            ;
        }
        ;
        return false;
    }

    ;
    //winInRow


    /**
     * Checks if the specified row has consequtive entries of X or O
     *
     * @param board  2D integer array
     * @param row    the integer specified row to look at (dimension 1 )
     * @param piece  the integer entry of either (X) 1 or (O) 2
     * @param length the integer size of the row
     * @return true if there are consequtive entries of X or O
     */
    // the col variable will increment whenver it has found a matching piece in the indicated row and through all the columns.
    // if consequtiveCounts = length or the max num of column, it means that all the columns in the indicated row have the same piece
    public static boolean winInRow(int[][] board, int row, int piece, int length) {

        int rowConsequtiveCounts = 0;

        for (int col = 0; col < board[row].length; col++) {
            if (board[row][col] == piece) {
                rowConsequtiveCounts++;
            }
            ;
        }
            if (rowConsequtiveCounts == length) {
                return true;
            } else {
                rowConsequtiveCounts = 0;
            }



        return false;

    }

    ;
    //winInColumn

    /**
     * Checks if the specified column has consequtive entries of X or O
     *
     * @param board  2D integer array
     * @param col    the integer specified column to look at (dimension 2 )
     * @param piece  the integer entry of either (X) 1 or (O) 2
     * @param length the integer size of the column
     * @return true if there are consequtive entries of X or O
     */
    public static boolean winInColumn(int[][] board, int col, int piece, int length) {
        int colConsequtiveCounts = 0;

        for (int row = 0; row < board.length; row++) {
            if ((board[row][col] == piece)) {
                colConsequtiveCounts++;
            }
            ;
        }
            if (colConsequtiveCounts == length) {
                return true;
            } else {
                colConsequtiveCounts = 0;
            }



        return false;
    }

    ;

    //winInDiagonalBackslash

    /**
     * Checks if there are consequtive diagonal entries in backslash style (down and right) of piece
     *
     * @param board  2D integer array
     * @param piece  the integer entry of either (X) 1 or (O) 2
     * @param length the integer size of how many consequtive entries there should be in order to count as consequtive entry
     * @return true if there are consequtive entries matches length or else return false
     */

    public static boolean winInDiagonalBackslash(int[][] board, int piece, int length) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int consequtiveEntry = 0;
                if (board[row][col] == piece) {

                    consequtiveEntry++;

                }
// (row + 1 < board.length) && (col + 1 < board[row].length) allows me to continue checking so that i dont run out and ensure whatever is being checked is within the board
                if ((row + 1 < board.length) && (col + 1 < board[row].length)) {
                    if (board[row + 1][col + 1] == piece) {
                        consequtiveEntry++;
                    }
                }
                if ((row + 2 < board.length) && (col + 2 < board[row].length)) {
                    if (board[row + 2][col + 2] == piece) {
                        consequtiveEntry++;
                    }
                }
                if (consequtiveEntry == length) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if there are consequtive diagonal entries in forward slash style (up and right) of piece
     *
     * @param board  2D integer array
     * @param piece  the integer entry of either (X) 1 or (O) 2
     * @param length the integer size of how many consequtive entries there should be in order to count as consequtive entry
     * @return true if there are consequtive entries matches length or else return false
     */
    //winInDiagonalForwardSlash
    public static boolean winInDiagonalForwardSlash(int[][] board, int piece, int length) {
        for (int row = board.length - 1; row >= 0; row--) {
            for (int col = 0; col < board[row].length; col++) {
                int consequtiveEntry = 0;
                if (board[row][col] == piece) {

                    consequtiveEntry++;

                }
// (row + 1 < board.length) && (col + 1 < board[row].length) allows me to continue checking so that i dont run out and ensure whatever is being checked is within the board
                if ((row - 1 >= 0) && (col + 1 < board[row].length)) {
                    if (board[row - 1][col + 1] == piece) {
                        consequtiveEntry++;
                    }
                }
                if ((row - 2 >= 0) && (col + 2 < board[row].length)) {
                    if (board[row - 2][col + 2] == piece) {
                        consequtiveEntry++;
                    }
                }
                if (consequtiveEntry == length) {
                    return true;
                }
            }
        }
        return false;
    }
    ;
    //hint

    /**
     * Scans the rows from left to right and returns 1D integer array for the hints
     *
     * @param board  2D integer array
     * @param piece  the integer entry of either (X) 1 or (O) 2
     * @param length the integer size of the row
     * @return 1D integer array containing {row,column} to be used as a hint
     */
    public static int[] hint(int[][] board, int piece, int length) {

        for (int row = 0; row <= board.length; row++) {
            for (int col = 0; col <= board[row].length; col++) {
                if (board[row][col] == piece) {
                    board[row][col] = piece;
                    if (Board.won(board, piece, length) == true) {
                        board[row][col] = 0;
                        return new int[]{row, col};
                    } else {
                        board[row][col] = 0;
                    }
                    ;

                }
            }
        }
        ;
        return new int[]{-1, -1};
    }

    ;


    //The following are completed for you already


    /**
     * Is there a win in given board in any row of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for 3 in a row for any row
     * @return True if there is 3 in any row, False otherwise
     */
    private static boolean winInAnyRow(int[][] board, int piece, int length) {
        for (int row = 0; row < board.length; row++) {
            if (Board.winInRow(board, row, piece, length)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Is there a win in given board in any column of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for 3 in a row for any column
     * @return True if there is 3 in any column, False otherwise
     */
    private static boolean winInAnyColumn(int[][] board, int piece, int length) {
        for (int col = 0; col < board[0].length; col++) {
            if (Board.winInColumn(board, col, piece, length)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Is there a win in given board in any diagonal of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for 3 in a row for any diagonal
     * @return True if there is 3 in any diagonal /\, False otherwise
     */
    private static boolean winInAnyDiagonal(int[][] board, int piece, int length) {
        return Board.winInDiagonalBackslash(board, piece, length) || Board.winInDiagonalForwardSlash(board, piece, length);
    }


    /**
     * Has the given piece won the board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to check for a win
     * @return True if piece has won
     */
    public static boolean won(int[][] board, int piece, int length) {
        return winInAnyRow(board, piece, length) || winInAnyColumn(board, piece, length) || winInAnyDiagonal(board, piece, length);
    }

    /**
     * This function determines if the game is complete due to a win or tie by either player
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @return True if game is complete, False otherwise
     */
    public static boolean isGameOver(int[][] board, int length) {
        return Board.full(board) || won(board, X, length) || won(board, O, length);
    }

}




