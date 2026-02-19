package z1;

import java.security.SecureRandom;

public abstract class b {
    private static final SecureRandom a;

    static {
        b.a = new SecureRandom();
    }

    public static String a() [...] // 潜在的解密器
}

