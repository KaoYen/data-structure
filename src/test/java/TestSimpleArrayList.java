import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSimpleArrayList {

    @Test
    public void testAddAndGet() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    public void testRemove() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("C", list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithInvalidIndex() {
        SimpleArrayList<Double> list = new SimpleArrayList<>();
        list.add(1.0);
        list.remove(1); // 1 is an invalid index
    }

    @Test
    public void testToString() {
        SimpleArrayList<Character> list = new SimpleArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');

        assertEquals("[a, b, c]", list.toString());
    }
}


