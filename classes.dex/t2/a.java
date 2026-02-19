package t2;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import n2.d;
import n2.m;
import n2.r;
import n2.s;
import v2.b;
import v2.c;

final class a extends r {
    class t2.a.a implements s {
        t2.a.a() {
            super();
        }

        @Override  // n2.s
        public r a(d d0, u2.a a0) {
            return a0.c() == Date.class ? new a(null) : null;
        }
    }

    private final DateFormat a;
    static final s b;

    static {
        a.b = new t2.a.a();
    }

    private a() {
        this.a = new SimpleDateFormat("MMM d, yyyy");
    }

    a(t2.a.a a$a0) {
    }

    @Override  // n2.r
    public Object b(v2.a a0) {
        return this.e(a0);
    }

    @Override  // n2.r
    public void d(c c0, Object object0) {
        this.f(c0, ((Date)object0));
    }

    public Date e(v2.a a0) {
        java.util.Date date0;
        if(a0.E() == b.m) {
            a0.y();
            return null;
        }
        String s = a0.B();
        try {
            synchronized(this) {
                date0 = this.a.parse(s);
            }
            return new Date(date0.getTime());
        }
        catch(ParseException parseException0) {
            throw new m("Failed parsing \'" + s + "\' as SQL Date; at path " + a0.k(), parseException0);
        }
    }

    public void f(c c0, Date date0) {
        String s;
        if(date0 == null) {
            c0.n();
            return;
        }
        synchronized(this) {
            s = this.a.format(date0);
        }
        c0.G(s);
    }
}

