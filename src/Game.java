import java.util.ArrayList;
import java.util.Stack;

/**
 * Handles gameplay logic of a game of Checkers
 */
public class Game {

    private Stack<Board> boards = new Stack<Board>();
    private Board currBoard = new Board();

    /**
     * Handles passing the turn between the two players
     */
    public void gameLoop() {

    }

    /**
     *Checks all pieces of a color on the board to determine which can
     * jump, and, if any can, to require the player to make one of those jumps
     * Is called at start of turn and after every jump
     * @param color
     * @return
     */
    public ArrayList<Move> checkForJumps(char color) {
        return new ArrayList<Move>();
    }

    /**
     * Checks all pieces of a color on the board to determine which can
     * move and to where, and if none can move, the other player wins.
     * Is called at start of turn after checkForJumps()
     * @param color
     * @return
     */
    public ArrayList<Move> checkForMoves(char color) {
        return new ArrayList<Move>();
    }

    /**
     * Gets the next most recent Board and makes it the current Board,
     * thus undoing a move
     */
    public void undo() {

    }
}
