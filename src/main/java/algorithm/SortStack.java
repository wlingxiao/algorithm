package algorithm;

import algorithm.list.Stack;
import lombok.val;

/// - 图例在 `docs/SortStack.drawio`
/// - Given a stack of integers, sort it in ascending order using another temporary stack.
/// - Examples:
/// - Input : `[34, 3, 31, 98, 92, 23]` Output : `[ 3, 23, 31, 34, 92, 98]`
/// - Input : `[3, 5, 1, 4, 2, 8]` Output : `[ 1, 2, 3, 4, 5, 8]`
public class SortStack {

    /// ##### 解决思路
    /// 汉诺塔问题
    /// 1. 弹出 stack 元素，如果 temp 为空则直接压入该元素
    /// 2. 如果 temp 不为空，则检查 temp 顶部元素是否小于该元素，如果是则弹出 temp 顶部元素压入 stack，重复执行该操作，直到 temp 顶部元素大于该元素或 temp 被清空。
    /// 3. 最后将该元素压入 temp
    public Stack<Integer> sort(Stack<Integer> stack) {
        val temp = new Stack<Integer>();
        while (!stack.isEmpty()) {
            val i = stack.pop();
            while (!temp.isEmpty() && temp.top() < i) {
                stack.push(temp.pop());
            }
            temp.push(i);
        }
        return temp;
    }

}
