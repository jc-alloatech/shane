import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiceTest {

    private Dice test;

    @Before
    public void setUp() throws Exception {
        test = new Dice();
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testDice() {
        assertNotNull("test should not be null", test);
    }

    @Test
    public void testDiceHasDefaultConst() {
        assertTrue(TestHelper.hasDefaultConst(test.getClass()));
    }

    @Test
    public void testDiceHasCopyConst() {
        assertTrue(TestHelper.hasCopyConst(test.getClass()));
        Dice copiedDie = new Dice(test);
        assertEquals(0, test.getFace());
        int sentinel = 0;
        while (copiedDie.getFace() == test.getFace()) {
            if (sentinel == 20) {
                break;
            }
            copiedDie.roll();
        }
        MutableObject mutObj = test.getMutableObj();
        assertEquals(mutObj, test.getMutableObj());
        assertEquals(0, test.getMutableObj().getMutable());
        assertEquals(0, copiedDie.getMutableObj().getMutable());
        assertEquals(mutObj, copiedDie.getMutableObj());
        test.getMutableObj().setMutable(3);
        ;
        assertEquals(3, test.getMutableObj().getMutable());
        // FOR SHANE TO FIGURE OUT
        assertEquals(0, copiedDie.getMutableObj().getMutable());
        assertNotEquals(test.getFace(), copiedDie.getFace());
    }

    @Test
    public void testDiceHasFaceMemberVar() {
        assertTrue(TestHelper.hasDeclaredField(test.getClass(), "face", "int"));
    }

    @Test
    public void testRoll() {
        long now = System.nanoTime();
        int times = 10000000;
        for (int i = 0; i < times; i++) {
            test.roll();
        }
        long duration = System.nanoTime() - now;
        // duration current impl = 632981180
        System.out.println("Time to roll " + times + " = " + duration);
        // FOR SHANE TO FIGURE OUT
        assertTrue("duration of " + times + " rolls < 200000000", duration < 200000000);
    }

    @Test
    public void testRollProbability() {
        int times = 10000000;
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            test.roll();
            results.add(test.getFace());
        }
        final Map<Integer, Long> countFrequencies = results.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        final long maxFrequency = countFrequencies.values().stream().mapToLong(count -> count).max().orElse(-1);
        List<Integer> result = countFrequencies.entrySet().stream().filter(tuple -> tuple.getValue() == maxFrequency)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println("Count Frequencies =" + countFrequencies);
        System.out.println("Max Frequency =" + result + "=" + maxFrequency);
        assertEquals(times / 6, countFrequencies.get(1), 10000);
        assertEquals(times / 6, countFrequencies.get(2), 10000);
        assertEquals(times / 6, countFrequencies.get(3), 10000);
        assertEquals(times / 6, countFrequencies.get(4), 10000);
        assertEquals(times / 6, countFrequencies.get(5), 10000);
        assertEquals(times / 6, countFrequencies.get(6), 10000);
    }

    @Test
    public void testGetFace() {
        assertEquals(0, test.getFace());
        while(test.getFace() == 0) {
            test.roll();
        }
        assertTrue(test.getFace() != 0);
    }

    @Test
    public void testToString() {
        test.roll();
        String objToString = test.objToString();
        String testToString = test.toString();
        System.out.println("Obj toString()=" + objToString);
        System.out.println("Dice toString()=" + testToString);
        assertNotEquals(objToString, testToString);
    }
}
