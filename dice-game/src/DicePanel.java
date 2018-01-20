/**
 * ********************************************************************************
 * lynes.carter
 * Period <<#>>
 * Date First Modified: 11/30/2017
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
 * <p>
 * ************************************Responsibilities of a <<Class>> object:**************************************
 * <p>
 * A <<ClassObject>>:
 * -Stores <<list what the instance variables are storing>>
 * -Can calculate and return <<list what the accessor methods calculate and return.>>
 * -Can modify itself by <<list what the mutator methods can do.>>
 * A <<ClassObject>> knows how to: <<LIST ONLY THE ONES YOU HAVE DEFINED>>
 * -create memory space for a <<Class>> object
 * -create a deep copy of itself
 * -create an instance of a <<Class>> object initialized with user provided instance
 * variable values.
 * -turn itself into a String object for the purposes of output.
 * *****************************************************************************************************************
 */
 
 /* IF THIS IS A USER_DEFINED CLASS< DELETE THE PROGRAM HEADER
    ABOVE AND USE THE ONE BELOW.*/

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

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DicePanel extends JPanel
{
    private int width, height;
    private int face;

    public DicePanel(Color backColor)
    {
        setSize(350, 350);
        setBackground(Color.darkGray);

    }




         public void paintComponent(Graphics g)
         {
             super.paintComponent(g);
             g.setColor(Color.white);
             g.drawRoundRect(5, 5, 300, 300, 50, 50);
             g.fillRoundRect(5, 5, 300, 300, 50, 50);

             switch (face)
                     {
                         case 1:
                             eraseDots(g);
                             draw1Dot(g);
                             break;
                         case 2:
                             eraseDots(g);
                             draw2Dots(g);
                             break;
                         case 3:
                             eraseDots(g);
                             draw3Dots(g);
                             break;
                         case 4:
                             eraseDots(g);
                             draw4Dots(g);
                             break;
                         case 5:
                             eraseDots(g);
                             draw5Dots(g);
                             break;
                         case 6:
                             eraseDots(g);
                             draw6Dots(g);
                             break;
                         default:
                             break;

                     }
         }




    public DicePanel(Color backColor, int w, int h)
    {

        setBackground(backColor);
        width = w;
        height = h;
        setSize(width, height);

    }


    public void updateFace(int value)
    {
       face = value;
       repaint();

    }

    private void eraseDots(Graphics g)
    {
        g.setColor(Color.white);
        draw1Dot(g);
        draw6Dots(g);
        g.setColor(Color.black);
    }

    private void draw1Dot(Graphics g)
    {
        g.fillOval(126, 126, 50, 50);
    }

    private void draw2Dots(Graphics g)
    {
        g.fillOval(58, 215, 50, 50);
        g.fillOval(208, 65, 50, 50);
    }

    private void draw3Dots(Graphics g)
    {
        g.fillOval(75, 205, 50, 50);
        g.fillOval(215, 55, 50, 50);
        g.fillOval(140, 130, 50, 50);
    }

    private void draw4Dots(Graphics g)
    {
        g.fillOval(58, 215, 50, 50);
        g.fillOval(208, 65, 50, 50);
        g.fillOval(58, 65, 50, 50);
        g.fillOval(208, 215, 50, 50);
    }

    private void draw5Dots(Graphics g)
    {
        g.fillOval(58, 215, 50, 50);
        g.fillOval(208, 65, 50, 50);
        g.fillOval(58, 65, 50, 50);
        g.fillOval(208, 215, 50, 50);
        g.fillOval(135, 135, 50, 50);

    }

    private void draw6Dots(Graphics g)
    {
        g.fillOval(58, 215, 50, 50);
        g.fillOval(208, 65, 50, 50);
        g.fillOval(58, 65, 50, 50);
        g.fillOval(208, 215, 50, 50);
        g.fillOval(58, 140, 50, 50);
        g.fillOval(208, 140, 50, 50);
    }
}

