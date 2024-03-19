import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSimpleHashMapTest {
    private SimpleHashMap<String, Integer> map;

    @Before
    public void setUp() {
        map = new SimpleHashMap<>();
    }

    @Test
    public void testPutAndGet() {
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        assertEquals(Integer.valueOf(1), map.get("one"));
        assertEquals(Integer.valueOf(2), map.get("two"));
        assertEquals(Integer.valueOf(3), map.get("three"));
    }

    @Test
    public void testPutUpdatesExistingKey() {
        map.put("one", 1);
        map.put("one", 2);

        assertEquals(Integer.valueOf(2), map.get("one"));
    }

    @Test
    public void testContainsKey() {
        map.put("one", 1);
        map.put("two", 2);

        assertTrue(map.containsKey("one"));
        assertFalse(map.containsKey("three"));
    }

    @Test
    public void testRemove() {
        map.put("one", 1);
        map.put("two", 2);

        assertTrue(map.containsKey("one"));
        map.remove("one");
        assertFalse(map.containsKey("one"));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(map.isEmpty());
        map.put("one", 1);
        assertFalse(map.isEmpty());
    }

    @Test
    public void testResize() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>(4);

        for (int i = 0; i < 10; i++) {
            map.put(i, "Value " + i);
        }

        int currentCapacity = map.getCapacity();

        for (int i = 10; i < 20; i++) {
            map.put(i, "Value " + i);
        }

        int newCapacity = map.getCapacity();

        assertTrue(newCapacity > currentCapacity);
    }

}
