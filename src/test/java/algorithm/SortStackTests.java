package algorithm;

import algorithm.list.Stack;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        val ret = sortStack.sort(stack);
        assertEquals(3, ret.pop());
        assertEquals(23, ret.pop());
        assertEquals(31, ret.pop());
        assertEquals(34, ret.pop());
        assertEquals(92, ret.pop());
        assertEquals(98, ret.pop());
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

        val ret = sortStack.sort(stack);
        assertEquals(1, ret.pop());
        assertEquals(2, ret.pop());
        assertEquals(3, ret.pop());
        assertEquals(4, ret.pop());
        assertEquals(5, ret.pop());
        assertEquals(8, ret.pop());
    }

}
