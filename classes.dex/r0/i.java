package r0;

import l0.b;

public final class i implements b {
    static abstract class a {
        private static final i a;

        static {
            a.a = new i();
        }
    }

    public static i a() {
        return a.a;
    }

    // 去混淆评级： 低(20)
    public Integer b() {
        return 5;
    }

    // 去混淆评级： 低(20)
    public static int c() [...] // 潜在的解密器

    @Override  // a3.a
    public Object get() {
        return this.b();
    }
}

