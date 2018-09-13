package algorithm.tree;

import algorithm.list.Stack;

import java.util.Iterator;

/**
 * 二叉查找树
 */
public class BinarySearchTree implements Iterable<Integer> {

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

    private Node insertRecursive(Node current, int key, int value) {
        if (current == null) {
            return new Node(key, value);
        }
        if (key > current.key) {
            current.right = insertRecursive(current.right, key, value);
        } else if (key < current.key) {
            current.left = insertRecursive(current.left, key, value);
        } else {
            current.value = value;
        }
        return current;
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
        if (current == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        if (key < current.key) {
            current.left = delete(current.left, key);
        } else if (key > current.key) {
            current.right = delete(current.right, key);
        } else if (current.left != null && current.right != null) { // Tow children
            Node t = findMin(current.right);
            current.key = t.key;
            current.value = t.value;
            current.right = delete(current.right, current.key);
        } else { // one or zero children
            Node temp = current;
            if (current.left == null) { // also handle 0 children
                current = current.right;
                temp.right = null; // help gc
            } else if (current.right == null) {
                current = current.left;
                temp.left = null; // help gc
            }
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

    @Override
    public Iterator<Integer> iterator() {
        return new BinarySearchTreeIterator();
    }

    private class BinarySearchTreeIterator implements Iterator<Integer> {

        private Stack<Node> stack = new Stack<>();

        public BinarySearchTreeIterator() {
            Node current = root;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Integer next() {
            Node node = stack.pop();
            Integer ret = node.key;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            return ret;
        }
    }
}
