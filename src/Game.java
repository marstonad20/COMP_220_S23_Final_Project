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
     * Checks if a selected move by the player is valid
     * @param startLoc The location (row,col) of the piece currently
     * @param endLoc The location (row,col) that the player wants to move the piece to
     * @return whether this move is valid
     */
    public boolean validMove(int[] startLoc, int[] endLoc) {
        int x1 = startLoc[0];
        int y1 = startLoc[1];
        int x2 = endLoc[0];
        int y2 = endLoc[1];
        char pieceType = Board.getValue(startLoc);

        if (!(Board.getValue(endLoc) == ' ')) { // target location has to be empty
            return false;
        }

        if (x2 > 7 || y2 > 7) { // target location has to be on the board
            return false;
        }

        if (pieceType == 'b') {
            // handle black pawn valid moves
            // y has to increment by 1, and x can either increment or decrement by 1
            if ((y2 - y1 == 1 && (x2 - x1 == 1 || x2 - x1 == -1))) {
                return true;
            } else {
                return false; // invalid move
            }
        }
        else if (pieceType == 'r') {
            // handle red pawn valid moves
            // y has to decrement by 1, and x can either increment or decrement by 1
            if ((y2 - y1 == -1 && (x2 - x1 == 1 || x2 - x1 == -1))) {
                return true;
            } else {
                return false; // invalid move
            }
        }
        else if (Character.isUpperCase(pieceType)) {
            // handle red king valid moves
            // handle black king valid moves
            // y can either increment or decrement by 1, and so can x
            if (((y2 - y1 == 1 || y2 - y1 == -1) && (x2 - x1 == 1 || x2 - x1 == -1))) {
                return true;
            } else {
                return false; // invalid move
            }
        }
        else {
            return false; // invalid piece type
        }
    }

    //TODO: this will allow the a piece to jump in an arbitrary direction, not necessarily a direction that has
    //TODO: a jumpable piece
    /**
     * Checks if a selected jump by the player is valid
     * @param startLoc The location (row,col) of the piece currently
     * @param endLoc The location (row,col) that the player wants to jump the piece to
     * @return whether this jump is valid
     */
    public boolean validJump(int[] startLoc, int[] endLoc) {
        int x1 = startLoc[0];
        int y1 = startLoc[1];
        int x2 = endLoc[0];
        int y2 = endLoc[1];
        char pieceType = Board.getValue(startLoc);

        if (!(Board.getValue(endLoc) == ' ')) { // target location has to be empty
            return false;
        }

        if (x2 > 7 || y2 > 7) { // target location has to be on the board
            return false;
        }

        if (pieceType == 'b') {
            // handle black pawn valid jumps
            // y has to increment by 2, and x can either increment or decrement by 2
            if ((y2 - y1 == 2 && (x2 - x1 == 2 || x2 - x1 == -2))) {
                return true;
            } else {
                return false; // invalid move
            }
        }
        else if (pieceType == 'r') {
            // handle red pawn valid jumps
            // y has to decrement by 2, and x can either increment or decrement by 2
            if ((y2 - y1 == -2 && (x2 - x1 == 2 || x2 - x1 == -2))) {
                return true;
            } else {
                return false; // invalid jump
            }
        }
        else if (Character.isUpperCase(pieceType)) {
            // handle red king valid jumps
            // handle black king valid jumps
            // y can either increment or decrement by 2, and so can x
            if (((y2 - y1 == 2 || y2 - y1 == -2) && (x2 - x1 == 2 || x2 - x1 == -2))) {
                return true;
            } else {
                return false; // invalid jump
            }
        }
        else {
            return false; // invalid piece type
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
