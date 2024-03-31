import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleQueueTest {
    @Test
    public void testEnqueueAndDequeue() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
    }

    @Test
    public void testPeek() {
        SimpleQueue<String> queue = new SimpleQueue<>();
        queue.enqueue("apple");
        queue.enqueue("banana");

        assertEquals("apple", queue.peek());
        assertEquals("apple", queue.peek()); // Peek multiple times without affecting queue
        assertEquals("apple", queue.dequeue()); // Dequeue after peek should still give the same element
    }

    @Test
    public void testIsEmpty() {
        SimpleQueue<Character> queue = new SimpleQueue<>();
        assertTrue(queue.isEmpty());

        queue.enqueue('a');
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueueDequeueMixed() {
        SimpleQueue<Double> queue = new SimpleQueue<>();
        queue.enqueue(1.1);
        queue.enqueue(2.2);
        assertEquals(Double.valueOf(1.1), queue.dequeue());

        queue.enqueue(3.3);
        assertEquals(Double.valueOf(2.2), queue.dequeue());

        queue.enqueue(4.4);
        assertEquals(Double.valueOf(3.3), queue.dequeue());
        assertEquals(Double.valueOf(4.4), queue.dequeue());
    }

    @Test
    public void testEmptyQueueDequeue() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        assertNull(queue.dequeue());
    }
}
