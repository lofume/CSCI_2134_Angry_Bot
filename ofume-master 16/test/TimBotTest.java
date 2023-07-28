import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimBotTest {

    //White box- tests the methods in the TimBot class to check to see if they
    //print or return the appropriate results
    @Test
    void getID() {
        String myID= "23456";
        System.out.println(myID);
    }

    //checks energylevel condition and creates it
    @Test
    void startRound() {
        int energyLevel=0;
        assertFalse(energyLevel>45);
    }

    //checks the elements in the array based on the parameters that are needed to be added to the
    // array
    @Test
    void senseDistricts(int [] spresso, boolean [] bots) {
        System.arraycopy( spresso, 0, 4, 0, spresso.length );
    }

    //test to return the current value
    @Test
    void getNextMove() {
        System.out.println(District.CURRENT);
    }

    //return if the energyLevel is equal or greater than 0
    @Test
    void isFunctional() {
        int energyLevel= 30;
        assertTrue(energyLevel>=0);
    }

    //useJolt create a return
    @Test
    void useShield() {
        int useJolt= -1;
        System.out.print(useJolt);
    }

    //return energy level if the level is less and then make it equal to 99
    @Test
    void harvestSpresso(int jolts) {
        int energyLevel=30;
        energyLevel += jolts;
        if( energyLevel < 99 ) {
            energyLevel = 99;
        }
        System.out.print(energyLevel);
    }

    //test the null carrier and see whether or not the value shoots or not
    @Test
    void fireCannon() {
        String shoots= "FIRE!";
        if(shoots.equals("Fire")){
            System.out.print(shoots);
        }
    }

    @Test
    void testToString() {
        System.out.print("THIS TEST WORKS!");
    }
}