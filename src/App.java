import java.util.Iterator;

public class App implements Iterable<String> {
    private String[] items;
    private int n;

    public App(int capacity) {
        items = new String[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == items.length;
    }

    public void push(String item) {
        items[n++] = item;
    }

    public String pop() {
        return items[--n];
    }


    @Override
    public Iterator<String> iterator() {
        return null;
    }

    private class ReverseArrayIteraotr implements Iterator<String> {
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
