package me.demo.algorithm.tree;

/**
 * 1. 每个节点要么是红的，要么是黑的
 * 2. 根节点是黑的
 * 3. 每个叶子节点是黑的
 * 4. 如果一个节点是红的，那么他的两个儿子是黑的
 * 5. 对任一节点而言，其到叶节点尾端NULL指针的每一掉路径都包含相同数目的黑节点
 * <p>
 * 参考文章：
 * https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/03.01.md
 * https://blog.csdn.net/eson_15/article/details/51144079
 */
public class BlackRedTree {

    private static class Node {
        boolean color;
        int key;
        Node left;
        Node right;
        Node parent;

        public Node(boolean color, int key) {
            this.color = color;
            this.key = key;
        }

        @Override
        public String toString() {
            return String.format("[key: %s color: %s]", key, color ? "Red" : "Black");
        }
    }

    private final static boolean RED = false;

    private final static boolean BLACK = true;

    private Node root;

    private void leftRotate(Node current) {

    }

    private void rightRotate(Node current) {

    }

    public void insert(int key) {
        insert(new Node(BLACK, key));
    }

    private Node parentOf(Node node) {
        return node != null ? node.parent : null;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    private boolean isBlack(Node node) {
        return !isRed(node);
    }

    private void setRed(Node node) {
        if (node != null) {
            node.color = RED;
        }
    }

    private void setBlack(Node node) {
        if (node != null) {
            node.color = BLACK;
        }
    }

    private void insert(Node node) {
        Node current = null;
        Node x = root;
        while (x != null) {
            current = x;
            if (node.key > x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = current;
        if (current != null) {
            if (node.key > current.key) {
                current.right = node;
            } else {
                current.left = node;
            }
        }
        insertFixUp(node);
    }

    private void insertFixUp(Node node) {
        Node parent;
        Node gparent;

        while ((parent = parentOf(node)) != null && isRed(node)) {
            gparent = parentOf(parent);

            if (parent == gparent.left) {
                Node uncle = gparent.right;
                if (uncle != null && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                if (parent.right == node) {
                    leftRotate(parent);
                    Node t = parent;
                    parent = node;
                    node = t;
                }

                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {
                Node uncle = gparent.left;
                if (uncle != null && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                if (parent.left == node) {
                    rightRotate(parent);
                    Node t = parent;
                    parent = node;
                    node = t;
                }

                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        setBlack(root);
    }
}
