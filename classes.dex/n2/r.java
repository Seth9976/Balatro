package n2;

import java.io.IOException;
import q2.f;
import v2.b;
import v2.c;

public abstract class r {
    public final r a() {
        class a extends r {
            final r a;

            @Override  // n2.r
            public Object b(v2.a a0) {
                if(a0.E() == b.m) {
                    a0.y();
                    return null;
                }
                return r.this.b(a0);
            }

            @Override  // n2.r
            public void d(c c0, Object object0) {
                if(object0 == null) {
                    c0.n();
                    return;
                }
                r.this.d(c0, object0);
            }
        }

        return new a(this);
    }

    public abstract Object b(v2.a arg1);

    public final g c(Object object0) {
        try {
            f f0 = new f();
            this.d(f0, object0);
            return f0.L();
        }
        catch(IOException iOException0) {
            throw new h(iOException0);
        }
    }

    public abstract void d(c arg1, Object arg2);
}

