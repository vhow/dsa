package io.github.vhow.dsa.recursion;

import java.util.Arrays;

public final class Permute {
    private static void swap(int[] a, int i, int j) {
        final int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void dfs(int[] a, int start) {
        if (start == a.length) {
            System.out.println(Arrays.toString(a));
            return;
        }
        for (int i = start; i < a.length; i++) {
            swap(a, i, start);
            dfs(a, start + 1);
            swap(a, i, start);
        }
    }

    public static void permute(int[] a) {
        dfs(a, 0);
    }

    public static void main(String[] args) {
        final int[] a = {1, 2, 3};
        permute(a);
    }
}
