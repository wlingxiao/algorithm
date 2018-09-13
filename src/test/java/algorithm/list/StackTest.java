package algorithm.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StackTest {

    private Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void testPushAndPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertTrue(stack.size() == 3);

        assertTrue(3 == stack.pop());
        assertTrue(2 == stack.pop());
        assertTrue(1 == stack.pop());

        assertTrue(stack.size() == 0);
        assertTrue(stack.isEmpty());
    }

}
