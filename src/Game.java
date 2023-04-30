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
        boolean valid = false;
        while (!valid) {
            System.out.println("Please input 'row,col'");
            String playerInput = in.next();
            if (playerInput.length() == 3
                    && Character.isDigit(playerInput.charAt(0))
                    && (Character.isDigit(playerInput.charAt(2)))
                    && playerInput.charAt(1) == ',') {
                valid = true;
                // this implementation reads the chars as ints directly
                int row = Character.getNumericValue(playerInput.charAt(0));
                int col = Character.getNumericValue(playerInput.charAt(2));
                ints[0] = row;
                ints[1] = col;
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
     * Makes sure the ending location of a move or jump is empty, on the board, and either a valid move or jump
     */
    public boolean validTargetLocation(int[] startLocation, int[] endLocation) {
        if (Board.getValue(endLocation) == ' ') { // only empty destinations are valid

            int x1 = startLocation[0];
            int y1 = startLocation[1];
            int x2 = endLocation[0];
            int y2 = endLocation[1];
            char pieceType = Board.getValue(startLocation);

            // checks that the destination is actually on the board
            if (x2 > 7 || y2 > 7) {
                return false; // the destination is off the board
            }

            if (pieceType == 'b') {
                // handle black pawn valid moves
                // y has to increment by 1, and x can either increment or decrement by 1
                // or y has to increment by 2, and x can either increment or decrement by 2
                if ((y2 - y1 == 1 && (x2 - x1 == 1 || x2 - x1 == -1)) || // moves
                        (y2 - y1 == 2 && (x2 - x1 == 2 || x2 - x1 == -1))) { // jumps
                    return true;
                } else {
                    return false; // invalid move or jump
                }
            }
            else if (pieceType == 'r') {
                // handle red pawn valid moves
                // y has to decrement by 1, and x can either increment or decrement by 1
                // or y has to decrement by 2, and x can either increment or decrement by 2
                if ((y2 - y1 == -1 && (x2 - x1 == 1 || x2 - x1 == -1)) || // moves
                        (y2 - y1 == -2 && (x2 - x1 == 2 || x2 - x1 == -1))) { // jumps
                    return true;
                } else {
                    return false; // invalid move or jump
                }
            }
            else if (Character.isUpperCase(pieceType)) {
                // handle red king valid moves
                // handle black king valid moves
                // y can either increment or decrement by 1, and so can x
                // or y can either increment or decrement by 2, and so can x
                if (((y2 - y1 == 1 || y2 - y1 == -1) && (x2 - x1 == 1 || x2 - x1 == -1)) || // moves
                        (y2 - y1 == 2 || y2 - y1 == -2) && (x2 - x1 == 2 || x2 - x1 == -2)) { // jumps
                    return true;
                } else {
                    return false; // invalid move or jump
                }
            }
            else {
                return false; // invalid piece type
            }
        }
        else {
            return false; // the destination is full
        }
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
