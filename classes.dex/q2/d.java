package q2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import n2.r;
import n2.s;
import v2.c;

public final class d extends r {
    static abstract class a {
    }

    public static abstract class b {
        class q2.d.b.a extends b {
            q2.d.b.a(Class class0) {
            }

            @Override  // q2.d$b
            protected Date d(Date date0) {
                return date0;
            }
        }

        private final Class a;
        public static final b b;

        static {
            b.b = new q2.d.b.a(Date.class);
        }

        protected b(Class class0) {
            this.a = class0;
        }

        public final s a(int v, int v1) {
            return this.c(new d(this, v, v1, null));
        }

        public final s b(String s) {
            return this.c(new d(this, s, null));
        }

        private s c(d d0) {
            return m.b(this.a, d0);
        }

        protected abstract Date d(Date arg1);
    }

    private final b a;
    private final List b;

    private d(b d$b0, int v, int v1) {
        ArrayList arrayList0 = new ArrayList();
        this.b = arrayList0;
        Objects.requireNonNull(d$b0);
        this.a = d$b0;
        Locale locale0 = Locale.US;
        arrayList0.add(DateFormat.getDateTimeInstance(v, v1, locale0));
        if(!Locale.getDefault().equals(locale0)) {
            arrayList0.add(DateFormat.getDateTimeInstance(v, v1));
        }
    }

    d(b d$b0, int v, int v1, a d$a0) {
        this(d$b0, v, v1);
    }

    private d(b d$b0, String s) {
        ArrayList arrayList0 = new ArrayList();
        this.b = arrayList0;
        Objects.requireNonNull(d$b0);
        this.a = d$b0;
        Locale locale0 = Locale.US;
        arrayList0.add(new SimpleDateFormat(s, locale0));
        if(!Locale.getDefault().equals(locale0)) {
            arrayList0.add(new SimpleDateFormat(s));
        }
    }

    d(b d$b0, String s, a d$a0) {
        this(d$b0, s);
    }

    @Override  // n2.r
    public Object b(v2.a a0) {
        return this.f(a0);
    }

    @Override  // n2.r
    public void d(c c0, Object object0) {
        this.g(c0, ((Date)object0));
    }

    private Date e(v2.a a0) {
        String s = a0.B();
        synchronized(this.b) {
            Iterator iterator0 = this.b.iterator();
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
            throw new n2.m("Failed parsing \'" + s + "\' as Date; at path " + a0.k(), parseException0);
        }
    }

    public Date f(v2.a a0) {
        if(a0.E() == v2.b.m) {
            a0.y();
            return null;
        }
        Date date0 = this.e(a0);
        return this.a.d(date0);
    }

    public void g(c c0, Date date0) {
        String s;
        if(date0 == null) {
            c0.n();
            return;
        }
        DateFormat dateFormat0 = (DateFormat)this.b.get(0);
        synchronized(this.b) {
            s = dateFormat0.format(date0);
        }
        c0.G(s);
    }

    @Override
    public String toString() {
        String s;
        StringBuilder stringBuilder0;
        DateFormat dateFormat0 = (DateFormat)this.b.get(0);
        if(dateFormat0 instanceof SimpleDateFormat) {
            stringBuilder0 = new StringBuilder();
            stringBuilder0.append("DefaultDateTypeAdapter(");
            s = ((SimpleDateFormat)dateFormat0).toPattern();
        }
        else {
            stringBuilder0 = new StringBuilder();
            stringBuilder0.append("DefaultDateTypeAdapter(");
            s = dateFormat0.getClass().getSimpleName();
        }
        stringBuilder0.append(s);
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

