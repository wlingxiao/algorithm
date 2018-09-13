package algorithm.graph;

public class GraphTestUtil {

    public static Graph createGraph() {
        /**
         * 算法第四版 340 页，图 4.1.13 表示的无向图
         */
        Graph graph = new Graph(8);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);

        graph.addEdge(2, 1);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);

        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        graph.addEdge(6, 7);
        return graph;
    }

}
