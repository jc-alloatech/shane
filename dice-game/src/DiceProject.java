/**
 * ********************************************************************************
  * lynes.carter
 * Period <<#>>
 * Date First Modified: 12/1/2017
 * Project: <<name or # >>
 * Description of the project:
 * 1-Goal of the program:
 * <<Describe the overall goal in one or two sentences.>>
 * 2-Significant constants:
 * <<List all constants declared and used in the program.>>
 * 3-The user inputs are:
 * <<List all data that the user must provide to the program.>>
 * 4-The program computes:
 * <<List the quantities the program will compute.>>
 * 5-The program outputs:
 * <<List the items that the program displays on the screen or writes to a file.>>
 * *********************************************************************************
 */
 
 /* IF THIS IS A USER_DEFINED CLASS< DELETE THE PROGRAM HEADER
    ABOVE AND USE THE ONE BELOW.*/

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
/**
 * ************************************Responsibilities of a <<Class>> object:**************************************
 *
 * A <<ClassObject>>:
 *                      -Stores <<list what the instance variables are storing>>
 *                      -Can calculate and return <<list what the accessor methods calculate and return.>>
 *                      -Can modify itself by <<list what the mutator methods can do.>>
 * A <<ClassObject>> knows how to: <<LIST ONLY THE ONES YOU HAVE DEFINED>>
 *                              -create memory space for a <<Class>> object
 *                              -create a deep copy of itself
 *                              -create an instance of a <<Class>> object initialized with user provided instance
 *                                  variable values.
 *                              -turn itself into a String object for the purposes of output.
 * *****************************************************************************************************************
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;




    public class DiceProject extends JFrame
    {

        private Dice dice;

         private static DicePanel panel, panel2;

        public DiceProject()
        {
                       
            JFrame theGUI = new JFrame();
            theGUI.setTitle("Dice Program");
            theGUI.setSize(650, 350);
            theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel = new DicePanel(Color.white);
            panel2 = new DicePanel(Color.white);
            Container pane = theGUI.getContentPane();
            pane.setLayout(new GridLayout(1, 2));
            pane.add(panel);
            pane.add(panel2);
            theGUI.setVisible(true);
        }

    public static void main(String[]args)
    {
        DiceProject theGUI = new DiceProject();
      
        int die1, die2, dollars, countTo, startingMoney, maxDollars, countAtMax;
        String test1 = JOptionPane.showInputDialog("Enter starting amount of money");
        startingMoney = Integer.parseInt(test1);
        String test2 = JOptionPane.showInputDialog("Enter desired number of rolls");
        countTo = Integer.parseInt(test2);


        dollars = 0;
        countAtMax = 0;
        countTo = 0;
        

        while (dollars > 0)
        {
            countTo++;
        }

        panel.updateFace(6);
        panel2.updateFace(5);
    }

}


