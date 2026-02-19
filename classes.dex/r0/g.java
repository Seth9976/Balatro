package r0;

import l0.b;

public final class g implements b {
    static abstract class a {
        private static final g a;

        static {
            a.a = new g();
        }
    }

    public static g a() {
        return a.a;
    }

    // 去混淆评级： 低(20)
    public static String b() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public String c() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    @Override  // a3.a
    public Object get() {
        return "com.google.android.datatransport.events";
    }
}

