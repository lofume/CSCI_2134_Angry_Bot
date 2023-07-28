import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BullyBotTest {

    //White-box testing for the functionality of the if and for statements
    @Test
    void fireCannon() {
        //return array list that is null
        int count= 0;
        int energyLevel = 30;
        int [] fire= null;
        //checks for addition values and sees if it works properly
        if( count > ( energyLevel - 2 ) ) {
            count = energyLevel - 2;
            System.out.println(count);
        }
        //test that fire == null stands
        assertTrue(fire!=null);


    }






}