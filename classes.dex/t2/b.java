package t2;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import n2.d;
import n2.m;
import n2.r;
import n2.s;
import v2.c;

final class b extends r {
    class a implements s {
        a() {
            super();
        }

        @Override  // n2.s
        public r a(d d0, u2.a a0) {
            return a0.c() == Time.class ? new b(null) : null;
        }
    }

    private final DateFormat a;
    static final s b;

    static {
        b.b = new a();
    }

    private b() {
        this.a = new SimpleDateFormat("hh:mm:ss a");
    }

    b(a b$a0) {
    }

    @Override  // n2.r
    public Object b(v2.a a0) {
        return this.e(a0);
    }

    @Override  // n2.r
    public void d(c c0, Object object0) {
        this.f(c0, ((Time)object0));
    }

    public Time e(v2.a a0) {
        if(a0.E() == v2.b.m) {
            a0.y();
            return null;
        }
        String s = a0.B();
        try {
            return new Time(this.a.parse(s).getTime());
        }
        catch(Throwable throwable0) {
            try {
                throw throwable0;
            }
            catch(ParseException parseException0) {
                throw new m("Failed parsing \'" + s + "\' as SQL Time; at path " + a0.k(), parseException0);
            }
        }
    }

    public void f(c c0, Time time0) {
        String s;
        if(time0 == null) {
            c0.n();
            return;
        }
        synchronized(this) {
            s = this.a.format(time0);
        }
        c0.G(s);
    }
}

