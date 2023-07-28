import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpressoBotTest {

    //Grey box tests the values and the if statements to check whether the values in the getNextMove()
    //accurately print and display their given values
    @Test
    void getNextMove() {
        //sets values for the if statement in the SpressoBot class
        //checks if the the move value is equal to move and then deceases the energy level
        int [] scores = new int[30];
        int adj= 0;
        int energyLevel=30;
        int move= District.CURRENT;
        if( move == District.CURRENT ) {
            energyLevel--;
        }
        //prints decreased energy level
        System.out.println(energyLevel);
        //checks if the scores array is null
        assertTrue(scores==null);
    }


}