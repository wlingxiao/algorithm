package algorithm.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class QueueTest {
    private Queue<Integer> queue;

    @Before
    public void setUp() {
        queue = new Queue<>();
    }

    @Test
    public void testEnqueueThenDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertTrue(queue.size() == 3);

        assertTrue(1 == queue.dequeue());
        assertTrue(2 == queue.dequeue());
        assertTrue(3 == queue.dequeue());

        assertTrue(queue.size() == 0);
        assertTrue(queue.isEmpty());
    }

}
