package algorithm.graph;


public interface Search {

    /**
     * v 和 s 是否连通
     */
    boolean marked(int v);

    /**
     * 与 s 连通的所有顶点数
     */
    int count();
}
