import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        assertTrue(TestHelper.hasDefaultConst(test.getClass()));
    }
}
