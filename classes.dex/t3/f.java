package t3;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k3.d;
import r3.n;

public final class f {
    public static final class a {
        private a() {
        }

        public a(d d0) {
        }

        public final int a(long v) {
            return (v & 0x2000000000000000L) == 0L ? 1 : 2;
        }

        public final long b(long v, int v1) {
            return v & 0xFFFFFFFFC0000000L | ((long)v1);
        }

        public final long c(long v, int v1) {
            return v & 0xF00000003FFFFFFFL | ((long)v1) << 30;
        }

        public final long d(long v, long v1) [...] // Inlined contents
    }

    public static final class b {
        public final int a;

        public b(int v) {
            this.a = v;
        }
    }

    private volatile Object _next;
    private volatile long _state;
    private final int a;
    private final boolean b;
    private final int c;
    private AtomicReferenceArray d;
    public static final a e;
    private static final AtomicReferenceFieldUpdater f;
    private static final AtomicLongFieldUpdater g;
    public static final l h;

    static {
        f.e = new a(null);
        f.h = new l("REMOVE_FROZEN");
        f.f = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_next");
        f.g = AtomicLongFieldUpdater.newUpdater(f.class, "_state");
    }

    public f(int v, boolean z) {
        this.a = v;
        this.b = z;
        this.c = v - 1;
        this._next = null;
        this._state = 0L;
        this.d = new AtomicReferenceArray(v);
        if(v - 1 > 0x3FFFFFFF || (v & v - 1) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Object object0) {
        int v2;
        int v1;
        do {
            while(true) {
                long v = this._state;
                if((0x3000000000000000L & v) != 0L) {
                    return f.e.a(v);
                }
                v1 = (int)((0xFFFFFFFC0000000L & v) >> 30);
                v2 = this.c;
                if((v1 + 2 & v2) == (((int)(0x3FFFFFFFL & v)) & v2)) {
                    return 1;
                }
                if(this.b || this.d.get(v1 & v2) == null) {
                    break;
                }
                if(this.a < 0x400 || (v1 - ((int)(0x3FFFFFFFL & v)) & 0x3FFFFFFF) > this.a >> 1) {
                    return 1;
                }
            }
        }
        while(!f.g.compareAndSet(this, v, f.e.c(v, v1 + 1 & 0x3FFFFFFF)));
        this.d.set(v1 & v2, object0);
        f f0 = this;
        while((f0._state & 0x1000000000000000L) != 0L) {
            f0 = f0.i().e(v1, object0);
            if(f0 == null) {
                break;
            }
        }
        return 0;
    }

    private final f b(long v) {
        f f0 = new f(this.a * 2, this.b);
        for(int v1 = (int)(0x3FFFFFFFL & v); true; ++v1) {
            int v2 = this.c;
            if((v1 & v2) == (((int)((0xFFFFFFFC0000000L & v) >> 30)) & v2)) {
                break;
            }
            b f$b0 = this.d.get(v2 & v1);
            if(f$b0 == null) {
                f$b0 = new b(v1);
            }
            f0.d.set(f0.c & v1, f$b0);
        }
        f0._state = v & 0xEFFFFFFFFFFFFFFFL;
        return f0;
    }

    private final f c(long v) {
        f f0;
        while((f0 = (f)this._next) == null) {
            f f1 = this.b(v);
            n.a(f.f, this, null, f1);
        }
        return f0;
    }

    public final boolean d() {
        do {
            long v = this._state;
            if(Long.compare(v & 0x2000000000000000L, 0L) != 0) {
                return true;
            }
            if((0x1000000000000000L & v) != 0L) {
                return false;
            }
        }
        while(!f.g.compareAndSet(this, v, v | 0x2000000000000000L));
        return true;
    }

    private final f e(int v, Object object0) {
        Object object1 = this.d.get(this.c & v);
        if(object1 instanceof b && ((b)object1).a == v) {
            this.d.set(v & this.c, object0);
            return this;
        }
        return null;
    }

    public final int f() {
        return ((int)((this._state & 0xFFFFFFFC0000000L) >> 30)) - ((int)(0x3FFFFFFFL & this._state)) & 0x3FFFFFFF;
    }

    public final boolean g() {
        return ((int)(0x3FFFFFFFL & this._state)) == ((int)((this._state & 0xFFFFFFFC0000000L) >> 30));
    }

    private final long h() {
        long v;
        do {
            v = this._state;
            if((v & 0x1000000000000000L) != 0L) {
                return v;
            }
        }
        while(!f.g.compareAndSet(this, v, v | 0x1000000000000000L));
        return v | 0x1000000000000000L;
    }

    public final f i() {
        return this.c(this.h());
    }

    public final Object j() {
        int v2;
        Object object0;
        long v;
        do {
            while(true) {
                v = this._state;
                if((0x1000000000000000L & v) != 0L) {
                    return f.h;
                }
                int v1 = this.c;
                if((((int)((0xFFFFFFFC0000000L & v) >> 30)) & v1) == (((int)(0x3FFFFFFFL & v)) & v1)) {
                    return null;
                }
                object0 = this.d.get(v1 & ((int)(0x3FFFFFFFL & v)));
                if(object0 != null) {
                    break;
                }
                if(this.b) {
                    return null;
                }
            }
            if(object0 instanceof b) {
                return null;
            }
            v2 = ((int)(0x3FFFFFFFL & v)) + 1 & 0x3FFFFFFF;
            if(f.g.compareAndSet(this, v, f.e.b(v, v2))) {
                this.d.set(this.c & ((int)(0x3FFFFFFFL & v)), null);
                return object0;
            }
        }
        while(!this.b);
        f f0 = this;
        do {
            f0 = f0.k(((int)(0x3FFFFFFFL & v)), v2);
        }
        while(f0 != null);
        return object0;
    }

    private final f k(int v, int v1) {
        int v3;
        do {
            long v2 = this._state;
            v3 = (int)(0x3FFFFFFFL & v2);
            if((0x1000000000000000L & v2) != 0L) {
                return this.i();
            }
        }
        while(!f.g.compareAndSet(this, v2, f.e.b(v2, v1)));
        this.d.set(v3 & this.c, null);
        return null;
    }
}

