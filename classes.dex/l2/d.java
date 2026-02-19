package l2;

import j2.e;
import j2.f;
import j2.g;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import k2.b;

public final class d implements b {
    static final class l2.d.b implements f {
        private static final DateFormat a;

        static {
            SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'", Locale.US);
            l2.d.b.a = simpleDateFormat0;
            simpleDateFormat0.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private l2.d.b() {
        }

        l2.d.b(a d$a0) {
        }

        @Override  // j2.f
        public void a(Object object0, Object object1) {
            this.b(((Date)object0), ((g)object1));
        }

        public void b(Date date0, g g0) {
            g0.a(l2.d.b.a.format(date0));
        }
    }

    private final Map a;
    private final Map b;
    private j2.d c;
    private boolean d;
    private static final j2.d e;
    private static final f f;
    private static final f g;
    private static final l2.d.b h;

    static {
        d.e = (Object object0, e e0) -> throw new j2.b("Couldn\'t find encoder for type " + object0.getClass().getCanonicalName());
        d.f = (String s, g g0) -> g0.a(s);
        d.g = (Boolean boolean0, g g0) -> g0.b(boolean0.booleanValue());
        d.h = new l2.d.b(null);
    }

    public d() {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = d.e;
        this.d = false;
        this.p(String.class, d.f);
        this.p(Boolean.class, d.g);
        this.p(Date.class, d.h);
    }

    @Override  // k2.b
    public b a(Class class0, j2.d d0) {
        return this.o(class0, d0);
    }

    public j2.a i() {
        class a implements j2.a {
            final d a;

            @Override  // j2.a
            public void a(Object object0, Writer writer0) {
                l2.e e0 = new l2.e(writer0, d.this.a, d.this.b, d.this.c, d.this.d);
                e0.f(object0, false);
                e0.m();
            }
        }

        return new a(this);
    }

    public d j(k2.a a0) {
        a0.a(this);
        return this;
    }

    public d k(boolean z) {
        this.d = z;
        return this;
    }

    // 检测为 Lambda 实现
    private static void l(Object object0, e e0) [...]

    // 检测为 Lambda 实现
    private static void m(String s, g g0) [...]

    // 检测为 Lambda 实现
    private static void n(Boolean boolean0, g g0) [...]

    public d o(Class class0, j2.d d0) {
        this.a.put(class0, d0);
        this.b.remove(class0);
        return this;
    }

    public d p(Class class0, f f0) {
        this.b.put(class0, f0);
        this.a.remove(class0);
        return this;
    }
}

