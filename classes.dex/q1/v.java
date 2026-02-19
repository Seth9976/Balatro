package q1;

public final class v {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    public static final v d;

    static {
        v.d = new v(new t(null));
    }

    private v(t t0) {
        this.a = t0.a;
        this.b = t0.b;
        this.c = t0.c;
    }

    v(t t0, u u0) {
        this(t0);
    }

    public static t a() {
        return new t(null);
    }

    public final boolean b() {
        return this.c;
    }

    public final boolean c() {
        return this.a;
    }

    public final boolean d() {
        return this.b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return v.class == class0 && this.a == ((v)object0).a && this.b == ((v)object0).b && this.c == ((v)object0).c;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return (this.a * 0x1F + this.b) * 0x1F + this.c;
    }
}

