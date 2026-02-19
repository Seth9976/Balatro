package q3;

import n3.c;

abstract class a {
    public static final int a(int v) {
        if(!new c(2, 36).q(v)) {
            throw new IllegalArgumentException("radix " + v + " was not in valid range " + new c(2, 36));
        }
        return v;
    }

    public static final int b(char c, int v) {
        return Character.digit(c, v);
    }

    // 去混淆评级： 低(20)
    public static final boolean c(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}

