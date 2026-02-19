package k;

abstract class c {
    static final int[] a;
    static final long[] b;
    static final Object[] c;

    static {
        c.a = new int[0];
        c.b = new long[0];
        c.c = new Object[0];
    }

    static int a(int[] arr_v, int v, int v1) {
        int v2 = v - 1;
        int v3 = 0;
        while(v3 <= v2) {
            int v4 = v3 + v2 >>> 1;
            int v5 = arr_v[v4];
            if(v5 < v1) {
                v3 = v4 + 1;
                continue;
            }
            if(v5 > v1) {
                v2 = v4 - 1;
                continue;
            }
            return v4;
        }
        return ~v3;
    }

    static int b(long[] arr_v, int v, long v1) {
        int v2 = v - 1;
        int v3 = 0;
        while(v3 <= v2) {
            int v4 = v3 + v2 >>> 1;
            int v5 = Long.compare(arr_v[v4], v1);
            if(v5 < 0) {
                v3 = v4 + 1;
                continue;
            }
            if(v5 > 0) {
                v2 = v4 - 1;
                continue;
            }
            return v4;
        }
        return ~v3;
    }

    // 去混淆评级： 低(20)
    public static boolean c(Object object0, Object object1) {
        return object0 == object1 || object0 != null && object0.equals(object1);
    }

    public static int d(int v) {
        for(int v1 = 4; v1 < 0x20; ++v1) {
            int v2 = (1 << v1) - 12;
            if(v <= v2) {
                return v2;
            }
        }
        return v;
    }

    public static int e(int v) {
        return c.d(v * 4) / 4;
    }

    public static int f(int v) {
        return c.d(v * 8) / 8;
    }
}

