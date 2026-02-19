package m2;

import j2.c;
import j2.d;
import j2.e;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Map;

final class f implements e {
    static abstract class a {
        static final int[] a;

        static {
            int[] arr_v = new int[m2.d.a.values().length];
            a.a = arr_v;
            try {
                arr_v[m2.d.a.e.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[m2.d.a.f.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[m2.d.a.g.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

    private OutputStream a;
    private final Map b;
    private final Map c;
    private final d d;
    private final i e;
    private static final Charset f;
    private static final c g;
    private static final c h;
    private static final d i;

    static {
        f.f = Charset.forName("UTF-8");
        f.g = c.a("key").b(m2.a.b().c(1).a()).a();
        f.h = c.a("value").b(m2.a.b().c(2).a()).a();
        f.i = (Map.Entry map$Entry0, e e0) -> {
            Object object0 = map$Entry0.getKey();
            e0.c(f.g, object0);
            Object object1 = map$Entry0.getValue();
            e0.c(f.h, object1);
        };
    }

    f(OutputStream outputStream0, Map map0, Map map1, d d0) {
        this.e = new i(this);
        this.a = outputStream0;
        this.b = map0;
        this.c = map1;
        this.d = d0;
    }

    e b(c c0, double f, boolean z) {
        if(z && f == 0.0) {
            return this;
        }
        this.t(f.r(c0) << 3 | 1);
        this.a.write(f.l(8).putDouble(f).array());
        return this;
    }

    @Override  // j2.e
    public e c(c c0, Object object0) {
        return this.f(c0, object0, true);
    }

    @Override  // j2.e
    public e d(c c0, long v) {
        return this.i(c0, v);
    }

    e e(c c0, float f, boolean z) {
        if(z && f == 0.0f) {
            return this;
        }
        this.t(f.r(c0) << 3 | 5);
        this.a.write(f.l(4).putFloat(f).array());
        return this;
    }

    e f(c c0, Object object0, boolean z) {
        if(object0 == null) {
            return this;
        }
        if(object0 instanceof CharSequence) {
            if(z && ((CharSequence)object0).length() == 0) {
                return this;
            }
            this.t(f.r(c0) << 3 | 2);
            byte[] arr_b = ((CharSequence)object0).toString().getBytes(f.f);
            this.t(arr_b.length);
            this.a.write(arr_b);
            return this;
        }
        if(object0 instanceof Collection) {
            for(Object object1: ((Collection)object0)) {
                this.f(c0, object1, false);
            }
            return this;
        }
        if(object0 instanceof Map) {
            for(Object object2: ((Map)object0).entrySet()) {
                this.n(f.i, c0, ((Map.Entry)object2), false);
            }
            return this;
        }
        if(object0 instanceof Double) {
            return this.b(c0, ((double)(((Double)object0))), z);
        }
        if(object0 instanceof Float) {
            return this.e(c0, ((float)(((Float)object0))), z);
        }
        if(object0 instanceof Number) {
            return this.j(c0, ((Number)object0).longValue(), z);
        }
        if(object0 instanceof Boolean) {
            return this.k(c0, ((Boolean)object0).booleanValue(), z);
        }
        if(object0 instanceof byte[]) {
            if(z && ((byte[])object0).length == 0) {
                return this;
            }
            this.t(f.r(c0) << 3 | 2);
            this.t(((byte[])object0).length);
            this.a.write(((byte[])object0));
            return this;
        }
        Class class0 = object0.getClass();
        d d0 = (d)this.b.get(class0);
        if(d0 != null) {
            return this.n(d0, c0, object0, z);
        }
        Class class1 = object0.getClass();
        j2.f f0 = (j2.f)this.c.get(class1);
        if(f0 != null) {
            return this.o(f0, c0, object0, z);
        }
        if(object0 instanceof m2.c) {
            return this.g(c0, ((m2.c)object0).c());
        }
        return object0 instanceof Enum ? this.g(c0, ((Enum)object0).ordinal()) : this.n(this.d, c0, object0, z);
    }

    public f g(c c0, int v) {
        return this.h(c0, v, true);
    }

    f h(c c0, int v, boolean z) {
        if(z && v == 0) {
            return this;
        }
        m2.d d0 = f.q(c0);
        int v1 = a.a[d0.intEncoding().ordinal()];
        if(v1 != 1) {
            switch(v1) {
                case 2: {
                    this.t(d0.tag() << 3);
                    this.t(v << 1 ^ v >> 0x1F);
                    return this;
                }
                case 3: {
                    this.t(d0.tag() << 3 | 5);
                    this.a.write(f.l(4).putInt(v).array());
                    return this;
                }
                default: {
                    return this;
                }
            }
        }
        this.t(d0.tag() << 3);
        this.t(v);
        return this;
    }

    public f i(c c0, long v) {
        return this.j(c0, v, true);
    }

    f j(c c0, long v, boolean z) {
        if(z && v == 0L) {
            return this;
        }
        m2.d d0 = f.q(c0);
        int v1 = a.a[d0.intEncoding().ordinal()];
        if(v1 != 1) {
            switch(v1) {
                case 2: {
                    this.t(d0.tag() << 3);
                    this.u(v >> 0x3F ^ v << 1);
                    return this;
                }
                case 3: {
                    this.t(d0.tag() << 3 | 1);
                    this.a.write(f.l(8).putLong(v).array());
                    return this;
                }
                default: {
                    return this;
                }
            }
        }
        this.t(d0.tag() << 3);
        this.u(v);
        return this;
    }

    f k(c c0, boolean z, boolean z1) {
        return this.h(c0, ((int)z), z1);
    }

    private static ByteBuffer l(int v) {
        return ByteBuffer.allocate(v).order(ByteOrder.LITTLE_ENDIAN);
    }

    private long m(d d0, Object object0) {
        try(b b0 = new b()) {
            OutputStream outputStream0 = this.a;
            this.a = b0;
            try {
                d0.a(object0, this);
            }
            finally {
                this.a = outputStream0;
            }
            return b0.a();
        }
    }

    private f n(d d0, c c0, Object object0, boolean z) {
        long v = this.m(d0, object0);
        if(z && v == 0L) {
            return this;
        }
        this.t(f.r(c0) << 3 | 2);
        this.u(v);
        d0.a(object0, this);
        return this;
    }

    private f o(j2.f f0, c c0, Object object0, boolean z) {
        this.e.d(c0, z);
        f0.a(object0, this.e);
        return this;
    }

    f p(Object object0) {
        if(object0 == null) {
            return this;
        }
        Class class0 = object0.getClass();
        d d0 = (d)this.b.get(class0);
        if(d0 == null) {
            throw new j2.b("No encoder for " + object0.getClass());
        }
        d0.a(object0, this);
        return this;
    }

    private static m2.d q(c c0) {
        m2.d d0 = (m2.d)c0.c(m2.d.class);
        if(d0 == null) {
            throw new j2.b("Field has no @Protobuf config");
        }
        return d0;
    }

    private static int r(c c0) {
        m2.d d0 = (m2.d)c0.c(m2.d.class);
        if(d0 == null) {
            throw new j2.b("Field has no @Protobuf config");
        }
        return d0.tag();
    }

    // 检测为 Lambda 实现
    private static void s(Map.Entry map$Entry0, e e0) [...]

    private void t(int v) {
        while(((long)(v & 0xFFFFFF80)) != 0L) {
            this.a.write(v & 0x7F | 0x80);
            v >>>= 7;
        }
        this.a.write(v & 0x7F);
    }

    private void u(long v) {
        while((0xFFFFFFFFFFFFFF80L & v) != 0L) {
            this.a.write(((int)v) & 0x7F | 0x80);
            v >>>= 7;
        }
        this.a.write(((int)v) & 0x7F);
    }
}

