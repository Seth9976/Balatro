package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class y {
    private final Map a;
    private final Set b;
    private volatile boolean c;

    public y() {
        this.a = new HashMap();
        this.b = new LinkedHashSet();
        this.c = false;
    }

    final void a() {
        this.c = true;
        Map map0 = this.a;
        if(map0 != null) {
            synchronized(map0) {
                for(Object object0: this.a.values()) {
                    y.b(object0);
                }
            }
        }
        Set set0 = this.b;
        if(set0 != null) {
            synchronized(set0) {
                for(Object object1: this.b) {
                    y.b(((Closeable)object1));
                }
            }
        }
        this.d();
    }

    private static void b(Object object0) {
        if(object0 instanceof Closeable) {
            try {
                ((Closeable)object0).close();
            }
            catch(IOException iOException0) {
                throw new RuntimeException(iOException0);
            }
        }
    }

    Object c(String s) {
        Map map0 = this.a;
        return map0 == null ? null : this.a.get(s);
    }

    protected void d() {
    }
}

