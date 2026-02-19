package t2;

import java.sql.Timestamp;
import java.util.Date;
import n2.d;
import n2.r;
import n2.s;

class c extends r {
    class a implements s {
        a() {
            super();
        }

        @Override  // n2.s
        public r a(d d0, u2.a a0) {
            return a0.c() == Timestamp.class ? new c(d0.k(Date.class), null) : null;
        }
    }

    private final r a;
    static final s b;

    static {
        c.b = new a();
    }

    private c(r r0) {
        this.a = r0;
    }

    c(r r0, a c$a0) {
        this(r0);
    }

    @Override  // n2.r
    public Object b(v2.a a0) {
        return this.e(a0);
    }

    @Override  // n2.r
    public void d(v2.c c0, Object object0) {
        this.f(c0, ((Timestamp)object0));
    }

    public Timestamp e(v2.a a0) {
        Date date0 = (Date)this.a.b(a0);
        return date0 == null ? null : new Timestamp(date0.getTime());
    }

    public void f(v2.c c0, Timestamp timestamp0) {
        this.a.d(c0, timestamp0);
    }
}

