package e3;

public abstract class c {
    private static final int a(int v, int v1, int v2) {
        return c.c(c.c(v, v2) - c.c(v1, v2), v2);
    }

    public static final int b(int v, int v1, int v2) {
        if(v2 > 0) {
            return v >= v1 ? v1 : v1 - c.a(v1, v, v2);
        }
        if(v2 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        }
        return v <= v1 ? v1 : v1 + c.a(v, v1, -v2);
    }

    private static final int c(int v, int v1) {
        int v2 = v % v1;
        return v2 >= 0 ? v2 : v2 + v1;
    }
}

