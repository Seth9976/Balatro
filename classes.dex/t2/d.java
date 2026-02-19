package t2;

import java.sql.Timestamp;
import java.util.Date;
import n2.s;
import q2.d.b;

public abstract class d {
    class a extends b {
        a(Class class0) {
        }

        @Override  // q2.d$b
        protected Date d(Date date0) {
            return this.e(date0);
        }

        protected java.sql.Date e(Date date0) {
            return new java.sql.Date(date0.getTime());
        }
    }

    class t2.d.b extends b {
        t2.d.b(Class class0) {
        }

        @Override  // q2.d$b
        protected Date d(Date date0) {
            return this.e(date0);
        }

        protected Timestamp e(Date date0) {
            return new Timestamp(date0.getTime());
        }
    }

    public static final boolean a;
    public static final b b;
    public static final b c;
    public static final s d;
    public static final s e;
    public static final s f;

    static {
        d.a = true;
        d.b = new a(java.sql.Date.class);
        d.c = new t2.d.b(Timestamp.class);
        d.d = t2.a.b;
        d.e = t2.b.b;
        d.f = c.b;
    }
}

