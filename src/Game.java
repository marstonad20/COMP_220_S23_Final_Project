import java.util.*;

/**
 * Handles gameplay logic of a game of Checkers
 */
public class Game {

    private Deque<Board> boards = new LinkedList<Board>();
    private Board currBoard = new Board();

    /**
     * Handles passing the turn between the two players
     */
    public void gameLoop() {

    }

    /**
     * Asks a player for a board location, parses their input,
     * and returns an int array representing a board location (x,y)
     */
    public int[] getPlayerInput(Scanner in) {
        int[] ints = new int[2];
        return ints;
    }

    /**
     * Determines if a selected piece by the player is valid to move or have jump
     */
    public boolean validPieceToMove(int[] location) {
        return false;
    }


    /**
     * Determines if a selected ending location for a checker is empty, whether it is a jump or a move
     */
    public boolean validTargetLocation(int[] location) {
        return false;
    }

    /**
     * Checks if a piece is valid for promotion, and then promotes it if so
     */
    public void promote(int[] pieceLocation, char player) {

    }


    /**
     * Gets the next most recent Board and makes it the current Board,
     * thus undoing a move
     */
    public void undo() {

    }
}
