import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChickenBotTest {

    //grey box testing for the usability of methods in the ChickenBot
    @Test
    void getNextMove() {

        int [] scores = new int[30];
        int adj= 0;
        int move= District.CURRENT;
        //boolean tests
        assertTrue(move==0);
        assertFalse(scores.length==adj);
        int min = scores[District.CURRENT] + 1;
        //tests the output of the scores array
        for( int i = 0; i < scores.length; i++ ) {
            if( min > scores[i] ) {
                min = scores[i];
                move = i;
            }
            System.out.println(move);
        }
        System.out.println(scores[move]);
    }
}