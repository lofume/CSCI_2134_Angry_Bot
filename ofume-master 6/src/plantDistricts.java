/**
 File: plantDistricts.java
 Author: Lynda Ofume, Alex Brodsky
 Date: April 6, 2020
 Purpose: CSCI 2134, Assignment 4

 Description: This class should extend Timbot.java so that there is a mix of plant inputs for harvesting plants
    in different districts
 */

public class plantDistricts extends TimBot {

    //This class should extend the other classes so that there are more inputs for harvesting plants
    protected char personality = 'P';

    /**
     * This is the only constructor for this class.  This constructor
     * initializes the Tibot and sets its ID and the initial amount of
     * energy that it has.  The ID is between 0 and 99.
     * <p>
     * parameter: id    : ID of the TimBotA
     * jolts : Initial amount of energy
     *
     * @param id
     * @param jolts
     */
    public plantDistricts(int id, int jolts) {
        super(id, jolts);
    }
}
