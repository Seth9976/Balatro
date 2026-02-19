package androidx.core.os;

import java.util.Locale;

public abstract class a {
    // 去混淆评级： 低(20)
    protected static boolean a(String s, String s1) {
        return "REL".equals(s1) ? false : s1.toUpperCase(Locale.ROOT).compareTo(s.toUpperCase(Locale.ROOT)) >= 0;
    }

    public static boolean b() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public static boolean c() [...] // 潜在的解密器
}

