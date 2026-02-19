package k;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;
import jeb.synthetic.FIN;

public class e {
    private final LinkedHashMap a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public e(int v) {
        if(v <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = v;
        this.a = new LinkedHashMap(0, 0.75f, true);
    }

    protected Object a(Object object0) [...] // Inlined contents

    protected void b(boolean z, Object object0, Object object1, Object object2) {
    }

    public final Object c(Object object0) {
        if(object0 != null) {
            synchronized(this) {
                Object object1 = this.a.get(object0);
                if(object1 != null) {
                    ++this.g;
                    return object1;
                }
                ++this.h;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final Object d(Object object0, Object object1) {
        Object object2;
        if(object0 == null || object1 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized(this) {
            ++this.d;
            this.b += this.e(object0, object1);
            object2 = this.a.put(object0, object1);
            if(object2 != null) {
                this.b -= this.e(object0, object2);
            }
        }
        this.g(this.c);
        return object2;
    }

    private int e(Object object0, Object object1) {
        return 1;
    }

    protected int f(Object object0, Object object1) [...] // Inlined contents

    public void g(int v) {
        int v1;
        while(true) {
            synchronized(this) {
                v1 = FIN.finallyOpen$NT();
                if(this.b < 0 || this.a.isEmpty() && this.b != 0) {
                    break;
                }
                if(this.b > v && !this.a.isEmpty()) {
                    Object object0 = this.a.entrySet().iterator().next();
                    Object object1 = ((Map.Entry)object0).getKey();
                    Object object2 = ((Map.Entry)object0).getValue();
                    this.a.remove(object1);
                    this.b -= this.e(object1, object2);
                    ++this.f;
                    FIN.finallyExec$NT(v1);
                    continue;
                }
                FIN.finallyCodeBegin$NT(v1);
            }
            FIN.finallyCodeEnd$NT(v1);
            return;
        }
        FIN.finallyExec$NT(v1);
        throw new IllegalStateException(this.getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    @Override
    public final String toString() {
        int v2;
        synchronized(this) {
            int v1 = this.h + this.g;
            v2 = v1 == 0 ? 0 : this.g * 100 / v1;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", this.c, this.g, this.h, v2);
    }
}

