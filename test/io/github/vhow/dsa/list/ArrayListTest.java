package io.github.vhow.dsa.list;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class ArrayListTest {
    @Test
    public void size() throws Exception {
        final ArrayList<Integer> list = new ArrayList<>();

        assertEquals(0, list.size());

        list.add(1);
        assertEquals(1, list.size());

        list.remove(0);
        assertEquals(0, list.size());

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100, list.size());

        while (!list.isEmpty()) {
            list.remove(0);
        }
        assertEquals(0, list.size());
    }

    @Test
    public void isEmpty() throws Exception {
        final ArrayList<Integer> list = new ArrayList<>();
        assertTrue(list.isEmpty());

        list.add(1);
        assertFalse(list.isEmpty());

        Random random = new Random();
        for (int i = 0, size = random.nextInt(100); i < size; i++) {
            list.add(i);
        }

        while (!list.isEmpty()) {
            list.remove(0);
        }
        assertEquals(0, list.size());
    }

    @Test
    public void get() throws Exception {
        final ArrayList<Integer> list = new ArrayList<>();

        list.add(0);
        assertEquals(Integer.valueOf(0), list.get(0));

        list.add(1);
        assertEquals(Integer.valueOf(0), list.get(0));
        assertEquals(Integer.valueOf(1), list.get(1));

        list.remove(0);
        assertEquals(Integer.valueOf(1), list.get(0));

        list.remove(0);

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(Integer.valueOf(99), list.get(99));
    }

    @Test
    public void add() throws Exception {
        final ArrayList<Integer> list = new ArrayList<>();

        list.add(0);
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(0), list.get(0));

        list.remove(0);

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100, list.size());
        assertEquals(Integer.valueOf(99), list.get(99));
    }

    @Test
    public void add1() throws Exception {
        final ArrayList<String> list = new ArrayList<>();

        list.add(0, "a");
        assertEquals("a", list.get(0));

        list.add(0, "b");
        assertEquals("b", list.get(0));

        list.add(2, "c");
        assertEquals("c", list.get(2));
    }

    @Test
    public void clear() throws Exception {
        final ArrayList<String> list = new ArrayList<>();

        list.add("a");
        list.clear();
        assertEquals(0, list.size());

        list.add("b");
        assertEquals("b", list.get(0));

        list.add("c");
        assertEquals(2, list.size());
    }

    @Test
    public void set() throws Exception {
        final ArrayList<String> list = new ArrayList<>();
        list.add("a");

        list.set(0, "b");
        assertEquals("b", list.get(0));
        assertEquals(1, list.size());

        list.remove(0);

        for (int i = 0; i < 100; i++) {
           list.add(String.valueOf(i));
        }

        assertEquals("25", list.get(25));

        list.set(25, "x");
        assertEquals("x", list.get(25));
    }

    @Test
    public void remove() throws Exception {
        final ArrayList<String> list = new ArrayList<>();

        list.add("a");
        assertEquals(1, list.size());

        list.remove(0);
        assertEquals(0, list.size());

        list.add("a");
        list.add("b");
        assertEquals("a", list.get(0));

        list.remove(0);
        assertEquals("b", list.get(0));

        assertEquals("b", list.remove(0));

        assertEquals(0, list.size());

        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }
        assertEquals(100, list.size());

        assertEquals("99", list.remove(99));
        assertEquals(99, list.size());
    }

    @Test
    public void remove1() throws Exception {
        final ArrayList<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals("a", list.remove("a"));
        assertEquals(2, list.size());
        assertEquals("b", list.get(0));

        list.add("d");
        list.add("e");

        assertEquals("d", list.remove("d"));

        assertEquals("e", list.get(2));
    }

    @Test
    public void indexOf() throws Exception {
        final ArrayList<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals(0, list.indexOf("a"));
        assertEquals(1, list.indexOf("b"));

        assertEquals(-1, list.indexOf("d"));
    }

    @Test
    public void contains() throws Exception {
        final ArrayList<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        assertTrue(list.contains("a"));
        assertFalse(list.contains("d"));
    }

}