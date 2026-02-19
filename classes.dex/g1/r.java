package g1;

public final class r {
    private s a;
    private static r b;
    private static final s c;

    static {
        r.c = new s(0, false, false, 0, 0);
    }

    public s a() {
        return this.a;
    }

    public static r b() {
        synchronized(r.class) {
            if(r.b == null) {
                r.b = new r();
            }
            return r.b;
        }
    }

    public final void c(s s0) {
        synchronized(this) {
            if(s0 == null) {
                this.a = r.c;
                return;
            }
            if(this.a != null && this.a.n0() >= s0.n0()) {
                return;
            }
            this.a = s0;
        }
    }
}

