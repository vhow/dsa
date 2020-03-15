package io.github.vhow.dsa.list;

public class ArrayList<E> implements IList<E> {

    private Object[] data;

    private int size;

    public ArrayList() {
        data = new Object[10];
    }

    public static void main(String[] args) {
        final ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("i" + i);
        }
        System.out.println(list);
        System.out.println(list.indexOf("22"));
        list.set(2, "22");
        System.out.println(list);
        System.out.println(list.indexOf("22"));
        System.out.println(list.remove(8));
        System.out.println(list);
        System.out.println(list.remove("22"));
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
        checkIndex(index);
        return (E) data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", " + size);
        }
    }

    private void ensureCapacity() {
        if (data.length <= size + 2) {
            final Object[] newArr = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newArr[i] = data[i];
            }
            data = newArr;
        }
    }

    @Override
    public void add(E value) {
        ensureCapacity();
        data[size++] = value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            builder.append(", ");
        }
        builder.append(']');
        return builder.toString();
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        ensureCapacity();
        for (int i = size - 1; i > index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    @Override
    public void clear() {
        data = new Object[10];
        size = 0;
    }

    @Override
    public void set(int index, E value) {
        ensureCapacity();
        data[index] = value;
    }

    @Override
    public E remove(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return remove(i);
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        final E value = (E) data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return value;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) > -1;
    }
}
