package io.github.vhow.dsa.util;

public class Watch {
    private final long start;

    public Watch() {
        this.start = System.currentTimeMillis();
    }

    public void stop() {
        System.out.println("time: " + (System.currentTimeMillis() - start));
    }
}
