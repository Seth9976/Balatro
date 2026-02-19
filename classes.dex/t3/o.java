package t3;

import q3.k;

abstract class o {
    public static final int a(String s, int v, int v1, int v2) {
        return (int)m.c(s, ((long)v), ((long)v1), ((long)v2));
    }

    public static final long b(String s, long v, long v1, long v2) {
        String s1 = m.d(s);
        if(s1 == null) {
            return v;
        }
        Long long0 = k.a(s1);
        if(long0 == null) {
            throw new IllegalStateException(("System property \'" + s + "\' has unrecognized value \'" + s1 + '\'').toString());
        }
        long v3 = (long)long0;
        if(Long.compare(v1, v3) > 0 || v3 > v2) {
            throw new IllegalStateException(("System property \'" + s + "\' should be in range " + v1 + ".." + v2 + ", but is \'" + v3 + '\'').toString());
        }
        return v3;
    }

    public static final boolean c(String s, boolean z) {
        String s1 = m.d(s);
        return s1 == null ? z : Boolean.parseBoolean(s1);
    }

    public static int d(String s, int v, int v1, int v2, int v3, Object object0) {
        if((v3 & 4) != 0) {
            v1 = 1;
        }
        if((v3 & 8) != 0) {
            v2 = 0x7FFFFFFF;
        }
        return m.b(s, v, v1, v2);
    }

    public static long e(String s, long v, long v1, long v2, int v3, Object object0) {
        if((v3 & 4) != 0) {
            v1 = 1L;
        }
        if((v3 & 8) != 0) {
            v2 = 0x7FFFFFFFFFFFFFFFL;
        }
        return m.c(s, v, v1, v2);
    }
}

