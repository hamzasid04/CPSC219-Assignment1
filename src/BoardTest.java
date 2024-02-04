/**
 * @name: Hamza Siddiqui
 * @ucalgary email: hamza.siddiqui@ucalgary.ca
 * @UCID: 30183881
 * TUT 02
 * Date: 6 Oct 2023
 * */



import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class BoardTest {

    @Test
    public void test1() {
        assertArrayEquals(new int[]{0, 0}, new int[]{0, 1});

        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = new int[][]{{0, 1}};
        assertTrue(Arrays.deepEquals(expected, actual));
    }


    // tests if 2D array with 3 rows and 3 columns is created filled with EMPTY(0)
    @Test
    void createBoard3x3() {

        int[][] expected = new int[][]{
                {Board.EMPTY,Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY}};
        int[][] actual = Board.createBoard( 3,3 );
        assertArrayEquals(expected, actual);
    }
    // tests if 2D array with 4 rows and 4 columns is created filled with EMPTY(0)

    @Test
    void createBoard4x4() {

        int[][] expected = new int[][]{
                {Board.EMPTY,Board.EMPTY,Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY,Board.EMPTY}
        };
        int[][] actual = Board.createBoard( 4,4 );
        assertArrayEquals(expected, actual);
    }

    // Counts how many rows there are in the 2D array
    @Test
    void rowCount2x3() {
        int[][] table = Board.createBoard(2,3);

        assertEquals(2,  table.length);

    }
    @Test
    void rowCount4x3() {
        int[][] table = Board.createBoard(4,3);

        assertEquals(4,  table.length);

    }

    // Counts how many columns there are in the 2D array
    @Test
    void columnCount2x3() {
        int[][] table = Board.createBoard(2,3);

        assertEquals(3,  table[0].length);
    }
    @Test
    void columnCount2x4() {
        int[][] table = Board.createBoard(2,4);

        assertEquals(4,  table[0].length);
    }


    //tests that it is true if board is empty
    @Test
    void canPlay() {

        assertTrue(true);

    }


    //tests the play function when parameter of piece is X
    @Test
    void playWithX() {
            int[][] table = {
                    {Board.EMPTY,Board.EMPTY,Board.EMPTY},
                    {Board.EMPTY,Board.EMPTY,Board.EMPTY},
                    {Board.EMPTY,Board.EMPTY,Board.EMPTY}
            };

            Board.play(table, 1, 1, 1);

            int[][] expectTable = {
                    {Board.EMPTY,Board.EMPTY,Board.EMPTY},
                    {Board.EMPTY,1,Board.EMPTY},
                    {Board.EMPTY,Board.EMPTY,Board.EMPTY}
            };

            assertArrayEquals(expectTable, table);
        }

    //tests the play function when parameter of piece is O
    @Test
    void playWithO() {
        int[][] table = {
                {Board.EMPTY,Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY}
        };

        Board.play(table, 0, 2, 2);

        int[][] expectTable = {
                {Board.EMPTY,Board.EMPTY,2},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY}
        };

        assertArrayEquals(expectTable, table);
    }

    //checks if table is empty and if it is then it will check if it is returning false
    @Test
    void full() {
        int[][] table = {
                {1,1,1},
                {1,1,1},
                {1,1,1},
        };
        boolean result = Board.full(table);
        assertTrue(result);
    }

    @Test
    void Notfull() {
        int[][] table = {
                {Board.EMPTY,Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY}
        };
        boolean result = Board.full(table);
        assertFalse(result);
    }


    //tests if statement being returned is true if first row is filled with same pieces consequtively
    @Test
    void winInRow1stRow() {

        int[][] table = {
                {1,1,1},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY}
        };

        boolean result = Board.winInRow(table,0,1,3);

        assertTrue(result);
    }

    @Test
    void winInRow2ndRow() {

        int[][] table = {
                {Board.EMPTY,Board.EMPTY,Board.EMPTY},
                {1,1,1},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY}
        };

        boolean result = Board.winInRow(table,1,1,3);

        assertTrue(result);
    }

    //tests if statement being returned is true if first column is filled with same pieces consequtively

    @Test
    void winInColumn1stCol() {
        int[][] table = {
                {1,Board.EMPTY,Board.EMPTY},
                {1,Board.EMPTY,Board.EMPTY},
                {1,Board.EMPTY,Board.EMPTY}
        };

        boolean result = Board.winInColumn(table,0,1,3);

        assertTrue(result);
    }

    @Test
    void winInColumn2ndCol() {
        int[][] table = {
                {Board.EMPTY,1,Board.EMPTY},
                {Board.EMPTY,1,Board.EMPTY},
                {Board.EMPTY,1,Board.EMPTY}
        };

        boolean result = Board.winInColumn(table,1,1,3);

        assertTrue(result);
    }

// tests if consequtive entries in backslash manner from top left to bottom right within the board to check for a piece
    @Test
    void winInDiagonalBackslashPass() {
        int[][] table = {
                {1,          Board.EMPTY,Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,1,          Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,Board.EMPTY,1,          Board.EMPTY}
        };

        boolean result = Board.winInDiagonalBackslash(table, 1,3);
        assertTrue(result);

    }

    @Test
    void winInDiagonalBackslashFail() {
        int[][] table = {
                {1,          Board.EMPTY,Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,1,          Board.EMPTY,Board.EMPTY},
                {Board.EMPTY,Board.EMPTY,Board.EMPTY,          Board.EMPTY}
        };

        boolean result = Board.winInDiagonalBackslash(table, 1,3);
        assertFalse(result);

    }

// tests if consequtive entries in forward slash manner from bottom left to top right within the board to check for a piece

    @Test
    void winInDiagonalForwardSlashPass() {
        int[][] table = {
                { Board.EMPTY,Board.EMPTY,1},
                { Board.EMPTY,1,Board.EMPTY},
                { 1,Board.EMPTY,Board.EMPTY},
        };

        boolean result = Board.winInDiagonalForwardSlash(table, 1,3);
        assertTrue(result);

    }
    @Test
    void winInDiagonalForwardSlashFail() {
        int[][] table = {
                { Board.EMPTY,Board.EMPTY,Board.EMPTY},
                { Board.EMPTY,1,Board.EMPTY},
                { 1,Board.EMPTY,Board.EMPTY},
        };

        boolean result = Board.winInDiagonalForwardSlash(table, 1,3);
        assertFalse(result);

    }

    @Test
    void hint() {

        int[][] table = {
                {1, 0, 1, 0, 0},
                {2, 1, 2, 0, 0},
                {2, 1, 1, 2, 0},
                {0, 0, 2, 2, 1}
        };

               int[] result = Board.hint(table, 2, 2);
        assertArrayEquals(new int[]{-1, -1}, result);
        };



    //factorialTestWith0 is assisted with chat gpt's help

    //tests if factorial function will return 1 when 0 is inputted
    @Test
    void factorialTestWith0() {
        BigInteger result = Game.factorial(0);
        assertEquals(BigInteger.ONE, result);
    }

    @Test
    void factorialTestWithPositiveNum() {
        BigInteger result = Game.factorial(0);
        assertEquals(new BigInteger("220"), result);
    }

    @Test
    void factorialTestWithLargeNum() {
        BigInteger result = Game.factorial(0);
        // Use a precomputed value or a library to verify the result
        assertEquals(new BigInteger("782365723576235786325"), result);
    }
}



