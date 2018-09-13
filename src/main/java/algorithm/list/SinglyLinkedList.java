package algorithm.list;

import java.util.Iterator;
import java.util.Objects;

/**
 * 单链表
 */
public class SinglyLinkedList<E> implements Iterable<E> {

    private static class Node<T> {

        Node<T> next;

        T value;

        Node(T value) {
            this.value = value;
        }

        Node(Node<T> next, T value) {
            this.next = next;
            this.value = value;
        }
    }

    private Node<E> head;

    private Node<E> tail;

    private int size;

    public void insertFirst(E e) {
        if (head == null) {
            head = new Node<>(e);
            tail = head;
        } else {
            head = new Node<>(head, e);
        }
        size++;
    }

    public void insertLast(E e) {
        if (head == null) {
            head = new Node<>(e);
            tail = head;
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    public E first() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public E last() {
        if (tail == null) {
            return null;
        }
        return tail.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator();
    }

    public SinglyLinkedList<E> reverse() {
        SinglyLinkedList<E> r = new SinglyLinkedList<>();
        forEach(r::insertFirst);
        return r;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void removeAll(E e) {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        if (Objects.equals(head.value, e)) {
            Node<E> t = head;
            head = head.next;
            t.next = null; // help gc
        } else {
            Node<E> targetPrev = head;
            Node<E> target = targetPrev.next;
            while (target != null) {
                if (Objects.equals(e, target.value)) {
                    if (target == tail) {
                        tail = targetPrev;
                    }
                    targetPrev.next = target.next;
                    target.next = null; // help gc
                }
                targetPrev = targetPrev.next;
                target = target.next;
            }
        }
        size--;
    }

    private class SinglyLinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E t = current.value;
            current = current.next;
            return t;
        }
    }

}
