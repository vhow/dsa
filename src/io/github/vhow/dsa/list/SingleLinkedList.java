package io.github.vhow.dsa.list;

public class SingleLinkedList<E> implements IList<E> {

    private int size;

    private Node<E> first;

    private Node<E> last;

    public static void main(String[] args) {
        final SingleLinkedList<String> list = new SingleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println(list);
        System.out.println(list.size());
        String x = "5";
        System.out.println(list.contains(x));
        String remove = list.remove(x);
        System.out.println("removed: " + remove);
        System.out.println(list);
        list.add(0, "x");
        System.out.println(list);
    }

    @Override

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        Node<E> node = first;
        for (int i = 1; i <= index; i++) {
            node = node.next;
        }

        return node.getItem();
    }

    @Override
    public void add(E value) {
        final Node<E> node = new Node<>(value, null);
        if (last == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (Node<E> node = first; node != null; node = node.next) {
            builder.append(node.getItem());
            builder.append(" -> ");
        }
        builder.append(']');
        return builder.toString();
    }

    @Override
    public void add(int index, E value) {
        checkIndex(index);
        Node<E> next = first;
        Node<E> prev = null;
        for (int i = 0; i < index; i++) {
            prev = next;
            next = next.next;
        }
        Node<E> node = new Node<>(value, next);
        if (prev == null) {
            first = node;
        } else {
            prev.next = node;
        }
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
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
        Node<E> node = first;
        int i = 0;
        while (node != null) {
            if (i == index) {
                node.setItem(value);
                break;
            }
            node = node.next;
            i++;
        }
    }

    @Override
    public E remove(E value) {
        for (Node<E> node = first, prev = null; node != null; prev = node, node = node.next) {
            if (node.getItem().equals(value)) {
                if (prev == null) {
                    first = first.next;
                } else {
                    prev.next = node.next;
                }
                if (node == last) {
                    last = prev;
                }
                size--;
                return node.getItem();
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        Node<E> node = first;
        Node<E> prev = null;
        for (int i = 1; i <= index; i++) {
            prev = node;
            node = node.next;
        }

        if (prev == null) {
            first = first.next;
        } else {
            prev.next = node.next;
        }

        if (node == last) {
            last = prev;
        }

        size--;
        return node.getItem();
    }

    @Override
    public int indexOf(E value) {
        int index = 0;
        for (Node<E> node = first; node != null; node = node.next) {
            if (node.getItem().equals(value)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        Node<E> node = first;
        while (node != null) {
            if (node.getItem().equals(value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

}
