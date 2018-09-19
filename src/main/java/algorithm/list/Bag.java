package algorithm.list;

import java.util.Iterator;

public class Bag<E> implements Iterable<E> {
    private Node first;

    private class Node {
        E e;
        Node next;
    }

    public void add(E element) {
        Node old = first;
        first = new Node();
        first.e = element;
        first.next = old;
    }

    private class BagIterator implements Iterator<E> {
        private Node current = first;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E e = current.e;
            current = current.next;
            return e;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new BagIterator();
    }
}
