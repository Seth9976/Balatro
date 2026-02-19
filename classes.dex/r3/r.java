package r3;

import d3.b;
import j3.l;
import java.io.Closeable;
import k3.d;
import k3.g;

public abstract class r extends c implements Closeable {
    public static final class a extends b {
        private a() {
            static final class r3.r.a.a extends g implements l {
                public static final r3.r.a.a f;

                static {
                    r3.r.a.a.f = new r3.r.a.a();
                }

                r3.r.a.a() {
                    super(1);
                }

                @Override  // j3.l
                public Object c(Object object0) {
                    return this.d(((d3.e.b)object0));
                }

                // 去混淆评级： 低(20)
                public final r d(d3.e.b e$b0) {
                    return e$b0 instanceof r ? ((r)e$b0) : null;
                }
            }

            super(c.e, r3.r.a.a.f);
        }

        public a(d d0) {
        }
    }

    public static final a f;

    static {
        r.f = new a(null);
    }
}

