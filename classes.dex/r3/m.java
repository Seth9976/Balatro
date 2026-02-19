package r3;

public abstract class m extends c {
    private long f;
    private boolean g;

    // 去混淆评级： 低(20)
    private final long d(boolean z) {
        return z ? 0x100000000L : 1L;
    }

    protected long e() {
        return 0x7FFFFFFFFFFFFFFFL;
    }

    public final void f(boolean z) {
        this.f += this.d(z);
        if(!z) {
            this.g = true;
        }
    }

    public static void g(m m0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if((v & 1) != 0) {
            z = false;
        }
        m0.f(z);
    }

    public final boolean h() [...] // Inlined contents

    public final boolean i() [...] // Inlined contents
}

