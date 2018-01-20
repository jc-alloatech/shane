import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.awt.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Proprietary and Confidential
 *           AlloaTech, LLC.
 *   
 * 	This document contains material which is proprietary and confidential 
 *  property of ThorCode.
 *   
 *  The right to view, reproduce, modify, distribute, or in any way display
 *  this work is prohibited without the expressed written consent of 
 *  ThorCode
 *
 *  Copyright &copy; 2018
 *  Initial commit:  Jan 19, 201811:12:27 AM
 *  User:  thor 
 */
/**
 * @author thor
 */
public class DicePanelTest {
    
    private DicePanel test;

    @Before
    public void setUp() throws Exception {
        test = new DicePanel(new Color(20, 20, 20, 20));
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void assertSetup() {
        assertNotNull(test);
    }
    
    @Test
    public void testDiceHasDefaultConst() {
        //SHANE TO FIX
        assertTrue(TestHelper.hasDefaultConst(test.getClass()));
    }
    
    /**
     * Test method for {@link DicePanel#DicePanel(java.awt.Color)}.
     */
    @Test
    public void testDicePanelColor() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link DicePanel#paintComponent(java.awt.Graphics)}.
     */
    @Test
    public void testPaintComponentGraphics() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link DicePanel#DicePanel(java.awt.Color, int, int)}.
     */
    @Test
    public void testDicePanelColorIntInt() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link DicePanel#updateFace(int)}.
     */
    @Test
    public void testUpdateFace() {
        fail("Not yet implemented");
    }
    
   
}
