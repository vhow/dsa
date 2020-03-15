package io.github.vhow.dsa.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class LinkStackTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void size() throws Exception {
        final LinkStack<String> stack = new LinkStack<>();
        assertEquals(0, stack.size());

        stack.push("A");
        assertEquals(1, stack.size());

        stack.pop();
        assertEquals(0, stack.size());

        for (int i = 0; i < 1000; i++) {
            stack.push("i" + i);
        }
        assertEquals(1000, stack.size());

        stack.pop();
        assertEquals(999, stack.size());

        while (!stack.isEmpty()) {
            stack.pop();
        }
        assertEquals(0, stack.size());
    }

    @Test
    public void isEmpty() throws Exception {
        final LinkStack<Integer> stack = new LinkStack<>();
        assertTrue(stack.isEmpty());

        stack.push(1);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());

        for (int i = 0; i < 1000; i++) {
            stack.push(i);
        }
        assertFalse(stack.isEmpty());

        for (int i = 0; i < 1000; i++) {
            stack.pop();
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    public void top() throws Exception {
        final LinkStack<String> stack = new LinkStack<>();

        stack.push("A");
        assertEquals("A", stack.top());

        stack.push("B");
        assertEquals("B", stack.top());

        stack.pop();
        assertEquals("A", stack.top());

        final Random random = new Random();
        final int size = random.nextInt(100);
        for (int i = 0; i < size; i++) {
            String item = "i" + i;
            stack.push(item);
            assertEquals(item, stack.top());
        }
    }

    @Test
    public void push() throws Exception {
        final LinkStack<String> stack = new LinkStack<>();

        stack.push("A");
        assertEquals("A", stack.top());

        stack.pop();

        for (int i = 0; i < 100; i++) {
            stack.push(String.valueOf(Math.random()));
        }
        assertEquals(100, stack.size());

        while (!stack.isEmpty()) {
            stack.pop();
        }
        assertEquals(0, stack.size());
    }

    @Test
    public void pop() throws Exception {
        final LinkStack<String> stack = new LinkStack<>();

        stack.push("A");
        assertEquals("A", stack.pop());

        for (int i = 0; i < 100; i++) {
            stack.push("i" + i);
        }
        assertEquals(100, stack.size());
        stack.pop();
        assertEquals(99, stack.size());

        stack.push("B");
        assertEquals("B", stack.pop());

        while (!stack.isEmpty()) {
            stack.pop();
        }
        assertEquals(0, stack.size());
    }

}