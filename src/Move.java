/**
 * Essentially a container for a starting location/ending location pair
 */
public class Move {

    private Square startSq;
    private Square endSq;

    /**
     * Constructs a move with a starting Square and an ending Square
     * @param startSq The square from which the Piece is moving
     * @param endSq The square the Piece is moving to
     */
    public Move(Square startSq, Square endSq) {
        this.startSq = startSq;
        this.endSq = endSq;
    }
}
