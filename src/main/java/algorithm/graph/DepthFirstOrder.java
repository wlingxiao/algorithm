package algorithm.graph;

import algorithm.list.Queue;
import algorithm.list.Stack;

/**
 * 有向图中基于深度优先搜索的顶点排序
 */
public class DepthFirstOrder {

    private boolean[] marked;

    private Queue<Integer> pre; // 所有顶点的前序排列

    private Queue<Integer> post; // 所有顶点的后续排列

    private Stack<Integer> reversePost; // 所有顶点的逆后续排列

    public DepthFirstOrder(Digraph digraph) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();

        marked = new boolean[digraph.v()];

        for (int v = 0; v < digraph.v(); v++) {
            if (!marked[v]) {
                dfs(digraph, v);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        pre.enqueue(v);

        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

}
