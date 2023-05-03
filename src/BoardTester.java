import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTester {
    static Game testGame = new Game();
    static Board testBoard = new Board();
    static Scanner in = new Scanner(System.in);

    @BeforeAll
    public static void setup() {
        testBoard.printBoard();
    }

    @Test
    public void validMoveTest() {
        int[] startLoc = {2,1};
        int[] endLoc = {3,2};
        assertTrue(Game.validMove(startLoc,endLoc));
    }

    @Test
    public void invalidMoveTest() {
        int[] startLoc = {2,1};
        int[] endLoc = {3,1};
        assertFalse(Game.validMove(startLoc, endLoc));
    }

    @Test
    public void offTheBoardMove() {
        int[] startLoc = {2,1};
        int[] endLoc = {-1,-1};
        assertFalse(Game.validMove(startLoc, endLoc));
    }

    @Test
    public void validJumpTest() { //some clarification: this test does not check if a piece is in between the start
                                  // and end locations. It merely checks that this is a valid 2-space move.
        int[] startLoc = {2,1};
        int[] endLoc = {4,3};
        assertTrue(Game.validJump(startLoc,endLoc));
    }

    @Test
    public void invalidJumpTest() {
        int[] startLoc = {2,1};
        int[] endLoc = {3,2};
        assertFalse(Game.validJump(startLoc,endLoc));
    }

}
