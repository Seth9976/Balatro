package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import s.a;

public class g {
    private final int a;
    private final m b;
    private volatile int c;
    private static final ThreadLocal d;

    static {
        g.d = new ThreadLocal();
    }

    g(m m0, int v) {
        this.c = 0;
        this.b = m0;
        this.a = v;
    }

    public void a(Canvas canvas0, float f, float f1, Paint paint0) {
        Typeface typeface0 = paint0.getTypeface();
        paint0.setTypeface(this.b.g());
        canvas0.drawText(this.b.c(), this.a * 2, 2, f, f1, paint0);
        paint0.setTypeface(typeface0);
    }

    public int b(int v) {
        return this.g().h(v);
    }

    public int c() {
        return this.g().i();
    }

    public int d() {
        return this.c;
    }

    public short e() {
        return this.g().k();
    }

    public int f() {
        return this.g().l();
    }

    private a g() {
        ThreadLocal threadLocal0 = g.d;
        a a0 = (a)threadLocal0.get();
        if(a0 == null) {
            a0 = new a();
            threadLocal0.set(a0);
        }
        this.b.d().j(a0, this.a);
        return a0;
    }

    public short h() {
        return this.g().m();
    }

    public short i() {
        return this.g().n();
    }

    public boolean j() {
        return this.g().j();
    }

    public void k(boolean z) {
        this.c = z ? 2 : 1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(super.toString());
        stringBuilder0.append(", id:");
        stringBuilder0.append(Integer.toHexString(this.f()));
        stringBuilder0.append(", codepoints:");
        int v = this.c();
        for(int v1 = 0; v1 < v; ++v1) {
            stringBuilder0.append(Integer.toHexString(this.b(v1)));
            stringBuilder0.append(" ");
        }
        return stringBuilder0.toString();
    }
}

