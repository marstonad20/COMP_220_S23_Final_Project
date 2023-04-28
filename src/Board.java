import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the state of a board in a game of Checkers
 */
public class Board {
    /**
     * The number of rows and columns in a square checkers board
     */
    private static final int SIZE = 8;
    /**
     * 2D array representing state of checkers board
     */
    private static char[][] currentBoard = new char[SIZE][SIZE];

    /**
     * Creates a checkers board with the checkers arrayed in the
     * starting pattern
     * 'b' = black pawn
     * 'B' = black king
     * 'r' = red pawn
     * 'R' = red King
     * ' ' = open space
     */

    public Board() {
        currentBoard[0][0] = 'b';
        currentBoard[0][1] = ' ';
        currentBoard[0][2] = 'b';
        currentBoard[0][3] = ' ';
        currentBoard[0][4] = 'b';
        currentBoard[0][5] = ' ';
        currentBoard[0][6] = 'b';
        currentBoard[0][7] = ' ';

        currentBoard[1][0] = ' ';
        currentBoard[1][1] = 'b';
        currentBoard[1][2] = ' ';
        currentBoard[1][3] = 'b';
        currentBoard[1][4] = ' ';
        currentBoard[1][5] = 'b';
        currentBoard[1][6] = ' ';
        currentBoard[1][7] = 'b';

        currentBoard[2][0] = 'b';
        currentBoard[2][1] = ' ';
        currentBoard[2][2] = 'b';
        currentBoard[2][3] = ' ';
        currentBoard[2][4] = 'b';
        currentBoard[2][5] = ' ';
        currentBoard[2][6] = 'b';
        currentBoard[2][7] = ' ';

        currentBoard[3][0] = ' ';
        currentBoard[3][1] = ' ';
        currentBoard[3][2] = ' ';
        currentBoard[3][3] = ' ';
        currentBoard[3][4] = ' ';
        currentBoard[3][5] = ' ';
        currentBoard[3][6] = ' ';
        currentBoard[3][7] = ' ';

        currentBoard[4][0] = ' ';
        currentBoard[4][1] = ' ';
        currentBoard[4][2] = ' ';
        currentBoard[4][3] = ' ';
        currentBoard[4][4] = ' ';
        currentBoard[4][5] = ' ';
        currentBoard[4][6] = ' ';
        currentBoard[4][7] = ' ';

        currentBoard[5][0] = 'r';
        currentBoard[5][1] = ' ';
        currentBoard[5][2] = 'r';
        currentBoard[5][3] = ' ';
        currentBoard[5][4] = 'r';
        currentBoard[5][5] = ' ';
        currentBoard[5][6] = 'r';
        currentBoard[5][7] = ' ';

        currentBoard[6][0] = ' ';
        currentBoard[6][1] = 'r';
        currentBoard[6][2] = ' ';
        currentBoard[6][3] = 'r';
        currentBoard[6][4] = ' ';
        currentBoard[6][5] = 'r';
        currentBoard[6][6] = ' ';
        currentBoard[6][7] = 'r';

        currentBoard[7][0] = 'r';
        currentBoard[7][1] = ' ';
        currentBoard[7][2] = 'r';
        currentBoard[7][3] = ' ';
        currentBoard[7][4] = 'r';
        currentBoard[7][5] = ' ';
        currentBoard[7][6] = 'r';
        currentBoard[7][7] = ' ';


    }

    public void printBoard() {
        // System.out.println("====================================");

        System.out.println();

        System.out.println("     0   1   2   3   4   5   6   7");

        System.out.println(" 0 | " + currentBoard[0][0] + " | " + currentBoard[0][1] + " | " + currentBoard[0][2] + " | " +
                currentBoard[0][3] + " | " + currentBoard[0][4] + " | " + currentBoard[0][5] + " | " + currentBoard[0][6]
                + " | " + currentBoard[0][7] + " |");
        System.out.println("   ---------------------------------");

        System.out.println(" 1 | " + currentBoard[1][0] + " | " + currentBoard[1][1] + " | " + currentBoard[1][2] + " | " +
                currentBoard[1][3] + " | " + currentBoard[1][4] + " | " + currentBoard[1][5] + " | " + currentBoard[1][6]
                + " | " + currentBoard[1][7] + " |");
        System.out.println("   ---------------------------------");

        System.out.println(" 2 | " + currentBoard[2][0] + " | " + currentBoard[2][1] + " | " + currentBoard[2][2] + " | " +
                currentBoard[2][3] + " | " + currentBoard[2][4] + " | " + currentBoard[2][5] + " | " + currentBoard[2][6]
                + " | " + currentBoard[2][7] + " |");
        System.out.println("   ---------------------------------");

        System.out.println(" 3 | " + currentBoard[3][0] + " | " + currentBoard[3][1] + " | " + currentBoard[3][2] + " | " +
                currentBoard[3][3] + " | " + currentBoard[3][4] + " | " + currentBoard[3][5] + " | " + currentBoard[3][6]
                + " | " + currentBoard[3][7] + " |");
        System.out.println("   ---------------------------------");

        System.out.println(" 4 | " + currentBoard[4][0] + " | " + currentBoard[4][1] + " | " + currentBoard[4][2] + " | " +
                currentBoard[4][3] + " | " + currentBoard[4][4] + " | " + currentBoard[4][5] + " | " + currentBoard[4][6]
                + " | " + currentBoard[4][7] + " |");
        System.out.println("   ---------------------------------");

        System.out.println(" 5 | " + currentBoard[5][0] + " | " + currentBoard[5][1] + " | " + currentBoard[5][2] + " | " +
                currentBoard[5][3] + " | " + currentBoard[5][4] + " | " + currentBoard[5][5] + " | " + currentBoard[5][6]
                + " | " + currentBoard[5][7] + " |");
        System.out.println("   ---------------------------------");

        System.out.println(" 6 | " + currentBoard[6][0] + " | " + currentBoard[6][1] + " | " + currentBoard[6][2] + " | " +
                currentBoard[6][3] + " | " + currentBoard[6][4] + " | " + currentBoard[6][5] + " | " + currentBoard[6][6]
                + " | " + currentBoard[6][7] + " |");
        System.out.println("   ---------------------------------");


        System.out.println(" 7 | " + currentBoard[7][0] + " | " + currentBoard[7][1] + " | " + currentBoard[7][2] + " | " +
                currentBoard[7][3] + " | " + currentBoard[7][4] + " | " + currentBoard[7][5] + " | " + currentBoard[7][6]
                + " | " + currentBoard[7][7] + " |");
        // System.out.println("====================================");

        System.out.println();
    }

    /**
     * Returns the kind of checker piece (if any) in a particular space on the board
     *
     * @param loc integer array of coords on the board representing a location
     * @return the kind of checker piece in that space
     */
    public static char getValue(int[] loc) {
//        int x = loc[0];
//        int y = loc[1];

        return (currentBoard[loc[0]] [loc[1]]);
    }

    /**
     * Puts a Piece in a location on the board, or changes a Piece that was there
     *
     * @param loc location array of board coords for set value
     * @param p   character to set space to
     */
    public void setValue(int[] loc, char p) {
//        int x = loc[0];
//        int y = loc[1];

        currentBoard[loc[0]] [loc[1]] = p;
    }
}
