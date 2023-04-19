import java.util.ArrayList;

/**
 * Represents a Piece on a checkerboard
 */
public class Piece {

    /**
     * Represents the color of the piece. Can be either 'r' or 'b'
     */
    private char color;

    /**
     * Constructs either a red Piece or a black Piece
     * @param color the color of the Piece
     */
    public Piece(char color) {
        this.color = color;
    }

    /**
     * Determines all valid moves around this piece
     * @return a list of the valid moves around this piece
     * @see Game
     */
    public ArrayList<Move> validMove() {
        return new ArrayList<Move>();
    }

    /**
     * Determines all valid jumps around this piece
     * @return a list of the valid jumps around this piece
     * @see Game
     */
    public ArrayList<Move> validJumps() {
        return new ArrayList<Move>();
    }
}
