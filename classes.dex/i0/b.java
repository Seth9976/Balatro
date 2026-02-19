package i0;

import j2.c;
import j2.d;
import j2.e;
import java.util.List;
import k2.a;

public final class b implements a {
    static final class i0.b.a implements d {
        static final i0.b.a a;
        private static final c b;
        private static final c c;
        private static final c d;
        private static final c e;
        private static final c f;
        private static final c g;
        private static final c h;
        private static final c i;
        private static final c j;
        private static final c k;
        private static final c l;
        private static final c m;

        static {
            i0.b.a.a = new i0.b.a();
            i0.b.a.b = c.d("sdkVersion");
            i0.b.a.c = c.d("model");
            i0.b.a.d = c.d("hardware");
            i0.b.a.e = c.d("device");
            i0.b.a.f = c.d("product");
            i0.b.a.g = c.d("osBuild");
            i0.b.a.h = c.d("manufacturer");
            i0.b.a.i = c.d("fingerprint");
            i0.b.a.j = c.d("locale");
            i0.b.a.k = c.d("country");
            i0.b.a.l = c.d("mccMnc");
            i0.b.a.m = c.d("applicationBuild");
        }

        @Override  // j2.d
        public void a(Object object0, Object object1) {
            this.b(((i0.a)object0), ((e)object1));
        }

        public void b(i0.a a0, e e0) {
            Integer integer0 = a0.m();
            e0.c(i0.b.a.b, integer0);
            String s = a0.j();
            e0.c(i0.b.a.c, s);
            String s1 = a0.f();
            e0.c(i0.b.a.d, s1);
            String s2 = a0.d();
            e0.c(i0.b.a.e, s2);
            String s3 = a0.l();
            e0.c(i0.b.a.f, s3);
            String s4 = a0.k();
            e0.c(i0.b.a.g, s4);
            String s5 = a0.h();
            e0.c(i0.b.a.h, s5);
            String s6 = a0.e();
            e0.c(i0.b.a.i, s6);
            String s7 = a0.g();
            e0.c(i0.b.a.j, s7);
            String s8 = a0.c();
            e0.c(i0.b.a.k, s8);
            String s9 = a0.i();
            e0.c(i0.b.a.l, s9);
            String s10 = a0.b();
            e0.c(i0.b.a.m, s10);
        }
    }

    static final class i0.b.b implements d {
        static final i0.b.b a;
        private static final c b;

        static {
            i0.b.b.a = new i0.b.b();
            i0.b.b.b = c.d("logRequest");
        }

        // 检测为 Lambda 实现
        @Override  // j2.d
        public void a(Object object0, Object object1) [...]

        public void b(j j0, e e0) {
            List list0 = j0.c();
            e0.c(i0.b.b.b, list0);
        }
    }

    static final class i0.b.c implements d {
        static final i0.b.c a;
        private static final c b;
        private static final c c;

        static {
            i0.b.c.a = new i0.b.c();
            i0.b.c.b = c.d("clientType");
            i0.b.c.c = c.d("androidClientInfo");
        }

        // 检测为 Lambda 实现
        @Override  // j2.d
        public void a(Object object0, Object object1) [...]

        public void b(k k0, e e0) {
            i0.k.b k$b0 = k0.c();
            e0.c(i0.b.c.b, k$b0);
            i0.a a0 = k0.b();
            e0.c(i0.b.c.c, a0);
        }
    }

    static final class i0.b.d implements d {
        static final i0.b.d a;
        private static final c b;
        private static final c c;
        private static final c d;
        private static final c e;
        private static final c f;
        private static final c g;
        private static final c h;

        static {
            i0.b.d.a = new i0.b.d();
            i0.b.d.b = c.d("eventTimeMs");
            i0.b.d.c = c.d("eventCode");
            i0.b.d.d = c.d("eventUptimeMs");
            i0.b.d.e = c.d("sourceExtension");
            i0.b.d.f = c.d("sourceExtensionJsonProto3");
            i0.b.d.g = c.d("timezoneOffsetSeconds");
            i0.b.d.h = c.d("networkConnectionInfo");
        }

