package io.github.vhow.dsa.sort;

import io.github.vhow.dsa.util.Watch;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractSort {
    abstract <T extends Comparable<T>> void sort(T[] a);

    protected void test() {
        final ThreadLocalRandom random = ThreadLocalRandom.current();
        final int N = 10_000;
//        final int N = 10;
        final Integer[] a = new Integer[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(1_000);
        }
        final Watch watch = new Watch();
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("isSorted: " + isSorted(a));
        watch.stop();
    }

    protected final <T extends Comparable<T>> boolean less(T[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    protected final <T extends Comparable<T>> void swap(T[] a, int i, int j) {
        if (i == j) {
            return;
        }
        final T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    protected final <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a, i, i - 1)) {
                return false;
            }
        }
        return true;
    }
}
