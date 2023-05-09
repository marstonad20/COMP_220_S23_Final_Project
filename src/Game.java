import java.util.*;

/**
 * Handles gameplay logic of a game of Checkers
 */
public class Game {

    private Deque<Board> boards;
    public Board currBoard;
    private int turnCt;
    private Scanner in;

    public Game() {
        currBoard = new Board();
        boards = new LinkedList<Board>();
        turnCt = 0;
        in = new Scanner(System.in);
    }

    /**
     * Handles passing the turn between the two players and determining whether the moves the player
     * wants to make are valid.
     */
    public void gameLoop() {
        boards.addLast(currBoard); // always adds initial board to stack

        // start of game loop
        while (!currBoard.winState()) { // if red has not won the game, keep playing

            // start of turn loop
            System.out.println("Black's turn.");
            currBoard.printBoard();
            boolean validInput = false;
            while (!validInput) {
                // what checker does the player want to move?
                System.out.println("Input location of checker you'd like to move.");
                int[] start = getPlayerInput(in);
                if (Character.toLowerCase(currBoard.getValue(start)) != 'b') {
                    System.out.println("Invalid location or piece.");
                    continue; // back to the start of the turn
                }
                HashSet<Move> validMoves;
                validMoves = findMoves(start, currBoard);
                HashSet<Move> validJumps;
                validJumps = findJumps(start);
                if (!validMoves.isEmpty()) {
                    System.out.println("Here are the valid moves for that piece: ");
                    for (Move m : validMoves) {
                        System.out.println(m.toString());
                    }
                }
                if (!validJumps.isEmpty()) {
                    System.out.println("Here are the valid jumps for that piece: ");
                    for (Move j : validJumps) {
                        System.out.println(j.toString());
                    }
                }
                if (validMoves.isEmpty() && validJumps.isEmpty()) {
                    System.out.println("That piece has no valid moves or jumps.");
                    continue; // back to the start of the turn
                }
                System.out.println("Please input the ending location of the move or jump you like to make: ");
                int[] end = getPlayerInput(in);
                int[] ender = end;
                Move playerMove = new Move(start, end);
                if (validMoves.contains(playerMove)) { // execute move
                    currBoard.move(start,end);
                    promote(end,'b', currBoard);
                    boards.addLast(currBoard);
                    currBoard.printBoard();
                    System.out.println("Do you want to undo this move? (Y or y for yes, anything else for no)");
                    String undoAns = in.next();
                    if (undoAns.equals("Y") || undoAns.equals("y")) {
                        System.out.println("Undo loop entered");
                        boards.removeLast(); // remove this last change from the board stack
                        // if cannot be entered as we do not prompt for undo at the beginning of the game
                        if (boards.getLast() == null) {
                            boards.addLast(new Board()); // if stack of boards is empty, add a fresh board
                        }
                        currBoard = boards.getLast(); //TODO it will just not reassign!!
                        boards.getLast().printBoard();
                        continue; // return to beginning of turn
                    }
                    turnCt++;
                    validInput = true;
                } else if (validJumps.contains(playerMove)) { // execute jump
                    currBoard.jump(start,end);
                    promote(end,'b', currBoard);
                    boards.addLast(currBoard);
                    currBoard.printBoard();
                    System.out.println("Do you want to undo this jump? (Y or y for yes, anything else for no)");
                    String undoAns = in.next();
                    if (undoAns.equals("Y") || undoAns.equals("y")) {
                        boards.removeLast(); // remove this last change from the board stack
                        if (boards.getLast() == null) {
                            boards.addLast(new Board()); // if stack of boards is empty, add a fresh board
                        }
                        currBoard = boards.getLast();
                        currBoard.printBoard();
                        continue; // return to beginning of turn
                    } else if (findJumps(end).size() != 0) {
                        // TODO: red needs entire chain jump code added to it
                        // check if there are more valid jumps from previous jump's ending location for color whose turn it is
                        while (!findJumps(ender).isEmpty()) {     // need to make sure I did not soft lock player with invalid move in chained jump
                            System.out.println("Another jump is available, would you like to jump again? (Y for yes, anything else for no)");
                            String jumpAgain = in.nextLine();
                            if (jumpAgain.equals("Y")) {
                                playerMove.setStart(end[0], end[1]);
                                System.out.println("Here are the valid jumps for that piece: ");
                                start = ender;
                                for (Move j : validJumps) {
                                    System.out.println(j.toString());
                                }
                                System.out.println("Please input the next ending location of the jump you would like to make: ");
                                end = getPlayerInput(in);
                                currBoard.jump(ender, end);
                                promote(end, 'b', currBoard);
                                boards.add(currBoard);
                                // TODO: needs updated undo prompt and actions
                                System.out.println("Do you want to undo this jump? (Y or y for yes, anything else for no)");
                                undoAns = in.nextLine();
                                if (undoAns.equals("Y") || undoAns.equals("y")) {
                                    boards.pop(); // remove last change from the board stack
                                }
                            }
                        }
                    }
                    turnCt++;
                    validInput = true;
                }
                else {
                    System.out.println("Invalid input."); // back to the start of the turn
                }
            }
            if (currBoard.winState()) {
                System.out.println("Black wins!");
                break; // black has won the game, cease playing
            }

            // this is almost exactly the same as black's turn except for how a winState is checked for
            System.out.println("Red's turn.");
            currBoard.printBoard();
            validInput = false;
            while (!validInput) {
                // getting user input
                System.out.println("Input location of checker you'd like to move.");
                int[] start = getPlayerInput(in);
                if (Character.toLowerCase(currBoard.getValue(start)) != 'r') {
                    System.out.println("Invalid location or piece.");
                    continue;
                }
                HashSet<Move> validMoves;
                validMoves = findMoves(start, currBoard);
                HashSet<Move> validJumps;
                validJumps = findJumps(start);
                if (!validMoves.isEmpty()) {
                    System.out.println("Here are the valid moves for that piece: ");
                    for (Move m : validMoves) {
                        System.out.println(m.toString());
                    }
                }
                if (!validJumps.isEmpty()) {
                    System.out.println("Here are the valid jumps for that piece: ");
                    for (Move j : validJumps) {
                        System.out.println(j.toString());
                    }
                }
                if (validMoves.isEmpty() && validJumps.isEmpty()) {
                    System.out.println("That piece has no valid moves or jumps.");
                    continue;
                }
                System.out.print("Please input the ending location of the move or jump you like to make:");
                int[] end = getPlayerInput(in);
                Move playerMove = new Move(start, end);
                if (validMoves.contains(playerMove)) { // execute move
                    currBoard.move(start,end);
                    promote(end,'r', currBoard);
                    boards.addLast(currBoard);
                    currBoard.printBoard();
                    System.out.println("Do you want to undo this move? (Y or y for yes, anything else for no)");
                    String undoAns = in.next();
                    if (undoAns.equals("Y") || undoAns.equals("y")) {
                        boards.removeLast(); // remove this last change from the board stack
                        if (boards.getLast() == null) {
                            boards.addLast(new Board()); // if stack of boards is empty, add a fresh board
                        }
                        currBoard = boards.getLast();
                        currBoard.printBoard();
                        continue; // return to beginning of turn
                    }
                    turnCt++;
                    currBoard.printBoard();
                    validInput = true;
                } else if (validJumps.contains(playerMove)) {
                    currBoard.jump(start,end);
                    promote(end,'r', currBoard);
                    boards.addLast(currBoard);
                    currBoard.printBoard();
                    System.out.println("Do you want to undo this jump? (Y or y for yes, anything else for no)");
                    String undoAns = in.next();
                    if (undoAns.equals("Y") || undoAns.equals("y")) {
                        boards.removeLast(); // remove this last change from the board stack
                        if (boards.getLast() == null) {
                            boards.addLast(new Board()); // if stack of boards is empty, add a fresh board
                        }
                        currBoard = boards.getLast();
                        currBoard.printBoard();
                        continue; // return to beginning of turn
                    }
                    turnCt++;
                    currBoard.printBoard();
                    validInput = true;
                }
                else {
                    System.out.println("Invalid input.");
                }
            }
        } // end of game loop
        System.out.println("Red wins!");
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
     * Commented out because unused
     */
    /*
    public static boolean validPieceToMove(int[] location) {
        // if selected piece to move matches player whose turn it is
        if ((Board.getValue(location) == 'b' || Board.getValue(location) == 'B') && turnCt%2 == 0) {
            return true;
        }

        if ((Board.getValue(location) == 'r' || Board.getValue(location) == 'R') && turnCt%2 == 1) {
            return true;
        }

        else {
            return false;
        }
    }
     */

    /**
     * Checks if a selected move by the player is valid
     * @param startLoc The location (row,col) of the piece currently
     * @param endLoc The location (row,col) that the player wants to move the piece to
     * @return whether this move is valid
     */
    public static boolean validMove(int[] startLoc, int[] endLoc, Board currBoard) {
        int x1 = startLoc[1];
        int y1 = startLoc[0];
        int x2 = endLoc[1];
        int y2 = endLoc[0];

        if ((x2 > 7 || y2 > 7) || (x2 < 0 || y2 < 0)) { // target location has to be on the board
            return false;
        }

        char pieceType = currBoard.getValue(startLoc);

        if (!(currBoard.getValue(endLoc) == ' ')) { // target location has to be empty
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

    /**
     * Checks if a selected jump by the player is valid
     * @param startLoc The location (row,col) of the piece currently
     * @param endLoc The location (row,col) that the player wants to jump the piece to
     * @return whether this jump is valid
     */
    public static boolean validJump(int[] startLoc, int[] endLoc, Board currBoard) {
        int x1 = startLoc[1];
        int y1 = startLoc[0];
        int x2 = endLoc[1];
        int y2 = endLoc[0];

        if ((x2 > 7 || y2 > 7) || (x2 < 0 || y2 < 0)) { // target location has to be on the board
            return false;
        }

        if ((Math.max(y1,y2) - 1) < 0 || (Math.max(x1,x2) - 1) < 0 ) {
            return false; // the jumped piece is off the board
        }

        char pieceType = currBoard.getValue(startLoc); // the type of the jumping piece
        char jumpedPiece = currBoard.getValue(new int[] {(Math.max(y1,y2) - 1), (Math.max(x1,x2) - 1)}); // the type of
                                                                                                     // the jumped piece
        // (credit to BROWNNJ20 for in-between piece checking logic)

        if (jumpedPiece == ' ') {
            return false;           // cannot jump over empty square
        }
        if (Character.toLowerCase(pieceType) == Character.toLowerCase(jumpedPiece)) {
            return false;           // cannot jump over own piece
        }

        if (!(currBoard.getValue(endLoc) == ' ')) { // target location has to be empty
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
    public void promote(int[] pieceLocation, char player, Board currBoard) {
        if (player == 'b' && pieceLocation[0] == 7) {       // if black pawn reaches side other than starting side
            currBoard.setValue(pieceLocation, 'B');
        } else if (player == 'r' && pieceLocation[0] == 0) {
            currBoard.setValue(pieceLocation, 'R');
        }
    }

    /**
     * Creates a set of Move objects and checks every adjacent space for valid move ending locations.
     * Returns all possible moves.
     * @param start The location of the piece that the player wants to move
     * @return a set of locations to which the piece can move. This can be empty.
     */
    public HashSet<Move> findMoves(int[] start, Board currBoard) {
        HashSet<Move> validMoves = new HashSet<Move>();
        for (int i = start[0] - 1; i < start[0] + 2; i++) { // rows
            for (int j = start[1] - 1; j < start[1] + 2; j++) { // cols
                boolean valid = validMove(start, new int[] {i,j}, currBoard);
                if (valid) {
                    validMoves.add(new Move(start, new int[] {i,j}));
                }
            }
        }
    return validMoves;
    }

    /**
     * Creates a set of Move objects and checks every space that is two squares away from the starting location for
     * valid jumps. Returns all possible jumps.
     * @param start The location of the piece that the player wants to move
     * @return a set of locations to which the piece can jump. This can be empty.
     */
    public HashSet<Move> findJumps(int[] start) {
        HashSet<Move> validJumps = new HashSet<Move>();
        for (int i = start[0] - 2; i < start[0] + 3; i++) {
            for (int j = start[1] - 2; j < start[1] + 3; j++) {
                boolean valid = validJump(start, new int[] {i,j}, currBoard);
                if (valid) {
                    validJumps.add(new Move(start, new int[] {i,j}));
                }
            }
        }
        return validJumps;
    }
}
