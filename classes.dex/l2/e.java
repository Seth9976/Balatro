package l2;

import android.util.Base64;
import android.util.JsonWriter;
import j2.b;
import j2.c;
import j2.d;
import j2.f;
import j2.g;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Map;

final class e implements j2.e, g {
    private e a;
    private boolean b;
    private final JsonWriter c;
    private final Map d;
    private final Map e;
    private final d f;
    private final boolean g;

    e(Writer writer0, Map map0, Map map1, d d0, boolean z) {
        this.a = null;
        this.b = true;
        this.c = new JsonWriter(writer0);
        this.d = map0;
        this.e = map1;
        this.f = d0;
        this.g = z;
    }

    @Override  // j2.g
    public g a(String s) {
        return this.g(s);
    }

    @Override  // j2.g
    public g b(boolean z) {
        return this.j(z);
    }

    @Override  // j2.e
    public j2.e c(c c0, Object object0) {
        return this.i(c0.b(), object0);
    }

    @Override  // j2.e
    public j2.e d(c c0, long v) {
        return this.h(c0.b(), v);
    }

    public e e(long v) {
        this.q();
        this.c.value(v);
        return this;
    }

    e f(Object object0, boolean z) {
        int v = 0;
        if(z && this.l(object0)) {
            throw new b(String.format("%s cannot be encoded inline", (object0 == null ? null : object0.getClass())));
        }
        if(object0 == null) {
            this.c.nullValue();
            return this;
        }
        if(object0 instanceof Number) {
            this.c.value(((Number)object0));
            return this;
        }
        if(object0.getClass().isArray()) {
            if(object0 instanceof byte[]) {
                return this.k(((byte[])object0));
            }
            this.c.beginArray();
            if(object0 instanceof int[]) {
                while(v < ((int[])object0).length) {
                    this.c.value(((long)((int[])object0)[v]));
                    ++v;
                }
            }
            else if(object0 instanceof long[]) {
                while(v < ((long[])object0).length) {
                    this.e(((long[])object0)[v]);
                    ++v;
                }
            }
            else if(object0 instanceof double[]) {
                while(v < ((double[])object0).length) {
                    this.c.value(((double[])object0)[v]);
                    ++v;
                }
            }
            else if(object0 instanceof boolean[]) {
                while(v < ((boolean[])object0).length) {
                    this.c.value(((boolean[])object0)[v]);
                    ++v;
                }
            }
            else if(object0 instanceof Number[]) {
                for(int v1 = 0; v1 < ((Number[])object0).length; ++v1) {
                    this.f(((Number[])object0)[v1], false);
                }
            }
            else {
                for(int v2 = 0; v2 < ((Object[])object0).length; ++v2) {
                    this.f(((Object[])object0)[v2], false);
                }
            }
            this.c.endArray();
            return this;
        }
        if(object0 instanceof Collection) {
            this.c.beginArray();
            for(Object object1: ((Collection)object0)) {
                this.f(object1, false);
            }
            this.c.endArray();
            return this;
        }
        if(object0 instanceof Map) {
            this.c.beginObject();
            for(Object object2: ((Map)object0).entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object2;
                Object object3 = map$Entry0.getKey();
                try {
                    this.i(((String)object3), map$Entry0.getValue());
                }
                catch(ClassCastException classCastException0) {
                    throw new b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", object3, object3.getClass()), classCastException0);
                }
            }
            this.c.endObject();
            return this;
        }
        Class class0 = object0.getClass();
        d d0 = (d)this.d.get(class0);
        if(d0 != null) {
            return this.n(d0, object0, z);
        }
        Class class1 = object0.getClass();
        f f0 = (f)this.e.get(class1);
        if(f0 != null) {
            f0.a(object0, this);
            return this;
        }
        if(object0 instanceof Enum) {
            this.g(((Enum)object0).name());
            return this;
        }
        return this.n(this.f, object0, z);
    }

    public e g(String s) {
        this.q();
        this.c.value(s);
        return this;
    }

    public e h(String s, long v) {
        this.q();
        this.c.name(s);
        return this.e(v);
    }

    // 去混淆评级： 低(20)
    public e i(String s, Object object0) {
        return this.g ? this.p(s, object0) : this.o(s, object0);
    }

    public e j(boolean z) {
        this.q();
        this.c.value(z);
        return this;
    }

    public e k(byte[] arr_b) {
        this.q();
        if(arr_b == null) {
            this.c.nullValue();
            return this;
        }
        String s = Base64.encodeToString(arr_b, 2);
        this.c.value(s);
        return this;
    }

    // 去混淆评级： 中等(50)
    private boolean l(Object object0) {
        return object0 == null || object0.getClass().isArray() || object0 instanceof Collection || object0 instanceof Date || object0 instanceof Enum || object0 instanceof Number;
    }

    void m() {
        this.q();
        this.c.flush();
    }

    e n(d d0, Object object0, boolean z) {
        if(!z) {
            this.c.beginObject();
        }
        d0.a(object0, this);
        if(!z) {
            this.c.endObject();
        }
        return this;
    }

    private e o(String s, Object object0) {
        this.q();
        this.c.name(s);
        if(object0 == null) {
            this.c.nullValue();
            return this;
        }
        return this.f(object0, false);
    }

    private e p(String s, Object object0) {
        if(object0 == null) {
            return this;
        }
        this.q();
        this.c.name(s);
        return this.f(object0, false);
    }

    private void q() {
        if(!this.b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        e e0 = this.a;
        if(e0 != null) {
            e0.q();
            this.a.b = false;
            this.a = null;
            this.c.endObject();
        }
    }
}

