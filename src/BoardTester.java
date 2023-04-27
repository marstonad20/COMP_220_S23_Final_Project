import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTester {

    public static void main(String[] args) throws Exception {

        Board testBoard = new Board();
        testBoard.printBoard();

        System.out.println(testBoard.getValue(new int[] {0, 5}));

        testBoard.setValue(new int[] {4,1}, 'r');
        testBoard.printBoard();
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
