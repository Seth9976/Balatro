package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

public final class f {
    static abstract class a {
        static Insets a(int v, int v1, int v2, int v3) {
            return Insets.of(v, v1, v2, v3);
        }
    }

    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public static final f e;

    static {
        f.e = new f(0, 0, 0, 0);
    }

    private f(int v, int v1, int v2, int v3) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
    }

    public static f a(f f0, f f1) {
        return f.b(Math.max(f0.a, f1.a), Math.max(f0.b, f1.b), Math.max(f0.c, f1.c), Math.max(f0.d, f1.d));
    }

    public static f b(int v, int v1, int v2, int v3) {
        return v != 0 || v1 != 0 || v2 != 0 || v3 != 0 ? new f(v, v1, v2, v3) : f.e;
    }

    public static f c(Rect rect0) {
        return f.b(rect0.left, rect0.top, rect0.right, rect0.bottom);
    }

    public static f d(Insets insets0) {
        return f.b(insets0.left, insets0.top, insets0.right, insets0.bottom);
    }

    public Insets e() {
        return a.a(this.a, this.b, this.c, this.d);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            if(f.class != class0 || this.d != ((f)object0).d) {
                return false;
            }
            if(this.a != ((f)object0).a) {
                return false;
            }
            return this.c == ((f)object0).c ? this.b == ((f)object0).b : false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ((this.a * 0x1F + this.b) * 0x1F + this.c) * 0x1F + this.d;
    }

    @Override
    public String toString() {
        return "Insets{left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + '}';
    }
}

