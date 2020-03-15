package io.github.vhow.dsa.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleLinkedListTest {

    @Test
    public void size() throws Exception {
        final IList<String> list = new SingleLinkedList<>();
        assertEquals(0, list.size());

        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
            assertEquals(i + 1, list.size());
        }

        list.remove(0);
        assertEquals(99, list.size());
    }

    @Test
    public void isEmpty() throws Exception {
        final IList<Integer> list = new SingleLinkedList<>();

        assertTrue(list.isEmpty());

        list.add(0);
        assertFalse(list.isEmpty());

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        while (!list.isEmpty()) {
            list.remove(0);
        }

        assertEquals(0, list.size());
    }

    @Test
    public void get() throws Exception {
        final IList<Integer> list = new SingleLinkedList<>();

        list.add(1);
        assertEquals(Integer.valueOf(1), list.get(0));

        list.add(2);

        assertEquals(Integer.valueOf(2), list.get(1));

        list.remove(0);
        assertEquals(Integer.valueOf(2), list.get(0));

        list.remove(0);

        for (int i = 0; i < 10; i++) {
            list.add(i);
            assertEquals(Integer.valueOf(i), list.get(list.size() - 1));
        }
    }

    @Test
    public void add() throws Exception {
        final IList<String> list = new SingleLinkedList<>();

        list.add("a");
        assertEquals(1, list.size());
        assertEquals("a", list.get(0));

        list.add("b");
        assertEquals(2, list.size());
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));

        while (!list.isEmpty()) {
            list.remove(0);
        }

        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }
        assertEquals(100, list.size());

        list.remove(0);
        assertEquals(99, list.size());
    }

    @Test
    public void add1() throws Exception {
        final IList<String> list = new SingleLinkedList<>();

        list.add(0, "a");
        assertEquals("a", list.get(0));

        list.add(0, "b");
        assertEquals("b", list.get(0));

        list.add(1, "x");
        assertEquals("x", list.get(1));

        list.add(3, "d");
        assertEquals(4, list.size());
        assertEquals("d", list.get(3));

    }

    @Test
    public void clear() throws Exception {
        final IList<Integer> list = new SingleLinkedList<>();
        list.add(0);
        assertEquals(1, list.size());

        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void set() throws Exception {
        final IList<String> list = new SingleLinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        list.set(0, "0");
        assertEquals("0", list.get(0));

        list.set(1, "1");
        assertEquals("1", list.get(1));

        list.set(2, "2");
        assertEquals("2", list.get(2));
    }

    @Test
    public void remove() throws Exception {
        final IList<String> list = new SingleLinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals("a", list.remove(0));
        assertEquals(2, list.size());

        list.add("d");
        assertEquals("c", list.remove(1));
        assertEquals("d", list.remove(1));
    }

    @Test
    public void remove1() throws Exception {
        final IList<String> list = new SingleLinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        assertTrue(list.contains("a"));

        list.remove("a");
        assertFalse(list.contains("a"));

        assertEquals("b", list.get(0));

        assertEquals("c", list.remove("c"));

        assertEquals(1, list.size());
    }

    @Test
    public void indexOf() throws Exception {
        final IList<String> list = new SingleLinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals(0, list.indexOf("a"));
        assertEquals(1, list.indexOf("b"));
        assertEquals(2, list.indexOf("c"));
        assertEquals(-1, list.indexOf("d"));
    }

    @Test
    public void contains() throws Exception {
        final IList<String> list = new SingleLinkedList<>();

        assertFalse(list.contains("a"));

        list.add("a");
        assertTrue(list.contains("a"));

        list.add("b");
        assertTrue(list.contains("b"));

        list.add("c");
        assertTrue(list.contains("c"));

        list.remove("c");
        assertFalse(list.contains("c"));
    }

}