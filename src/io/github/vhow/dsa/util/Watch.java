package io.github.vhow.dsa.util;

public class Watch {
    private final long start;

    public Watch() {
        this.start = System.currentTimeMillis();
    }

    public void stop() {
        final long duration = System.currentTimeMillis() - start;
        System.out.println("time cost: " + duration + "ms");
    }
}
