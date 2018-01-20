import static org.junit.Assert.*;
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
 *  Initial commit:  Jan 19, 201812:12:05 PM
 *  User:  thor 
 */
/**
 * @author thor
 */
public class DiceProjectTest {

    private DiceProject test;
    
    @Before
    public void setUp() throws Exception {
        test = new DiceProject();
    }
    
    

    @After
    public void tearDown() throws Exception {}

    @Test
    public void assertSetup() {
        assertNotNull(test);
    }
    
    
    @Test
    public void test() {
        
    }
}
