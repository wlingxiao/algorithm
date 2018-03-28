package me.demo.algorithm.tree;

/**
 * 深度：对于任意节点n,n的深度为从根到n的唯一路径长，根的深度为0；
 * 高度：对于任意节点n,n的高度为从n到一片树叶的最长路径长，所有树叶的高度为0；
 */
public class AvlTree {

    static class Node {
        Node left;
        Node right;
        int value;
        int height;

        public Node(int value) {
            this.value = value;
        }
    }

    int height(Node node) {
        return node == null ? -1 : node.height;
    }

    /**
     * LL
     */
    Node leftLeftRotate(Node k2) {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height);
        return k1;
    }

    /**
     * RR
     */
    Node rightRightRotate(Node k2) {
        Node k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;

        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(k2.height, height(k1.right));

        return k1;
    }

    Node leftRightRotate(Node node) {
        node.left = rightRightRotate(node.left);
        return leftLeftRotate(node);
    }

    Node rightLeftRotate(Node node) {
        node.left = leftLeftRotate(node.left);
        return rightRightRotate(node);
    }

    public void insert(int value) {

    }

}
