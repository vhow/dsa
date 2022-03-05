import java.util.Iterator;

public class App implements Iterable<String> {
    private final String[] items;
    private int size;

    public App(int capacity) {
        items = new String[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public void push(String item) {
        items[size++] = item;
    }

    public String pop() {
        return items[--size];
    }


    @Override
    public Iterator<String> iterator() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<String> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public String next() {
            return null;
        }
    }
}
