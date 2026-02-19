package q1;

public final class t {
    private boolean a;
    private boolean b;
    private boolean c;

    t(s s0) {
        this.a = false;
        this.b = false;
        this.c = false;
    }

    public final t a(boolean z) {
        this.c = true;
        return this;
    }

    public final t b(boolean z) {
        this.a = true;
        return this;
    }

    public final t c(boolean z) {
        this.b = true;
        return this;
    }

    public final v d() {
        return new v(this, null);
    }
}

