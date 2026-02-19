package h2;

public abstract class c {
    private static String a(int v, int v1, String s) {
        if(v < 0) {
            return d.a("%s (%s) must not be negative", new Object[]{s, v});
        }
        if(v1 < 0) {
            throw new IllegalArgumentException("negative size: " + v1);
        }
        return d.a("%s (%s) must be less than size (%s)", new Object[]{s, v, v1});
    }

    private static String b(int v, int v1, String s) {
        if(v < 0) {
            return d.a("%s (%s) must not be negative", new Object[]{s, v});
        }
        if(v1 < 0) {
            throw new IllegalArgumentException("negative size: " + v1);
        }
        return d.a("%s (%s) must not be greater than size (%s)", new Object[]{s, v, v1});
    }

    private static String c(int v, int v1, int v2) {
        if(v >= 0 && v <= v2) {
            return v1 < 0 || v1 > v2 ? c.b(v1, v2, "end index") : d.a("end index (%s) must not be less than start index (%s)", new Object[]{v1, v});
        }
        return c.b(v, v2, "start index");
    }

    public static int d(int v, int v1) {
        return c.e(v, v1, "index");
    }

    public static int e(int v, int v1, String s) {
        if(v < 0 || v >= v1) {
            throw new IndexOutOfBoundsException(c.a(v, v1, s));
        }
        return v;
    }

    public static Object f(Object object0) {
        object0.getClass();
        return object0;
    }

    public static int g(int v, int v1) {
        return c.h(v, v1, "index");
    }

    public static int h(int v, int v1, String s) {
        if(v < 0 || v > v1) {
            throw new IndexOutOfBoundsException(c.b(v, v1, s));
        }
        return v;
    }

    public static void i(int v, int v1, int v2) {
        if(v < 0 || v1 < v || v1 > v2) {
            throw new IndexOutOfBoundsException(c.c(v, v1, v2));
        }
    }
}

