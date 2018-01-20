import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


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
