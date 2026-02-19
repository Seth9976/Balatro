package t3;

abstract class n {
    private static final int a;

    static {
        n.a = Runtime.getRuntime().availableProcessors();
    }

    public static final int a() [...] // 潜在的解密器

    public static final String b(String s) {
        try {
            return System.getProperty(s);
        }
        catch(SecurityException unused_ex) {
            return null;
        }
    }
}

