package q3;

import k3.f;

abstract class l extends k {
    public static final boolean c(String s, int v, String s1, int v1, int v2, boolean z) {
        f.e(s, "<this>");
        f.e(s1, "other");
        return z ? s.regionMatches(true, v, s1, v1, v2) : s.regionMatches(v, s1, v1, v2);
    }

    public static final boolean d(String s, String s1, boolean z) {
        f.e(s, "<this>");
        f.e(s1, "prefix");
        return z ? l.c(s, 0, s1, 0, s1.length(), true) : s.startsWith(s1);
    }

    public static boolean e(String s, String s1, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        return l.d(s, s1, z);
    }
}

