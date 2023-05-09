import java.util.Arrays;

/**
 * Holds the starting location and the ending location of a checkers move or jump
 */
public class Move {
    private int[] start;
    private int[] end;

    /**
     * Constructor
     * @param start starting location of the move or jump
     * @param end ending location of the move or jump
     */
    public Move(int[] start, int[] end) {
        this.start = start;
        this.end = end;
    }
    public int[] getStart() {
        return start;
    }
    public void setStart(int row, int col) {
        start = new int[] {row, col};
    }
    public int[] getEnd() {
        return this.end;
    }
    public void setEnd(int row, int col) {
        end = new int[] {row, col};
    }

    /**
     * Returns a text representation of the move.
     * @return A String to print that represents the move with text.
     */
    @Override
    public String toString() {
        return "(" + start[0] + ", " + start[1] + ") to (" + end[0] + ", " + end[1] + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return Arrays.equals(start, move.start) && Arrays.equals(end, move.end);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(start);
        result = 31 * result + Arrays.hashCode(end);
        return result;
    }
}
