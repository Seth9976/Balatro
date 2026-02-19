package c2;

public abstract class j1 {
    private static final g1 a;
    private static volatile g1 b;

    static {
        i1 i10 = new i1(null);
        j1.a = i10;
        j1.b = i10;
    }

    public static g1 a() {
        return j1.b;
    }
}

