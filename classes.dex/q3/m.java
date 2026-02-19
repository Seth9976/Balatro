package q3;

import c3.e;
import c3.v;
import k3.f;
import n3.a;
import n3.c;

abstract class m extends l {
    public static final int f(CharSequence charSequence0) {
        f.e(charSequence0, "<this>");
        return charSequence0.length() - 1;
    }

    public static final int g(CharSequence charSequence0, char c, int v, boolean z) {
        f.e(charSequence0, "<this>");
        return z || !(charSequence0 instanceof String) ? m.m(charSequence0, new char[]{c}, v, z) : ((String)charSequence0).indexOf(((int)c), v);
    }

    public static final int h(CharSequence charSequence0, String s, int v, boolean z) {
        f.e(charSequence0, "<this>");
        f.e(s, "string");
        return z || !(charSequence0 instanceof String) ? m.j(charSequence0, s, v, charSequence0.length(), z, false, 16, null) : ((String)charSequence0).indexOf(s, v);
    }

    private static final int i(CharSequence charSequence0, CharSequence charSequence1, int v, int v1, boolean z, boolean z1) {
        a a0 = z1 ? n3.f.d(n3.f.b(v, m.f(charSequence0)), n3.f.a(v1, 0)) : new c(n3.f.a(v, 0), n3.f.b(v1, charSequence0.length()));
        if(!(charSequence0 instanceof String) || !(charSequence1 instanceof String)) {
            int v5 = a0.e();
            int v6 = a0.n();
            int v7 = a0.o();
            if(v7 > 0 && v5 <= v6 || v7 < 0 && v6 <= v5) {
                while(true) {
                    if(m.q(charSequence1, 0, charSequence0, v5, charSequence1.length(), z)) {
                        return v5;
                    }
                    if(v5 == v6) {
                        break;
                    }
                    v5 += v7;
                }
            }
        }
        else {
            int v2 = a0.e();
            int v3 = a0.n();
            int v4 = a0.o();
            if(v4 > 0 && v2 <= v3 || v4 < 0 && v3 <= v2) {
                while(true) {
                    if(l.c(((String)charSequence1), 0, ((String)charSequence0), v2, charSequence1.length(), z)) {
                        return v2;
                    }
                    if(v2 == v3) {
                        break;
                    }
                    v2 += v4;
                }
            }
        }
        return -1;
    }

    static int j(CharSequence charSequence0, CharSequence charSequence1, int v, int v1, boolean z, boolean z1, int v2, Object object0) {
        if((v2 & 16) != 0) {
            z1 = false;
        }
        return m.i(charSequence0, charSequence1, v, v1, z, z1);
    }

