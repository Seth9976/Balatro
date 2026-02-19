package k0;

public abstract class g {
    public static enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR,
        INVALID_PAYLOAD;

    }

    public static g a() {
        return new b(a.g, -1L);
    }

    public abstract long b();

    public abstract a c();

    public static g d() {
        return new b(a.h, -1L);
    }

    public static g e(long v) {
        return new b(a.e, v);
    }

    public static g f() {
        return new b(a.f, -1L);
    }
}

