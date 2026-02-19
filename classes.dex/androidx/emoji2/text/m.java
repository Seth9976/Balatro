package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.util.c;
import java.nio.ByteBuffer;
import s.b;

public final class m {
    static class a {
        private final SparseArray a;
        private g b;

        private a() {
            this(1);
        }

        a(int v) {
            this.a = new SparseArray(v);
        }

        a a(int v) {
            return this.a == null ? null : ((a)this.a.get(v));
        }

        final g b() {
            return this.b;
        }

        void c(g g0, int v, int v1) {
            a m$a0 = this.a(g0.b(v));
            if(m$a0 == null) {
                m$a0 = new a();
                int v2 = g0.b(v);
                this.a.put(v2, m$a0);
            }
            if(v1 > v) {
                m$a0.c(g0, v + 1, v1);
                return;
            }
            m$a0.b = g0;
        }
    }

    private final b a;
    private final char[] b;
    private final a c;
    private final Typeface d;

    private m(Typeface typeface0, b b0) {
        this.d = typeface0;
        this.a = b0;
        this.c = new a(0x400);
        this.b = new char[b0.k() * 2];
        this.a(b0);
    }

    private void a(b b0) {
        int v = b0.k();
        for(int v1 = 0; v1 < v; ++v1) {
            g g0 = new g(this, v1);
            g0.f();
            this.h(g0);
        }
    }

    public static m b(Typeface typeface0, ByteBuffer byteBuffer0) {
        try {
            androidx.core.os.m.a("EmojiCompat.MetadataRepo.create");
            return new m(typeface0, l.b(byteBuffer0));
        }
        finally {
            androidx.core.os.m.b();
        }
    }

    public char[] c() {
        return this.b;
    }

    public b d() {
        return this.a;
    }

    int e() {
        return this.a.l();
    }

    a f() {
        return this.c;
    }

    Typeface g() {
        return this.d;
    }

    void h(g g0) {
        c.e(g0, "emoji metadata cannot be null");
        c.a(g0.c() > 0, "invalid metadata codepoint length");
        int v = g0.c();
        this.c.c(g0, 0, v - 1);
    }
}