        @Override  // j2.d
        public void a(Object object0, Object object1) {
            this.b(((l)object0), ((e)object1));
        }

        public void b(l l0, e e0) {
            long v = l0.c();
            e0.d(i0.b.d.b, v);
            Integer integer0 = l0.b();
            e0.c(i0.b.d.c, integer0);
            long v1 = l0.d();
            e0.d(i0.b.d.d, v1);
            byte[] arr_b = l0.f();
            e0.c(i0.b.d.e, arr_b);
            String s = l0.g();
            e0.c(i0.b.d.f, s);
            long v2 = l0.h();
            e0.d(i0.b.d.g, v2);
            o o0 = l0.e();
            e0.c(i0.b.d.h, o0);
        }
    }

    static final class i0.b.e implements d {
        static final i0.b.e a;
        private static final c b;
        private static final c c;
        private static final c d;
        private static final c e;
        private static final c f;
        private static final c g;
        private static final c h;

        static {
            i0.b.e.a = new i0.b.e();
            i0.b.e.b = c.d("requestTimeMs");
            i0.b.e.c = c.d("requestUptimeMs");
            i0.b.e.d = c.d("clientInfo");
            i0.b.e.e = c.d("logSource");
            i0.b.e.f = c.d("logSourceName");
            i0.b.e.g = c.d("logEvent");
            i0.b.e.h = c.d("qosTier");
        }

        @Override  // j2.d
        public void a(Object object0, Object object1) {
            this.b(((m)object0), ((e)object1));
        }

        public void b(m m0, e e0) {
            long v = m0.g();
            e0.d(i0.b.e.b, v);
            long v1 = m0.h();
            e0.d(i0.b.e.c, v1);
            k k0 = m0.b();
            e0.c(i0.b.e.d, k0);
            Integer integer0 = m0.d();
            e0.c(i0.b.e.e, integer0);
            String s = m0.e();
            e0.c(i0.b.e.f, s);
            List list0 = m0.c();
            e0.c(i0.b.e.g, list0);
            p p0 = m0.f();
            e0.c(i0.b.e.h, p0);
        }
    }

    static final class f implements d {
        static final f a;
        private static final c b;
        private static final c c;

        static {
            f.a = new f();
            f.b = c.d("networkType");
            f.c = c.d("mobileSubtype");
        }

        // 检测为 Lambda 实现
        @Override  // j2.d
        public void a(Object object0, Object object1) [...]

        public void b(o o0, e e0) {
            i0.o.c o$c0 = o0.c();
            e0.c(f.b, o$c0);
            i0.o.b o$b0 = o0.b();
            e0.c(f.c, o$b0);
        }
    }

    public static final a a;

    static {
        b.a = new b();
    }

    @Override  // k2.a
    public void a(k2.b b0) {
        b0.a(j.class, (Object object0, Object object1) -> this.b(((j)object0), ((e)object1)));
        b0.a(i0.d.class, (Object object0, Object object1) -> this.b(((j)object0), ((e)object1)));
        b0.a(m.class, i0.b.e.a);
        b0.a(g.class, i0.b.e.a);
        b0.a(k.class, (Object object0, Object object1) -> this.b(((k)object0), ((e)object1)));
        b0.a(i0.e.class, (Object object0, Object object1) -> this.b(((k)object0), ((e)object1)));
        b0.a(i0.a.class, i0.b.a.a);
        b0.a(i0.c.class, i0.b.a.a);
        b0.a(l.class, i0.b.d.a);
        b0.a(i0.f.class, i0.b.d.a);
        b0.a(o.class, (Object object0, Object object1) -> this.b(((o)object0), ((e)object1)));
        b0.a(i.class, (Object object0, Object object1) -> this.b(((o)object0), ((e)object1)));
    }
}

