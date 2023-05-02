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
        System.out.println();

        Board testBoard = new Board();
//        System.out.println("testBoard [0,5] value: '" + Board.getValue(new int[] {0, 5}) + "'");                // should be ' ' (space)
//        System.out.println(testBoard.getValue(new int[] {0, 5}));
//        System.out.println("testBoard [5,0] value: '" + Board.getValue(new int[] {5, 0}) + "'");                // should be 'r'
//        System.out.println(testBoard.getValue(new int[] {5, 0}));

//        testBoard.setValue(new int[] {4,1}, 'r');
//        System.out.println("testBoard with [4,1] set to r");
//        testBoard.printBoard();

        Scanner in = new Scanner(System.in); // tests Game's getPlayerInput()
//        Game testGame = new Game();
//        System.out.println(Arrays.toString(testGame.getPlayerInput(in)));

        System.out.println("move with hardcoded location: ");
        System.out.println("is valid hardcoded starting loc? " + Game.validPieceToMove(new int[] {2,0}));
        System.out.println("is valid hardcoded move? " + Game.validMove(new int[] {2,1}, new int[] {3,2}));
        Board.move(new int[] {2,1}, new int[] {3,2});
        testBoard.printBoard();

        Board.move(new int[] {5,6}, new int[] {4,7});
        Board.move(new int[] {3,2}, new int[] {4,3});
        System.out.println("Board after 2 hardcoded moves");
        testBoard.printBoard();
        System.out.println("jump with hardcoded location: (5,4 -> 3,2) ");
        Board.jump(new int[] {5,4}, new int[] {3,2});
        testBoard.printBoard();
//        System.out.println("is valid hardcoded starting loc? " + Game.validPieceToMove(new int[] {5,4}));
//        System.out.println("is valid hardoced jump? " + Game.validMove)
        System.out.println("move with user input locations? (4,7 -> 3,6) can we break it? ");    // spoiler alert, breaking it the first time wasn't very hard...
        System.out.println("is valid user entered move? " + Game.validMove(new int[] {4,7}, new int[] {3,6}));
        Board.move(testGame.getPlayerInput(in),testGame.getPlayerInput(in));
        testBoard.printBoard();

        System.out.println("jump with user input locations? (2,3 -> 4,1) can we break this one? ");
        System.out.println("is valid user entered jump? " + Game.validJump(new int[] {2,3}, new int[] {4,1}));

        Board.jump(testGame.getPlayerInput(in), testGame.getPlayerInput(in));
        testBoard.printBoard();

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
