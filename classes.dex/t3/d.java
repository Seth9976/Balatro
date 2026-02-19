package t3;

public abstract class d {
    public static final void a(int v) {
        if(v < 1) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but got " + v).toString());
        }
    }
}

