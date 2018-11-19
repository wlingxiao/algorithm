package algorithm;

import algorithm.list.Stack;

/**
 * Given a stack of integers, sort it in ascending order using another temporary stack.
 * Examples:
 * <pre>
 *  Input : [34, 3, 31, 98, 92, 23]
 *  Output : [3, 23, 31, 34, 92, 98]
 *
 *  Input : [3, 5, 1, 4, 2, 8]
 *  Output : [1, 2, 3, 4, 5, 8]
 * </pre>
 */
public class SortStack {

    public Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            Integer i = stack.pop();
            while (!temp.isEmpty() && temp.top() < i) {
                stack.push(temp.pop());
            }
            temp.push(i);
        }
        return temp;
    }

}
