import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTester {

    public static void main(String[] args) throws Exception {

        Board boardConstructor = new Board();
        System.out.println("boardConstructor printout: ");
        boardConstructor.printBoard();

        Game testGame = new Game();
        int[] startLoc = {2,2};
        int [] endLoc = {4,4};
        System.out.println(testGame.validJump(startLoc, endLoc));

//        Board testBoard = new Board();
//        System.out.println("testBoard [0,5] value: '" + Board.getValue(new int[] {0, 5}) + "'");                // should be ' ' (space)
//        System.out.println(testBoard.getValue(new int[] {0, 5}));
//        System.out.println("testBoard [5,0] value: '" + Board.getValue(new int[] {5, 0}) + "'");                // should be 'r'
//        System.out.println(testBoard.getValue(new int[] {5, 0}));

//        testBoard.setValue(new int[] {4,1}, 'r');
//        System.out.println("testBoard with [4,1] set to r");
//        testBoard.printBoard();

//        Scanner in = new Scanner(System.in); // tests Game's getPlayerInput()
//        Game testGame = new Game();
//        System.out.println(Arrays.toString(testGame.getPlayerInput(in)));

//        System.out.println("getValue of user entered location in testGame: ");
//        System.out.println(Board.getValue(testGame.getPlayerInput(in)));
    }

//    @Test public void getValue() {
//        final char black = 'b';
//        final char red = 'r';
//        final char blank = ' ';
//
//        char item = 'b';
//        char result = 'b';
//        assertEquals(item, result);
//    }

}
