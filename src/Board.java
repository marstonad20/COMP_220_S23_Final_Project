import java.util.ArrayList;

/**
 * Represents the state of a board in a game of Checkers
 */
public class Board {

    /**
     * Contains the Pieces on the checkerboard
     */
    private ArrayList<ArrayList<Piece>> board = new ArrayList<ArrayList<Piece>>(8);

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
    public Piece getPiece(Square sq) {
        return new Piece('b');
    }

    /**
     * Puts a Piece in a location on the board, or changes a Piece that was there
     * @param sq
     * @param pc
     */
    public void setPiece(Square sq, Piece pc) {

    }

    /**
     * Moves a piece from the location of the startSquare of the passed in Move to the location
     * of the endSquare of the Move
     */
    public void movePiece(Move move) {

    }

    /**
     * Checks if the given piece is eligible for kingship, and, if it is, returns
     * a King with the same color as the Piece passed in
     * @param pc
     * @return
     */
    public King promote(Piece pc) {
        return new King('b');
    }
}
