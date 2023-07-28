import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AngryBotTest {


    //Black-box testing: tests the functionality and whether or not the values display the correct values
    // indicated by the developer
    @Test
    void getNextMove() {
        //testing the creation of a new array
        int[] goal = new int[10];
        //initializing the current value
        int push = District.CURRENT;
        //boolean tests
        assertTrue(push < 2);
        assertFalse(District.NORTH == 0);
        //print statement
        System.out.println("Test method");
        //if the value
        //equals method
        assertNotEquals(0,3);
        //tests the current method and the cursor reading the CURRENT function
        int min = goal[District.CURRENT] + 1;
        for (int i = 0; i < goal.length; i++) {
            if (min > goal[i]) {
                min = goal[i];
                push = i;
            }
        }
        //testing the values to see if they are accurate to the ones indicated in the class
        System.out.println(push);
        System.out.println(District.EAST);
    }

}