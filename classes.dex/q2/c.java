package q2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import n2.d;
import n2.m;
import n2.r;
import n2.s;
import v2.b;

public final class c extends r {
    class a implements s {
        a() {
            super();
        }

        @Override  // n2.s
        public r a(d d0, u2.a a0) {
            return a0.c() == Date.class ? new c() : null;
        }
    }

    private final List a;
    public static final s b;

    static {
        c.b = new a();
    }

    public c() {
        ArrayList arrayList0 = new ArrayList();
        this.a = arrayList0;
        Locale locale0 = Locale.US;
        arrayList0.add(DateFormat.getDateTimeInstance(2, 2, locale0));
        if(!Locale.getDefault().equals(locale0)) {
            arrayList0.add(DateFormat.getDateTimeInstance(2, 2));
        }
    }

    @Override  // n2.r
    public Object b(v2.a a0) {
        return this.f(a0);
    }

    @Override  // n2.r
    public void d(v2.c c0, Object object0) {
        this.g(c0, ((Date)object0));
    }

    private Date e(v2.a a0) {
        String s = a0.B();
        synchronized(this.a) {
            Iterator iterator0 = this.a.iterator();
        label_5:
            if(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                DateFormat dateFormat0 = (DateFormat)object0;
                try {
                    return dateFormat0.parse(s);
                }
                catch(ParseException unused_ex) {
                    goto label_5;
                }
            }
        }
        try {
            return r2.a.c(s, new ParsePosition(0));
        }
        catch(ParseException parseException0) {
            throw new m("Failed parsing \'" + s + "\' as Date; at path " + a0.k(), parseException0);
        }
    }

    public Date f(v2.a a0) {
        if(a0.E() == b.m) {
            a0.y();
            return null;
        }
        return this.e(a0);
    }

    public void g(v2.c c0, Date date0) {
        String s;
        if(date0 == null) {
            c0.n();
            return;
        }
        DateFormat dateFormat0 = (DateFormat)this.a.get(0);
        synchronized(this.a) {
            s = dateFormat0.format(date0);
        }
        c0.G(s);
    }
}

