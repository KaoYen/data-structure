import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleStackTest {
    @Test
    public void testPushAndPop() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
    }

    @Test
    public void testPeek() {
        SimpleStack<String> stack = new SimpleStack<>();
        stack.push("apple");
        stack.push("banana");

        assertEquals("banana", stack.peek());
        assertEquals("banana", stack.peek()); // Peek multiple times without affecting stack
        assertEquals("banana", stack.pop()); // Pop after peek should still give the same element
    }

    @Test
    public void testIsEmpty() {
        SimpleStack<Character> stack = new SimpleStack<>();
        assertTrue(stack.isEmpty());

        stack.push('a');
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushPopMixed() {
        SimpleStack<Double> stack = new SimpleStack<>();
        stack.push(1.1);
        stack.push(2.2);
        assertEquals(Double.valueOf(2.2), stack.pop());

        stack.push(3.3);
        assertEquals(Double.valueOf(3.3), stack.peek());

        stack.pop();
        assertEquals(Double.valueOf(1.1), stack.peek());
    }

    @Test
    public void testEmptyStackPop() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        assertNull(stack.pop());
    }
}
