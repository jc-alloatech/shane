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
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DicePanel extends JPanel {

    private static final long serialVersionUID = -6540721984613320958L;
    private static final int CIRCLE_WIDTH = 50;
    private static final int CIRCLE_HEIGHT = 50;
    private int width, height;
    private Color bgColor;
    private Dice die;

    public DicePanel() {
        this(Color.DARK_GRAY);
    }

    public DicePanel(Color backColor) {
        this(backColor, 300, 300);
    }

    public DicePanel(Color backColor, int width, int height) {
        this.bgColor = backColor;
        this.width = width;
        this.height = height;
        setSize(width, height);
        die = new Dice();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.drawRoundRect(5, 5, width, height, CIRCLE_WIDTH, CIRCLE_HEIGHT);
        g.fillRoundRect(5, 5,  width, height, CIRCLE_WIDTH, CIRCLE_HEIGHT);
        switch (die.getFace()) {
            case 1:
                drawSnakeEye(g);
                break;
            case 2:
                drawFace2(g);
                break;
            case 3:
                drawFace3(g);
                break;
            case 4:
                drawFace4(g);
                break;
            case 5:
                drawFace5(g);
                break;
            case 6:
                drawFace6(g);
                break;
            default:
                //System.err.println(new Exception("Die face should range between 1-6."));
                break;
        }
    }

    public void updateFace() {
        die.roll();
        repaint();
    }

    private void drawSnakeEye(Graphics g) {
        g.setColor(Color.black);
        drawDot5(g);
    }

    private void drawFace2(Graphics g) {
        g.setColor(Color.black);
        drawDot7(g);
        drawDot3(g);
    }

    private void drawFace3(Graphics g) {
        g.setColor(Color.black);
        drawSnakeEye(g);
        drawFace2(g);
    }

    private void drawFace4(Graphics g) {
        g.setColor(Color.black);
        drawDot7(g);
        drawDot3(g);
        drawDot1(g);
        drawDot9(g);
    }

    private void drawFace5(Graphics g) {
        g.setColor(Color.black);
        drawSnakeEye(g);
        drawFace4(g);
    }

    private void drawFace6(Graphics g) {
        g.setColor(Color.black);
        drawFace4(g);
        drawDot4(g);
        drawDot6(g);
    }

    private void drawDot1(Graphics g) {
        g.fillOval(50, 50, CIRCLE_WIDTH, CIRCLE_HEIGHT);
    }

    private void drawDot3(Graphics g) {
        g.fillOval(200, 50, CIRCLE_WIDTH, CIRCLE_HEIGHT);
    }

    private void drawDot4(Graphics g) {
        g.fillOval(50, 125, CIRCLE_WIDTH, CIRCLE_HEIGHT);
    }

    private void drawDot5(Graphics g) {
        g.fillOval(125, 125, CIRCLE_WIDTH, CIRCLE_HEIGHT);
    }

    private void drawDot6(Graphics g) {
        g.fillOval(200, 125, CIRCLE_WIDTH, CIRCLE_HEIGHT);
    }

    private void drawDot7(Graphics g) {
        g.fillOval(50, 200, CIRCLE_WIDTH, CIRCLE_HEIGHT);
    }

    private void drawDot9(Graphics g) {
        g.fillOval(200, 200, CIRCLE_WIDTH, CIRCLE_HEIGHT);
    }

    public int getDieValue() {
        return die.getFace();
    }
}
