package j0;

import j2.c;
import j2.d;
import j2.e;

public final class a implements k2.a {
    static final class j0.a.a implements d {
        static final j0.a.a a;
        private static final c b;
        private static final c c;
        private static final c d;
        private static final c e;

        static {
            j0.a.a.a = new j0.a.a();
            j0.a.a.b = c.a("window").b(m2.a.b().c(1).a()).a();
            j0.a.a.c = c.a("logSourceMetrics").b(m2.a.b().c(2).a()).a();
            j0.a.a.d = c.a("globalMetrics").b(m2.a.b().c(3).a()).a();
            j0.a.a.e = c.a("appNamespace").b(m2.a.b().c(4).a()).a();
        }

        @Override  // j2.d
        public void a(Object object0, Object object1) {
            this.b(((m0.a)object0), ((e)object1));
        }

        public void b(m0.a a0, e e0) {
            e0.c(j0.a.a.b, a0.d());
            e0.c(j0.a.a.c, a0.c());
            e0.c(j0.a.a.d, a0.b());
            e0.c(j0.a.a.e, a0.a());
        }
    }

    static final class b implements d {
        static final b a;
        private static final c b;

        static {
            b.a = new b();
            b.b = c.a("storageMetrics").b(m2.a.b().c(1).a()).a();
        }

        // 检测为 Lambda 实现
        @Override  // j2.d
        public void a(Object object0, Object object1) [...]

        public void b(m0.b b0, e e0) {
            m0.e e1 = b0.a();
            e0.c(b.b, e1);
        }
    }

    static final class j0.a.c implements d {
        static final j0.a.c a;
        private static final c b;
        private static final c c;

        static {
            j0.a.c.a = new j0.a.c();
            j0.a.c.b = c.a("eventsDroppedCount").b(m2.a.b().c(1).a()).a();
            j0.a.c.c = c.a("reason").b(m2.a.b().c(3).a()).a();
        }

        // 检测为 Lambda 实现
        @Override  // j2.d
        public void a(Object object0, Object object1) [...]

        public void b(m0.c c0, e e0) {
            e0.d(j0.a.c.b, c0.a());
            e0.c(j0.a.c.c, c0.b());
        }
    }

    static final class j0.a.d implements d {
        static final j0.a.d a;
        private static final c b;
        private static final c c;

        static {
            j0.a.d.a = new j0.a.d();
            j0.a.d.b = c.a("logSource").b(m2.a.b().c(1).a()).a();
            j0.a.d.c = c.a("logEventDropped").b(m2.a.b().c(2).a()).a();
        }

        // 检测为 Lambda 实现
        @Override  // j2.d
        public void a(Object object0, Object object1) [...]

        public void b(m0.d d0, e e0) {
            e0.c(j0.a.d.b, d0.b());
            e0.c(j0.a.d.c, d0.a());
        }
    }

    static final class j0.a.e implements d {
        static final j0.a.e a;
        private static final c b;

        static {
            j0.a.e.a = new j0.a.e();
            j0.a.e.b = c.d("clientMetrics");
        }

        @Override  // j2.d
        public void a(Object object0, Object object1) {
            h.d.a(object0);
            this.b(null, ((e)object1));
        }

        public void b(l l0, e e0) {
            throw null;
        }
    }

    static final class f implements d {
        static final f a;
        private static final c b;
        private static final c c;

        static {
            f.a = new f();
            f.b = c.a("currentCacheSizeBytes").b(m2.a.b().c(1).a()).a();
            f.c = c.a("maxCacheSizeBytes").b(m2.a.b().c(2).a()).a();
        }

        // 检测为 Lambda 实现
        @Override  // j2.d
        public void a(Object object0, Object object1) [...]

        public void b(m0.e e0, e e1) {
            e1.d(f.b, e0.a());
            e1.d(f.c, e0.b());
        }
    }

    static final class g implements d {
        static final g a;
        private static final c b;
        private static final c c;

        static {
            g.a = new g();
            g.b = c.a("startMs").b(m2.a.b().c(1).a()).a();
            g.c = c.a("endMs").b(m2.a.b().c(2).a()).a();
        }

        // 检测为 Lambda 实现
        @Override  // j2.d
        public void a(Object object0, Object object1) [...]

        public void b(m0.f f0, e e0) {
            e0.d(g.b, f0.b());
            e0.d(g.c, f0.a());
        }
    }

    public static final k2.a a;

    static {
        a.a = new a();
    }

    @Override  // k2.a
    public void a(k2.b b0) {
        b0.a(l.class, j0.a.e.a);
        b0.a(m0.a.class, j0.a.a.a);
        b0.a(m0.f.class, (Object object0, Object object1) -> this.b(((m0.f)object0), ((e)object1)));
        b0.a(m0.d.class, (Object object0, Object object1) -> this.b(((m0.d)object0), ((e)object1)));
        b0.a(m0.c.class, (Object object0, Object object1) -> this.b(((m0.c)object0), ((e)object1)));
        b0.a(m0.b.class, (Object object0, Object object1) -> this.b(((m0.b)object0), ((e)object1)));
        b0.a(m0.e.class, (Object object0, Object object1) -> this.b(((m0.e)object0), ((e)object1)));
    }
}

