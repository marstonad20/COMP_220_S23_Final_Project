import java.util.ArrayList;

/**
 * Represents a Piece that can move both forwards and backwards
 */
public class King extends Piece {

    /**
     * Constructs either a red King or a black King
     * @param color
     */
    public King(char color) {
        super(color);
    }

    /**
     * Recognizes the ability of Kings to move backwards
     * @return An ArrayList of Moves that may include King-only Moves
     */
    @Override
    public ArrayList<Move> validMove() {
        return new ArrayList<Move>();
    }

    /**
     * Recognizes the ability of Kings to jump backwards
     * @return An ArrayList of Moves that may include King-only Moves
     */
    @Override
    public ArrayList<Move> validJumps() {
        return new ArrayList<Move>();
    }
}
