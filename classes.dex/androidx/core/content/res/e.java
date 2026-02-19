package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public abstract class e {
    static abstract class a {
        static int a(TypedArray typedArray0, int v) {
            return typedArray0.getType(v);
        }
    }

    public interface b {
    }

    public static final class c implements b {
        private final d[] a;

        public c(d[] arr_e$d) {
            this.a = arr_e$d;
        }

        public d[] a() {
            return this.a;
        }
    }

    public static final class d {
        private final String a;
        private final int b;
        private final boolean c;
        private final String d;
        private final int e;
        private final int f;

        public d(String s, int v, boolean z, String s1, int v1, int v2) {
            this.a = s;
            this.b = v;
            this.c = z;
            this.d = s1;
            this.e = v1;
            this.f = v2;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.f;
        }

        public int c() {
            return this.e;
        }

        public String d() {
            return this.d;
        }

        public int e() {
            return this.b;
        }

        public boolean f() {
            return this.c;
        }
    }

    public static final class androidx.core.content.res.e.e implements b {
        private final androidx.core.provider.e a;
        private final int b;
        private final int c;
        private final String d;

        public androidx.core.content.res.e.e(androidx.core.provider.e e0, int v, int v1, String s) {
            this.a = e0;
            this.c = v;
            this.b = v1;
            this.d = s;
        }

        public int a() {
            return this.c;
        }

        public androidx.core.provider.e b() {
            return this.a;
        }

        public String c() {
            return this.d;
        }

        public int d() {
            return this.b;
        }
    }

    private static int a(TypedArray typedArray0, int v) {
        return a.a(typedArray0, v);
    }

    public static b b(XmlPullParser xmlPullParser0, Resources resources0) {
        do {
            int v = xmlPullParser0.next();
        }
        while(v != 1 && v != 2);
        if(v != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return e.d(xmlPullParser0, resources0);
    }

    public static List c(Resources resources0, int v) {
        if(v == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArray0 = resources0.obtainTypedArray(v);
        try {
            if(typedArray0.length() == 0) {
                return Collections.emptyList();
            }
            List list1 = new ArrayList();
            if(e.a(typedArray0, 0) == 1) {
                for(int v2 = 0; v2 < typedArray0.length(); ++v2) {
                    int v3 = typedArray0.getResourceId(v2, 0);
                    if(v3 != 0) {
                        list1.add(e.h(resources0.getStringArray(v3)));
                    }
                }
            }
            else {
                list1.add(e.h(resources0.getStringArray(v)));
            }
            return list1;
        }
        finally {
            typedArray0.recycle();
        }
    }

    private static b d(XmlPullParser xmlPullParser0, Resources resources0) {
        xmlPullParser0.require(2, null, "font-family");
        if(xmlPullParser0.getName().equals("font-family")) {
            return e.e(xmlPullParser0, resources0);
        }
        e.g(xmlPullParser0);
        return null;
    }

    private static b e(XmlPullParser xmlPullParser0, Resources resources0) {
        TypedArray typedArray0 = resources0.obtainAttributes(Xml.asAttributeSet(xmlPullParser0), l.c.h);
        String s = typedArray0.getString(l.c.i);
        String s1 = typedArray0.getString(l.c.m);
        String s2 = typedArray0.getString(l.c.n);
        int v = typedArray0.getResourceId(l.c.j, 0);
        int v1 = typedArray0.getInteger(l.c.k, 1);
        int v2 = typedArray0.getInteger(l.c.l, 500);
        String s3 = typedArray0.getString(l.c.o);
        typedArray0.recycle();
        if(s != null && s1 != null && s2 != null) {
            while(xmlPullParser0.next() != 3) {
                e.g(xmlPullParser0);
            }
            return new androidx.core.content.res.e.e(new androidx.core.provider.e(s, s1, s2, e.c(resources0, v)), v1, v2, s3);
        }
        ArrayList arrayList0 = new ArrayList();
        while(xmlPullParser0.next() != 3) {
            if(xmlPullParser0.getEventType() != 2) {
            }
            else if(xmlPullParser0.getName().equals("font")) {
                arrayList0.add(e.f(xmlPullParser0, resources0));
            }
            else {
                e.g(xmlPullParser0);
            }
        }
        return arrayList0.isEmpty() ? null : new c(((d[])arrayList0.toArray(new d[0])));
    }

    private static d f(XmlPullParser xmlPullParser0, Resources resources0) {
        TypedArray typedArray0 = resources0.obtainAttributes(Xml.asAttributeSet(xmlPullParser0), l.c.p);
        int v = typedArray0.getInt((typedArray0.hasValue(l.c.y) ? l.c.y : l.c.r), 400);
        boolean z = 1 == typedArray0.getInt((typedArray0.hasValue(l.c.w) ? l.c.w : l.c.s), 0);
        int v1 = typedArray0.hasValue(l.c.z) ? l.c.z : l.c.t;
        String s = typedArray0.getString((typedArray0.hasValue(l.c.x) ? l.c.x : l.c.u));
        int v2 = typedArray0.getInt(v1, 0);
        int v3 = typedArray0.hasValue(l.c.v) ? l.c.v : l.c.q;
        int v4 = typedArray0.getResourceId(v3, 0);
        String s1 = typedArray0.getString(v3);
        typedArray0.recycle();
        while(xmlPullParser0.next() != 3) {
            e.g(xmlPullParser0);
        }
        return new d(s1, v, z, s, v2, v4);
    }

    private static void g(XmlPullParser xmlPullParser0) {
        int v = 1;
        while(v > 0) {
            switch(xmlPullParser0.next()) {
                case 2: {
                    ++v;
                    break;
                }
                case 3: {
                    --v;
                }
            }
        }
    }

    private static List h(String[] arr_s) {
        List list0 = new ArrayList();
        for(int v = 0; v < arr_s.length; ++v) {
            list0.add(Base64.decode(arr_s[v], 0));
        }
        return list0;
    }
}

