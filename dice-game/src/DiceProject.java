/**
 * ******************************************************************************** lynes.carter Period <<#>> Date First Modified: 12/1/2017 Project:
 * <<name or # >> Description of the project: 1-Goal of the program: <<Describe the overall goal in one or two sentences.>> 2-Significant constants:
 * <<List all constants declared and used in the program.>> 3-The user inputs are: <<List all data that the user must provide to the program.>> 4-The
 * program computes: <<List the quantities the program will compute.>> 5-The program outputs: <<List the items that the program displays on the screen
 * or writes to a file.>> *********************************************************************************
 */

/*
 * IF THIS IS A USER_DEFINED CLASS< DELETE THE PROGRAM HEADER ABOVE AND USE THE ONE BELOW.
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
/**
 * ************************************Responsibilities of a <<Class>> object:************************************** A <<ClassObject>>: -Stores <<list
 * what the instance variables are storing>> -Can calculate and return <<list what the accessor methods calculate and return.>> -Can modify itself by
 * <<list what the mutator methods can do.>> A <<ClassObject>> knows how to: <<LIST ONLY THE ONES YOU HAVE DEFINED>> -create memory space for a
 * <<Class>> object -create a deep copy of itself -create an instance of a <<Class>> object initialized with user provided instance variable values.
 * -turn itself into a String object for the purposes of output.
 * *****************************************************************************************************************
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class DiceProject extends JFrame {

    private static final long serialVersionUID = -5958983576773195775L;
    private static final Object[] okOptions = { "OK" };
    private static final int WINNING_BET = 4;
    private static final int LOSING_BET = 1;
    private static final String NEWLINE = "\n";
    private DicePanel diePanel1, diePanel2;
    private int bank;
    private int numGames;
    private int gameNumber;
    private int highLimitRoll;
    private int highLimitBank;

    public DiceProject() {
        JFrame theGUI = new JFrame();
        theGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        theGUI.setTitle("Dice Program");
        theGUI.setSize(650, 350);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        diePanel1 = new DicePanel(Color.white);
        diePanel2 = new DicePanel(Color.white);
        Container pane = theGUI.getContentPane();
        pane.setLayout(new GridLayout(1, 2));
        pane.add(diePanel1);
        pane.add(diePanel2);
        theGUI.setVisible(true);
    }

    public static void main(String[] args) {
        DiceProject theGUI = new DiceProject();
        theGUI.playGame(theGUI);
        System.exit(0);
    }

    private void playGame(DiceProject theGUI) {
        bank = getUserInput(theGUI, "Enter starting amount of money");
        highLimitBank = bank;
        highLimitRoll = 1;
        numGames = getUserInput(theGUI, "Enter desired number of games");
        for (int rolls = 1; rolls <= theGUI.numGames && theGUI.bank > 0; rolls++) {
            roll();
            gameNumber = rolls;
            processRoll();
            JOptionPane.showOptionDialog(theGUI, getGameInfo(), "Game Info", JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.WARNING_MESSAGE, null, okOptions, okOptions[0]);
        }
        JOptionPane.showOptionDialog(theGUI, getGameSummaryInfo(), "Game Summary", JOptionPane.PLAIN_MESSAGE,
                JOptionPane.WARNING_MESSAGE, null, okOptions, okOptions[0]);
    }

    private String getGameInfo() {
        StringBuffer buf = new StringBuffer("Game Number: ");
        buf.append(gameNumber);
        buf.append(NEWLINE);
        buf.append("Roll Amount: ");
        buf.append(currentRollAmount());
        buf.append(NEWLINE);
        buf.append("Bank: $");
        buf.append(bank);
        buf.append(NEWLINE);
        if (winningRoll()) {
            buf.append("You won $" + WINNING_BET);
        } else {
            buf.append("You lost $" + LOSING_BET);
        }
        buf.append(NEWLINE);
        return buf.toString();
    }

    private String getGameSummaryInfo() {
        StringBuffer buf = new StringBuffer("Games Played: ");
        buf.append(gameNumber);
        buf.append(NEWLINE);
        buf.append("Current Bank: $");
        buf.append(bank);
        buf.append(NEWLINE);
        if (highLimitRoll == numGames && bank == highLimitBank) {
            buf.append("Congratulations you quit on roll " + highLimitRoll + " when you had your max $" + highLimitBank);
        } else {
            buf.append("You should have quit on roll " + highLimitRoll + " when you had $" + highLimitBank);
        }
        buf.append(NEWLINE);
        if (bank == 0) {
            buf.append("You are broke after roll " + gameNumber);
            buf.append(NEWLINE);
        }
        return buf.toString();
    }

    private int getUserInput(DiceProject theGUI, String prompt) {
        boolean sentinel = true;
        int result = 0;
        while (sentinel) {
            String bankInputResult = JOptionPane.showInputDialog(prompt);
            try {
                result = theGUI.parseTextToPositiveInteger(bankInputResult);
                if (result < 1) {
                    showWarning(theGUI,
                            new Exception("The number entered must be greater than zero. \n  You entered: " + result));
                } else {
                    sentinel = false;
                }
            }
            catch (NumberFormatException e) {
                showWarning(theGUI, e);
            }
        }
        return result;
    }

    private void showWarning(DiceProject theGUI, Exception e) {
        JOptionPane.showOptionDialog(theGUI, e.getLocalizedMessage(), "Invalid Entry", JOptionPane.PLAIN_MESSAGE,
                JOptionPane.WARNING_MESSAGE, null, okOptions, okOptions[0]);
    }

    private void roll() {
        diePanel1.updateFace();
        diePanel2.updateFace();
    }

    private void processRoll() {
        System.out.println("Game Number:" + gameNumber);
        if (winningRoll()) {
            bank += WINNING_BET;
            checkHighLimitBank();
        } else {
            bank -= LOSING_BET;
        }
        System.out.println("\tCurrent Bank: $" + bank);
    }

    private void checkHighLimitBank() {
        if (bank > highLimitBank) {
            highLimitBank = bank;
            highLimitRoll = gameNumber;
        }
    }

    private boolean winningRoll() {
        System.out.println("\tGame Roll = " + currentRollAmount());
        return currentRollAmount() == 7;
    }

    private int currentRollAmount() {
        return diePanel1.getDieValue() + diePanel2.getDieValue();
    }

    public int parseTextToPositiveInteger(String value) throws NumberFormatException {
        try {
            return Integer.parseInt(value);
        }
        catch (Exception e) {
            if (value == null || value.isEmpty()) {
                value = "<empty>";
            }
            throw new NumberFormatException("Invalid Input: " + value + " is not a number.");
        }
    }

    public int getGameNumber() {
        return gameNumber;
    }
}
