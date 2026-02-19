package d3;

import j3.p;
import java.io.Serializable;
import k3.f;
import k3.g;

public final class c implements e, Serializable {
    private final e e;
    private final b f;

    public c(e e0, b e$b0) {
        f.e(e0, "left");
        f.e(e$b0, "element");
        super();
        this.e = e0;
        this.f = e$b0;
    }

    private final boolean a(b e$b0) {
        return f.a(this.get(e$b0.getKey()), e$b0);
    }

    private final boolean b(c c0) {
        e e0;
        while(true) {
            if(!this.a(c0.f)) {
                return false;
            }
            e0 = c0.e;
            if(!(e0 instanceof c)) {
                break;
            }
            c0 = (c)e0;
        }
        f.c(e0, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        return this.a(((b)e0));
    }

    private final int c() {
        int v = 2;
        c c0 = this;
        while(true) {
            c0 = c0.e instanceof c ? ((c)c0.e) : null;
            if(c0 == null) {
                break;
            }
            ++v;
        }
        return v;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return this == object0 || object0 instanceof c && ((c)object0).c() == this.c() && ((c)object0).b(this);
    }

    @Override  // d3.e
    public Object fold(Object object0, p p0) {
        f.e(p0, "operation");
        return p0.b(this.e.fold(object0, p0), this.f);
    }

    @Override  // d3.e
    public b get(d3.e.c e$c0) {
        e e0;
        f.e(e$c0, "key");
        for(c c0 = this; true; c0 = (c)e0) {
            b e$b0 = c0.f.get(e$c0);
            if(e$b0 != null) {
                return e$b0;
            }
            e0 = c0.e;
            if(!(e0 instanceof c)) {
                break;
            }
        }
        return e0.get(e$c0);
    }

    @Override
    public int hashCode() {
        return this.e.hashCode() + this.f.hashCode();
    }

    @Override  // d3.e
    public e minusKey(d3.e.c e$c0) {
        f.e(e$c0, "key");
        if(this.f.get(e$c0) != null) {
            return this.e;
        }
        e e0 = this.e.minusKey(e$c0);
        if(e0 == this.e) {
            return this;
        }
        return e0 == d3.f.e ? this.f : new c(e0, this.f);
    }

    @Override
    public String toString() {
        static final class a extends g implements p {
            public static final a f;

            static {
                a.f = new a();
            }

            a() {
                super(2);
            }

            @Override  // j3.p
            public Object b(Object object0, Object object1) {
                return this.d(((String)object0), ((b)object1));
            }

            public final String d(String s, b e$b0) {
                f.e(s, "acc");
                f.e(e$b0, "element");
                return s.length() == 0 ? s + ", " + e$b0 : e$b0.toString();
            }
        }

        return '[' + ((String)this.fold("", a.f)) + ']';
    }
}

