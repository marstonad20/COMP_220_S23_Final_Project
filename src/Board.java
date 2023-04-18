import java.util.ArrayList;

/**
 * Represents the state of a board in a game of Checkers
 */
public class Board {

    /**
     * The number of rows/cols in this square checkerboard
     */
    private final int SIZE = 8;

    /**
     * A 2D array representing the state of this checkerboard
     * Key:
     * r = red pawn
     * b = black pawn
     * R = red king
     * B = black king
     * ' ' = empty square
     */
    private char[][] board = new char[SIZE][SIZE];

    /**
     * Creates a checkers board with the checkers arrayed in the
     * starting pattern
     */
    public Board() {
        // fill in board with initial pattern of checkers
    }

    /**
     * Returns the kind of checker piece (if any) in a particular space on the board
     * @param sq location on the board represented by a Square object
     * @return the kind of checker piece in that space
     */
    public char getSquareValue(Square sq) {
        return ' ';
    }

    /**
     * Sets the kind of checker piece on the board to a particular kind
     * @param sq location on the board represented by a Square object
     * @param team the kind of value that space will be set to
     */
    public void setSquareValue(Square sq, char team) {

    }

    /**
     *
     */
    public void movePiece(Square startSquare, Square endSquare) {

    }

    /**
     *
     */
    public void jumpPiece(Square startSquare, Square endSquare) {

    }
}
