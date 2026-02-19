package r3;

import d3.a;
import d3.b;
import d3.d;
import d3.e;
import j3.l;
import k3.g;

public abstract class c extends a implements d {
    public static final class r3.c.a extends b {
        private r3.c.a() {
            static final class r3.c.a.a extends g implements l {
                public static final r3.c.a.a f;

                static {
                    r3.c.a.a.f = new r3.c.a.a();
                }

                r3.c.a.a() {
                    super(1);
                }

                @Override  // j3.l
                public Object c(Object object0) {
                    return this.d(((d3.e.b)object0));
                }

                // 去混淆评级： 低(20)
                public final c d(d3.e.b e$b0) {
                    return e$b0 instanceof c ? ((c)e$b0) : null;
                }
            }

            super(d.b, r3.c.a.a.f);
        }

        public r3.c.a(k3.d d0) {
        }
    }

    public static final r3.c.a e;

    static {
        c.e = new r3.c.a(null);
    }

    public c() {
        super(d.b);
    }

    public abstract void a(e arg1, Runnable arg2);

    public boolean b(e e0) {
        return true;
    }

    public c c(int v) {
        t3.d.a(v);
        return new t3.c(this, v);
    }

    @Override  // d3.a, d3.e$b
    public d3.e.b get(d3.e.c e$c0) {
        return d3.d.a.a(this, e$c0);
    }

    @Override  // d3.a, d3.e
    public e minusKey(d3.e.c e$c0) {
        return d3.d.a.b(this, e$c0);
    }

    @Override
    public String toString() {
        return r3.g.a(this) + '@' + r3.g.b(this);
    }
}

