package org.love2d.android;

public class q extends Exception {
    public static enum a {
        WAIT_FOR_CLOSED,
        OPEN_SNAPSHOT;

        private static a[] c() [...] // Inlined contents
    }

    private final a e;

    public q(String s, Throwable throwable0, a q$a0) {
        super(s, throwable0);
        this.e = q$a0;
    }
}

