package algorithm;

import algorithm.list.Stack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortStackTests {

    @Test
    public void testSort1() {
        SortStack sortStack = new SortStack();
        Stack<Integer> stack = new Stack<>();
        stack.push(23);
        stack.push(92);
        stack.push(98);
        stack.push(31);
        stack.push(3);
        stack.push(34);

        Stack<Integer> ret = sortStack.sort(stack);
        assertEquals(ret.pop().intValue(), 3);
        assertEquals(ret.pop().intValue(), 23);
        assertEquals(ret.pop().intValue(), 31);
        assertEquals(ret.pop().intValue(), 34);
        assertEquals(ret.pop().intValue(), 92);
        assertEquals(ret.pop().intValue(), 98);
    }

    @Test
    public void testSort2() {
        SortStack sortStack = new SortStack();
        Stack<Integer> stack = new Stack<>();
        stack.push(8);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(5);
        stack.push(3);

        Stack<Integer> ret = sortStack.sort(stack);
        assertEquals(ret.pop().intValue(), 1);
        assertEquals(ret.pop().intValue(), 2);
        assertEquals(ret.pop().intValue(), 3);
        assertEquals(ret.pop().intValue(), 4);
        assertEquals(ret.pop().intValue(), 5);
        assertEquals(ret.pop().intValue(), 8);
    }

}
