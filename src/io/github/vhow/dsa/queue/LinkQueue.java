package io.github.vhow.dsa.queue;

public class LinkQueue<E> implements IQueue<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public static void main(String[] args) {
        final int size = 10000;
        final IQueue<Integer> q = new LinkQueue<>();
        for (int i = 0; i < size; i++) {
            q.enqueue(i);
        }
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue can not first().");
        }
        return this.first.value;
    }

    @Override
    public void enqueue(E value) {
        final Node<E> node = new Node<>(value, null);
        if (this.first == null) {
            this.first = node;
        }
        if (this.last != null) {
            this.last.next = node;
        }
        this.last = node;
        this.size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue can not dequeue().");
        }
        final E firstValue = first.value;
        this.first = this.first.next;
        this.size--;
        return firstValue;
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
