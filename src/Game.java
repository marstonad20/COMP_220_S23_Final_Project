import java.util.*;

/**
 * Handles gameplay logic of a game of Checkers
 */
public class Game {

    private Deque<Board> boards = new LinkedList<Board>();
    private Board currBoard = new Board();
    private int turnCt = 0;

    /**
     * Handles passing the turn between the two players and determining whether the moves the player
     * wants to make are valid.
     */
    public void gameLoop() {

    }

    /**
     * Asks a player for a board location, parses their input,
     * and returns an int array representing a board location (x,y)
     * Rows and columns are numbered starting at 0
     */
    public int[] getPlayerInput(Scanner in) {
        int[] ints = new int[2];
        // this text formatting is very WIP:
        boolean valid = false;
        while (!valid) {
            System.out.println("Please input 'row,col'");
            String playerInput = in.next();
            if (Character.isDigit(playerInput.charAt(0)) && (Character.isDigit(playerInput.charAt(2)))
                    && playerInput.charAt(1) == ',' && playerInput.length() == 3) {
                valid = true;
                int row = (int) playerInput.charAt(0);
                int col = (int) playerInput.charAt(2);
                //TODO: To make the getPlayerInput return expected values I had to subtract 48, later found out that ASCII value for 0 is 48,
                // and this clears things up to some degree... Since we know the problem I am leaving in the somewhat strange fix of
                // subtracting 48 since the problem shouldn't show up anywhere else, "final" solution would be to make sure that row and col
                // are read as ints and not as ascii characters that are cast to integer values
                ints[0] = row-48;
                ints[1] = col-48;
            } else {
                System.out.println("Invalid input.");
            }
        }
        return ints;
    }

    /**
     * Determines if a selected piece by the player is valid to move or have jump
     */
    public boolean validPieceToMove(int[] location) {
        // if selected piece to move matches player whose turn it is
        if ((Board.getValue(location) == 'b' || Board.getValue(location) == 'B') && turnCt%2 == 0) {
            return true;
        }

        if ((Board.getValue(location) == 'r' || Board.getValue(location) == 'R') && turnCt%2 == 1) {
            return true;
        }

        return false;
    }


    /**
     * Determines if a selected ending location for a checker is empty, whether it is a jump or a move
     */
    public boolean validTargetLocation(int[] location) {
        // if destination location is full, invalid move
        if (Board.getValue(location) == ' ') {
            return true;
        }
        // TODO: if destination is not within 2 spaces (in any direction) of starting piece, invalid move

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
