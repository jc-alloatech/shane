/**
 * ******************************************************************************** lynes.carter Period <<#>> Date First Modified: 11/30/2017 Project:
 * <<name or # >> Description of the project: 1-Goal of the program: <<Describe the overall goal in one or two sentences.>> 2-Significant constants:
 * <<List all constants declared and used in the program.>> 3-The user inputs are: <<List all data that the user must provide to the program.>> 4-The
 * program computes: <<List the quantities the program will compute.>> 5-The program outputs: <<List the items that the program displays on the screen
 * or writes to a file.>> *********************************************************************************
 * <p>
 * ************************************Responsibilities of a <<Class>> object:**************************************
 * <p>
 * A <<ClassObject>>: -Stores <<list what the instance variables are storing>> -Can calculate and return <<list what the accessor methods calculate
 * and return.>> -Can modify itself by <<list what the mutator methods can do.>> A <<ClassObject>> knows how to: <<LIST ONLY THE ONES YOU HAVE
 * DEFINED>> -create memory space for a <<Class>> object -create a deep copy of itself -create an instance of a <<Class>> object initialized with user
 * provided instance variable values. -turn itself into a String object for the purposes of output.
 * *****************************************************************************************************************
 */
/*
 * IF THIS IS A USER_DEFINED CLASS< DELETE THE PROGRAM HEADER ABOVE AND USE THE ONE BELOW.
 */

/**
 * ************************************Responsibilities of a <<Class>> object:************************************** A <<ClassObject>>: -Stores <<list
 * what the instance variables are storing>> -Can calculate and return <<list what the accessor methods calculate and return.>> -Can modify itself by
 * <<list what the mutator methods can do.>> A <<ClassObject>> knows how to: <<LIST ONLY THE ONES YOU HAVE DEFINED>> -create memory space for a
 * <<Class>> object -create a deep copy of itself -create an instance of a <<Class>> object initialized with user provided instance variable values.
 * -turn itself into a String object for the purposes of output.
 * *****************************************************************************************************************
 */
import java.util.Random;

public class Dice {

    private int face;
    private MutableObject mutableObj;

    public Dice() {
        face = 0;
        mutableObj = new MutableObject();
    }

    public Dice(Dice d1) {
        //WHAT HAPPENS IF THIS IS CLASS THAT HAS AN OBJECT LIKE ABOVE mutableObj? 
        face = d1.face;
        mutableObj = d1.mutableObj;
    }

    public void roll() {
        //WHAT ARE THE IMPLICATIONS OF THIS BEING INITIALIZE HERE ?
        Random generator = new Random();
        face = generator.nextInt(6) + 1;
    }

    public int getFace() {
        return face;
    }

    public String toString() {
        //DO YOU UNDERSTAND WHAT THIS IS REALLY DOING?
        //NEED TO TALK ABOUT STRINGS, IMMUTABILITY, BUILDING, ETC.... 
        return "The face value is: " + face;
    }

    public String objToString() {
        return super.toString();
    }
    
    public MutableObject getMutableObj() {
        return mutableObj;
    }

    
    public void setMutableObj(MutableObject mutable) {
        this.mutableObj = mutable;
    }
}
