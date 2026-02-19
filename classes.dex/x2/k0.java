package x2;

public class k0 {
    private final String a;
    private final String b;
    static boolean c = false;
    static int d = 6;

    static {
    }

    private k0(String s) {
        this.a = "Singular";
        this.b = s;
    }

    // 去混淆评级： 低(30)
    public int a(String s) {
        return 0;
    }

    // 去混淆评级： 低(30)
    public int b(String s, Object[] arr_object) {
        return 0;
    }

    // 去混淆评级： 低(30)
    public int c(String s) {
        return 0;
    }

    // 去混淆评级： 低(30)
    public int d(String s, Throwable throwable0) {
        return 0;
    }

    // 去混淆评级： 低(30)
    public int e(String s, Object[] arr_object) {
        return 0;
    }

    public static k0 f(String s) {
        return new k0(s);
    }

    // 去混淆评级： 低(40)
    public static String g() [...] // 潜在的解密器

    // 去混淆评级： 低(30)
    public int h(String s) {
        return 0;
    }

    // 去混淆评级： 低(20)
    public boolean i() {
        return false;
    }

    protected boolean j(int v) [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    String k(String s) {
        return String.format("%s [%s] - %s", this.b, "jeb-dexdec-sb-st-485", s);
    }
}

