package me.demo.algorithm.tree;

/**
 * 二叉查找树
 */
public class BinarySearchTree {

    private static class Node {
        int key;
        int value;

        Node left;
        Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public void insert(int key, int value) {
        Node node = new Node(key, value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (current != null) {
            if (node.key > current.key) {
                if (current.right == null) {
                    current.right = node;
                    break;
                } else {
                    current = current.right;
                }
            } else if (node.key < current.key) {
                if (current.left == null) {
                    current.left = node;
                    break;
                } else {
                    current = current.left;
                }
            } else {
                current.value = value;
                break;
            }
        }
    }

    public int find(int key) {
        if (root == null) {
            return -1;
        }
        Node current = root;
        while (current != null) {
            if (key > current.key) {
                current = current.right;
            } else if (key < current.key) {
                current = current.left;
            } else {
                break;
            }
        }
        if (current != null) {
            return current.value;
        } else {
            return -1;
        }
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public Node delete(Node current, int key) {
        if (key < current.key) {
            current.left = delete(current.left, key);
        } else if (key > current.key) {
            current.right = delete(current.right, key);
        } else if (current.left != null && current.right != null) {
            Node t = findMin(current.right);
            current.key = t.key;
            current.value = t.value;
            current.right = delete(current.right, current.key);
        } else {
            Node temp = current;
            if (current.left == null) {
                current = current.right;
            } else if (current.right == null) {
                current = current.left;
            }
            temp = null;
        }
        return current;
    }

    private Node findMin(Node node) {
        while (node != null) {
            if (node.left != null) {
                node = node.left;
            } else {
                break;
            }
        }
        return node;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node current) {
        if (current == null) {
            System.out.println("[]");
            return;
        }
        if (current.left != null) {
            inOrderTraversal(current.left);
        }
        System.out.print(" " + current.key + " ");
        if (current.right != null) {
            inOrderTraversal(current.right);
        }
    }

}
