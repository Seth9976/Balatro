package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class l {
    static class a implements c {
        private final ByteBuffer a;

        a(ByteBuffer byteBuffer0) {
            this.a = byteBuffer0;
            byteBuffer0.order(ByteOrder.BIG_ENDIAN);
        }

        @Override  // androidx.emoji2.text.l$c
        public long a() {
            return l.c(this.a.getInt());
        }

        @Override  // androidx.emoji2.text.l$c
        public void b(int v) {
            this.a.position(this.a.position() + v);
        }

        @Override  // androidx.emoji2.text.l$c
        public int c() {
            return l.d(this.a.getShort());
        }

        @Override  // androidx.emoji2.text.l$c
        public int d() {
            return this.a.getInt();
        }

        @Override  // androidx.emoji2.text.l$c
        public long e() {
            return (long)this.a.position();
        }
    }

    static class b {
        private final long a;
        private final long b;

        b(long v, long v1) {
            this.a = v;
            this.b = v1;
        }

        long a() {
            return this.a;
        }
    }

    interface c {
        long a();

        void b(int arg1);

        int c();

        int d();

        long e();
    }

    private static b a(c l$c0) {
        long v3;
        l$c0.b(4);
        int v = l$c0.c();
        if(v > 100) {
            throw new IOException("Cannot read metadata.");
        }
        l$c0.b(6);
        int v1 = 0;
        for(int v2 = 0; true; ++v2) {
            v3 = -1L;
            if(v2 >= v) {
                break;
            }
            int v4 = l$c0.d();
            l$c0.b(4);
            v3 = l$c0.a();
            l$c0.b(4);
            if(0x6D657461 == v4) {
                break;
            }
        }
        if(v3 != -1L) {
            l$c0.b(((int)(v3 - l$c0.e())));
            l$c0.b(12);
            long v5 = l$c0.a();
            while(((long)v1) < v5) {
                int v6 = l$c0.d();
                long v7 = l$c0.a();
                long v8 = l$c0.a();
                if(0x456D6A69 != v6 && 1701669481 != v6) {
                    ++v1;
                    continue;
                }
                return new b(v7 + v3, v8);
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    static s.b b(ByteBuffer byteBuffer0) {
        ByteBuffer byteBuffer1 = byteBuffer0.duplicate();
        byteBuffer1.position(((int)l.a(new a(byteBuffer1)).a()));
        return s.b.h(byteBuffer1);
    }

    static long c(int v) {
        return ((long)v) & 0xFFFFFFFFL;
    }

    static int d(short v) {
        return v & 0xFFFF;
    }
}

