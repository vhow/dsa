package io.github.vhow.dsa.list;

public class DoubleLinkedList<E> implements IList<E> {

    private class Node {
        E item;
        Node prev;
        Node next;

        Node(Node prev, E item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private Node first;

    private Node last;

    private int size;

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
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
    public E get(int index) {
        checkIndex(index);
        final Node node = node(index);
        return node.item;
    }

    private Node node(int index) {
        checkIndex(index);
        if (index > (size >> 1)) {
            Node node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        } else {
            Node node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
    }

    @Override
    public void add(E value) {
        final Node node = new Node(last, value, null);
        if (last == null) {
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        if (first == null) {
            first = node;
        }
        size++;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        if (index == size) {
            add(value);
            return;
        }
        final Node node = node(index);
        if (node == null) {
            add(value);
        } else {
            final Node newNode = new Node(node.prev, value, node);
            if (node.prev == null) {
                first = newNode;
            } else {
                node.prev.next = newNode;
            }
            node.prev = newNode;
            size++;
        }
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void set(int index, E value) {
        checkIndex(index);
        final Node node = node(index);
        node.item = value;
    }

    @Override
    public E remove(E value) {
        Node node = first;
        while (node != null) {
            if (node.item == value) {
                break;
            }
            node = node.next;
        }

        if (node == null) {
            return null;
        }

        if (node.prev == null) {
            first = node.next;
        } else {
            node.prev.next = node.next;
        }

        if (node.next == null) {
            last = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        size--;

        return node.item;
    }

    @Override
    public E remove(int index) {
        final Node node = node(index);
        if (node == null) {
            return null;
        }
        return remove(node.item);
    }

    @Override
    public int indexOf(E value) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.item == value) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        Node node = first;
        while (node != null) {
            builder.append(node.item);
            builder.append(" -> ");
            node = node.next;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        final DoubleLinkedList<String> list = new DoubleLinkedList<>();
        System.out.println(list);
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println(list);
        System.out.println(list.size);
    }
}
