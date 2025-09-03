package algorithm.tree;

import lombok.val;

import java.util.*;

/**
 * 图例在 docs/ListNode.drawio
 */
public class ListTree {

    public record Node(String key, String parent, List<Node> children) {
    }

    public static Node genTree() {
        var d1 = new Node("D1", "C2", null);

        var c1 = new Node("C1", "B1", null);
        var c2 = new Node("C2", "B2", List.of(d1));
        var c3 = new Node("C3", "B2", null);

        var b1 = new Node("B1", "A1", List.of(c1));
        var b2 = new Node("B2", "A1", List.of(c2, c3));

        var a1 = new Node("A1", null, List.of(b1, b2));

        return a1;
    }

    /// - 该实现假设不知道 parent。
    /// - 实现思路是先使用深度或广度优先算法遍历树找到目标节点，在遍历的过程中使用 parentMap 记录叶子节点对应的父节点，用于回溯。
    /// - 回溯时，在 parentMap 中找到目标节点的父级然后逐级往上回溯即可找到根节点到目标节点的路径。
    public static List<String> path1(Node root, String targetKey) {
        var stack = new LinkedList<Node>();
        stack.push(root);

        // 子节点 -> 父节点
        var parentMap = new HashMap<String, Node>();
        // 根节点的父节点为 null
        parentMap.put(root.key(), null);

        while (!stack.isEmpty()) {
            var node = stack.pop();

            if (targetKey.equals(node.key())) {
                break;
            }

            if (node.children() != null) {
                for (var i : node.children()) {
                    parentMap.put(i.key(), node);
                    stack.push(i);
                }
            }
        }

        // 回溯
        val result = new LinkedList<String>();
        var current = targetKey;
        result.addFirst(current);
        while (current != null) {
            val parent = parentMap.get(current);
            if (parent != null) {
                current = parent.key();
                result.addFirst(current);
            } else {
                current = null;
            }
        }
        return result;
    }

    /// - 在已知 parent 的情况下的实现。
    /// - 多的这个 parent 信息似乎对实现没影响，还是需要遍历树然后构建一个 map 来确定 key 和 Node 的关系。
    /// - **结论，增加的 `String parent` 字段对实现没有影响**
    /// - 如果增加的是 `Node parent` 则只需遍历树找到目标节点然后逐级回溯即可。
    public static List<String> path2(Node root, String targetKey) {
        return path1(root, targetKey);
    }

}