    public static int k(CharSequence charSequence0, char c, int v, boolean z, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = 0;
        }
        if((v1 & 4) != 0) {
            z = false;
        }
        return m.g(charSequence0, c, v, z);
    }

    public static int l(CharSequence charSequence0, String s, int v, boolean z, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = 0;
        }
        if((v1 & 4) != 0) {
            z = false;
        }
        return m.h(charSequence0, s, v, z);
    }

    public static final int m(CharSequence charSequence0, char[] arr_c, int v, boolean z) {
        f.e(charSequence0, "<this>");
        f.e(arr_c, "chars");
        if(!z && arr_c.length == 1 && charSequence0 instanceof String) {
            return ((String)charSequence0).indexOf(e.d(arr_c), v);
        }
        v v1 = new c(n3.f.a(v, 0), m.f(charSequence0)).p();
        while(v1.hasNext()) {
            int v2 = v1.b();
            int v3 = charSequence0.charAt(v2);
            int v4 = 0;
            while(true) {
                boolean z1 = false;
                if(v4 < arr_c.length) {
                    if(b.d(arr_c[v4], ((char)v3), z)) {
                        z1 = true;
                    }
                    else {
                        ++v4;
                        continue;
                    }
                }
                break;
            }
            if(z1) {
                return v2;
            }
            if(false) {
                break;
            }
        }
        return -1;
    }

    public static final int n(CharSequence charSequence0, char c, int v, boolean z) {
        f.e(charSequence0, "<this>");
        return z || !(charSequence0 instanceof String) ? m.p(charSequence0, new char[]{c}, v, z) : ((String)charSequence0).lastIndexOf(((int)c), v);
    }

    public static int o(CharSequence charSequence0, char c, int v, boolean z, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = m.f(charSequence0);
        }
        if((v1 & 4) != 0) {
            z = false;
        }
        return m.n(charSequence0, c, v, z);
    }

    // This method was un-flattened
    public static final int p(CharSequence charSequence0, char[] arr_c, int v, boolean z) {
        f.e(charSequence0, "<this>");
        f.e(arr_c, "chars");
        if(!z && arr_c.length == 1 && charSequence0 instanceof String) {
            return ((String)charSequence0).lastIndexOf(e.d(arr_c), v);
        }
        int v1 = n3.f.b(v, m.f(charSequence0));
        while(-1 < v1) {
            int v2 = charSequence0.charAt(v1);
            int v3 = 0;
        label_8:
            if(v3 >= arr_c.length) {
                --v1;
                continue;
            }
            if(!b.d(arr_c[v3], ((char)v2), z)) {
                ++v3;
                goto label_8;
            }
            return v1;
        }
        return -1;
    }

    public static final boolean q(CharSequence charSequence0, int v, CharSequence charSequence1, int v1, int v2, boolean z) {
        f.e(charSequence0, "<this>");
        f.e(charSequence1, "other");
        if(v1 >= 0 && v >= 0 && v <= charSequence0.length() - v2 && v1 <= charSequence1.length() - v2) {
            for(int v3 = 0; v3 < v2; ++v3) {
                if(!b.d(charSequence0.charAt(v + v3), charSequence1.charAt(v1 + v3), z)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static final String r(String s, String s1, String s2) {
        f.e(s, "<this>");
        f.e(s1, "delimiter");
        f.e(s2, "missingDelimiterValue");
        int v = m.l(s, s1, 0, false, 6, null);
        if(v != -1) {
            s2 = s.substring(v + s1.length(), s.length());
            f.d(s2, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        return s2;
    }

    public static String s(String s, String s1, String s2, int v, Object object0) {
        if((v & 2) != 0) {
            s2 = s;
        }
        return m.r(s, s1, s2);
    }

    public static final String t(String s, char c, String s1) {
        f.e(s, "<this>");
        f.e(s1, "missingDelimiterValue");
        int v = m.o(s, c, 0, false, 6, null);
        if(v != -1) {
            s1 = s.substring(v + 1, s.length());
            f.d(s1, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        return s1;
    }

    public static String u(String s, char c, String s1, int v, Object object0) {
        if((v & 2) != 0) {
            s1 = s;
        }
        return m.t(s, c, s1);
    }

    public static final String v(String s, char c, String s1) {
        f.e(s, "<this>");
        f.e(s1, "missingDelimiterValue");
        int v = m.k(s, c, 0, false, 6, null);
        if(v != -1) {
            s1 = s.substring(0, v);
            f.d(s1, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        return s1;
    }

    public static final String w(String s, String s1, String s2) {
        f.e(s, "<this>");
        f.e(s1, "delimiter");
        f.e(s2, "missingDelimiterValue");
        int v = m.l(s, s1, 0, false, 6, null);
        if(v != -1) {
            s2 = s.substring(0, v);
            f.d(s2, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        return s2;
    }

    public static String x(String s, char c, String s1, int v, Object object0) {
        if((v & 2) != 0) {
            s1 = s;
        }
        return m.v(s, c, s1);
    }

    public static String y(String s, String s1, String s2, int v, Object object0) {
        if((v & 2) != 0) {
            s2 = s;
        }
        return m.w(s, s1, s2);
    }

    public static CharSequence z(CharSequence charSequence0) {
        f.e(charSequence0, "<this>");
        int v = charSequence0.length() - 1;
        int v1 = 0;
        boolean z = false;
        while(v1 <= v) {
            boolean z1 = q3.a.c(charSequence0.charAt((z ? v : v1)));
            if(z) {
                if(!z1) {
                    break;
                }
                --v;
            }
            else if(z1) {
                ++v1;
            }
            else {
                z = true;
            }
        }
        return charSequence0.subSequence(v1, v + 1);
    }
}

