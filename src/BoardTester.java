import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    public void validJumpTest1() { // black jump
        Board.setValue(new int[] {3,2}, 'r'); // temporarily setting this spot to a jumpable piece
        int[] startLoc = {2,1};
        int[] endLoc = {4,3};
        assertTrue(Game.validJump(startLoc,endLoc));
        Board.setValue(new int[] {3,2}, ' '); // resetting this spot to empty
    }

    @Test
    public void validJumpTest2() { // red jump
        Board.setValue(new int[] {4,5}, 'b'); // temporarily setting this spot to a jumpable piece
        int[] startLoc = {5,4};
        int[] endLoc = {3,6};
        assertTrue(Game.validJump(startLoc,endLoc));
        Board.setValue(new int[] {4,5}, ' '); // resetting this spot to empty
    }

    @Test
    public void invalidJumpTest() {
        int[] startLoc = {2,1};
        int[] endLoc = {3,2};
        assertFalse(Game.validJump(startLoc,endLoc));
    }

    @Test
    public void moveTest1() { // testing moving a black pawn
        int[] startLoc = {1,6};
        int[] endLoc = {2,5};
        Board.move(startLoc,endLoc);
        testBoard.printBoard();
        assertTrue(Board.getValue(startLoc) == ' ' && Board.getValue(endLoc) == 'b');
    }

    @Test
    public void moveTest2() { // testing moving a red pawn
        int[] startLoc = {5,0};
        int[] endLoc = {4,1};
        Board.move(startLoc,endLoc);
        testBoard.printBoard();
        assertTrue(Board.getValue(startLoc) == ' ' && Board.getValue(endLoc) == 'r');
    }
    @Test
    public void jumpTest1() { // testing jumping black pawn over red pawn
        int[] startMove1 = {2,1};
        int[] endMove1 = {3,2};
        int[] startMove2 = {5,2};
        int[] endMove2 = {4,3};
        int[] startMove3 = {2,5};
        int[] endMove3 = {3,6};
        Board.move(startMove1, endMove1);
        Board.move(startMove2, endMove2);
        Board.move(startMove3, endMove3);
        testBoard.printBoard();

        int[] startLoc = {4,3};
        int[] endLoc = {2,1};
        int [] jumpLoc = {3,2};
        Board.jump(startLoc, endLoc);
        testBoard.printBoard();
        assertTrue(Board.getValue(endLoc) == 'r' && Board.getValue(startLoc) == ' ' && Board.getValue(jumpLoc) == ' ');
    }

    @Test
    public void jumpTest2() { // testing jumping red pawn over black pawn testing second jump in a row
        int[] startMove1 = {2,1};
        int[] endMove1 = {3,2};
        int[] startMove2 = {5,2};
        int[] endMove2 = {4,3};
        int[] startMove3 = {2,5};
        int[] endMove3 = {3,6};
        int[] startJump1 = {4,3};
        int[] endJump1 = {2,1};

        Board.move(startMove1, endMove1);
        Board.move(startMove2, endMove2);
        Board.move(startMove3, endMove3);
        Board.jump(startJump1, endJump1);
        testBoard.printBoard();

        int[] startLoc = {1,2};
        int[] endLoc = {3,0};
        int [] jumpLoc = {2,1};
        Board.jump(startLoc, endLoc);
        testBoard.printBoard();
        assertTrue(Board.getValue(endLoc) == 'b' && Board.getValue(startLoc) == ' ' && Board.getValue(jumpLoc) == ' ');
    }

    @Test
    public void invalidPromotion() {  // tests promoting red pawn to King when not at correct side of board
//        testBoard.printBoard();
        int[] invalidPromote = {7,0};
        testGame.promote(invalidPromote, 'r');
        testBoard.printBoard();
        assertTrue(Board.getValue(invalidPromote) == 'r');
    }

    @Test
    public void validPromotion() {  // tests promoting black pawn to King when at correct location
        int[] validPromo = {7,4};

        Board.setValue(validPromo, 'b');
        testGame.promote(validPromo, Board.getValue(validPromo));
        testBoard.printBoard();

        assertEquals('B', Board.getValue(validPromo));
    }

    @Test
    public void copyTest() {
        Board copiedBoard = new Board(testBoard);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                assertEquals(copiedBoard.getValue(new int[] {i,j}), testBoard.getValue(new int[] {i,j}));
            }
        }
    }
}
